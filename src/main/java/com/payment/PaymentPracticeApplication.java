package com.payment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PaymentPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentPracticeApplication.class, args);
    }

}
