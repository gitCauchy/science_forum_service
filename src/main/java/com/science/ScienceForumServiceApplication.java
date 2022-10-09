package com.science;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class ScienceForumServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScienceForumServiceApplication.class, args);
    }
}
