package com.tutu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@MapperScan("com.tutu.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class TutuApplication {

    public static void main(String[] args) {
        SpringApplication.run(TutuApplication.class, args);
    }

}
