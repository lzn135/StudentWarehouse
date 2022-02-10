package com.Lmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 13
 */
@MapperScan("com.Lmall.dao")
@SpringBootApplication
public class LMallApplication {
    public static void main(String[] args) {
        SpringApplication.run(LMallApplication.class, args);
    }
}
