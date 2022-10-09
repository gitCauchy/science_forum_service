package com.science.mapper;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    private MongoTemplate mongoTemplate;



}