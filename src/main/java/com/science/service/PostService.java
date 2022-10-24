package com.science.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.science.entity.Post;
import com.science.vo.response.PostVo;

import java.util.List;

/**
 * @Description: Post Service 层
 * @Author: Cauchy
 * @CreateTime: 2022/10/6
 */
public interface PostService extends IService<Post> {
    /**
     * 获取热度排名前 20 的热帖
     *
     * @return List<PostVo>
     */
    List<PostVo> getTop20HotPost();
}
