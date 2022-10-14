package com.science.mapper;

import com.science.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PostRepositoryTest {

    @Autowired
    PostMongoMapper postRepository;

    @Test
    public void testMethod(){
        List<Post> all = postRepository.findAll();
        System.out.println(all);
    }



}