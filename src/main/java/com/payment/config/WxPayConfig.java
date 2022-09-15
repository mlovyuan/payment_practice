package com.payment.config;

import com.wechat.pay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
import com.wechat.pay.contrib.apache.httpclient.auth.PrivateKeySigner;
import com.wechat.pay.contrib.apache.httpclient.auth.ScheduledUpdateCertificatesVerifier;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Credentials;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Validator;
import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
import lombok.Data;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;

@Configuration
@PropertySource("classpath:wxpay.properties")
@ConfigurationProperties(prefix = "wxpay")
@Data
public class WxPayConfig {
    // 商戶號
    private String mchId;

    // 商戶API證書序號
    private String mchSerialNo;

    // 商戶私密金鑰文件
    private String privateKeyPath;

    // APIv3金鑰
    private String apiV3Key;

    // APPID
    private String appid;

    // 微信伺服器地址
    private String domain;

    // 接收結果通知地址
    private String notifyDomain;

    private PrivateKey getPrivateKey(String filename) {
        try {
            return PemUtil.loadPrivateKey(new FileInputStream(filename));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("私鑰文件不存在", e);
        }
    }

    @Bean
    public ScheduledUpdateCertificatesVerifier getVerifier() {
        //私密金鑰簽名物件
        PrivateKeySigner privateKeySigner = new PrivateKeySigner(mchSerialNo, getPrivateKey(privateKeyPath));

        //身份認證物件
        WechatPay2Credentials wechatPay2Credentials = new WechatPay2Credentials(mchId, privateKeySigner);

        // 使用定時更新的簽名驗證器，不需要傳入憑證
        return new ScheduledUpdateCertificatesVerifier(
                wechatPay2Credentials,
                apiV3Key.getBytes(StandardCharsets.UTF_8));
    }

    public CloseableHttpClient getWxPayClient(ScheduledUpdateCertificatesVerifier verifier) {
        WechatPayHttpClientBuilder builder = WechatPayHttpClientBuilder.create()
                .withMerchant(mchId, mchSerialNo, getPrivateKey(privateKeyPath))
                .withValidator(new WechatPay2Validator(verifier));
        // ... 接下來，你仍然可以通過builder設置各種參數，來配置你的HttpClient

        // 通過WechatPayHttpClientBuilder構造的HttpClient，會自動的處理簽名和驗簽，並進行證書自動更新
        return builder.build();
    }
}

