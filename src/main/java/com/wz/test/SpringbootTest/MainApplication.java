package com.wz.test.SpringbootTest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableCaching
@MapperScan("com.wz.test.SpringbootTest.mybatis.mapper")
public class MainApplication {

    @RequestMapping("/")
    String home(){
        return "hello！zabbix";
    }

    public static void main(String[] args) {

        SpringApplication.run(MainApplication.class,args);

    }
}
