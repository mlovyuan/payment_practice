package com.payment;

import com.payment.config.WxPayConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.security.PrivateKey;

@SpringBootTest
class PaymentPracticeApplicationTests {

    @Resource
    private WxPayConfig wxPayConfig;

//    @Test
//    void testGetPrivateKey() {
//        PrivateKey privateKey = wxPayConfig.getPrivateKey(wxPayConfig.getPrivateKeyPath());
//        System.out.println(privateKey);
//    }

}
