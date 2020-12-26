package com.yp.gmall.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * create with IDEA
 *
 * @Auther: yinpei
 * @Date : 2020/07/18/上午 9:28
 * @Description;
 **/
@SpringBootApplication
@MapperScan(basePackages = "com.yp.gmall.manage.mapper")

public class GmallManageServiceApplication {
    public static void main(String[] args) {
        //@MapperScan(basePackages = "com.yp.gmall.manage.mapper")
        //CrossOrigin跨域注解 ，不同的IP地址和端口 前后端相互访问时需要加上跨域访问注解
        SpringApplication.run(GmallManageServiceApplication.class, args);
    }
}


