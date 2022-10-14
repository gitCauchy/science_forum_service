package com.science.mapper;

import com.science.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface PostMongoMapper extends MongoRepository<Post, Long> {

}
