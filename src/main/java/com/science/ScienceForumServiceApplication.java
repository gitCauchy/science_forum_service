package com.science;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.science.mapper"})
public class ScienceForumServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScienceForumServiceApplication.class, args);
    }
}
