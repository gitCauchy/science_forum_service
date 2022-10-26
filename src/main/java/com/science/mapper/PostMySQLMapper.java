package com.science.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.science.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Description: Post Mapper
 * @Author: Cauchy
 * @CreateTime: 2022/10/5
 */
@Mapper
@Repository
public interface PostMySQLMapper extends BaseMapper<Post> {
}
