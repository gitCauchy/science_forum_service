package com.science.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.science.entity.Post;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description: Post Mapper
 * @Author: Cauchy
 * @CreateTime: 2022/10/5
 */
@Mapper
public interface PostMapper extends BaseMapper<Post> {
}
