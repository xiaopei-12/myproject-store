package com.yp.gmail.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yp.gmail.user.mapper")
public class GmailUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmailUserApplication.class, args);
    }

}
