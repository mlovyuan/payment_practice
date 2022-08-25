package com.payment.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan("com.payment.mapper")
@EnableTransactionManagement
public class MyBatisPlusConfig {
}
