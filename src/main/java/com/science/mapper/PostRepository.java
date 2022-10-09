package com.science.mapper;

import com.science.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, Long> {


    List<Post> findAllByAuthorId(Long authorId);
}
