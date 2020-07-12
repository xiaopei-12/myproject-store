package com.yp.gmall.user;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Administrator
 */
@SpringBootApplication
@MapperScan("com.yp.gmall.user.mapper")
class GmallUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallUserApplication.class,args);
    }
}
