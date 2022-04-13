package com.example.crud_vue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.crud_vue.mapper")
public class CrudVueApplication {

    public static void main(String[] args) {

        SpringApplication.run(CrudVueApplication.class, args);
    }

}
