package com.science.system.utils;

import com.science.entity.Post;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class RedisUtilTest {

    @Autowired
    RedisUtil redisUtil;

    @Test
    void set() {
        Post post = new Post();
        post.setAuthor("Cauchy");
        post.setContent("test");
        redisUtil.put("post", "author", post.getAuthor());
        redisUtil.put("post", "content", post.getContent());
    }

    @Test
    void get() {
        Object obj = redisUtil.get("post", "author");
        System.out.println((String) obj);
    }
}