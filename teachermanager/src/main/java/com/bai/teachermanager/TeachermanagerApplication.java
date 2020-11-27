package com.bai.teachermanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan({"com.bai"})
@MapperScan("com.bai.teachermanager.mapper")
@EnableTransactionManagement(proxyTargetClass=true)
public class TeachermanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeachermanagerApplication.class, args);
    }

}
