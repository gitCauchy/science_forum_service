package com.science.mapper;

import com.science.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface PostMongoMapper extends MongoRepository<Post, Long> {

    List<Post> findAllOrderByHotDegree();
}
