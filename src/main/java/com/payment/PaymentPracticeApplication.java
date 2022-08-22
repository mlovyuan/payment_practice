package com.payment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@SpringBootApplication
public class PaymentPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentPracticeApplication.class, args);
    }

}
