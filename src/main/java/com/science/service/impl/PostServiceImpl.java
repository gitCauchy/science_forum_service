package com.science.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.science.entity.Post;
import com.science.service.PostService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/**
 * @Description: Post Service 实现类
 * @Author: Cauchy
 * @CreateTime: 2022/10/6
 */
@Service
public class PostServiceImpl implements PostService {

    @Override
    public boolean saveBatch(Collection<Post> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Post> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Post> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Post entity) {
        return false;
    }

    @Override
    public Post getOne(Wrapper<Post> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Post> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<Post> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<Post> getBaseMapper() {
        return null;
    }

    @Override
    public Class<Post> getEntityClass() {
        return null;
    }
}
