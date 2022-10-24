package com.science.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.science.entity.Comment;
import com.science.entity.Post;
import com.science.mapper.PostMongoMapper;
import com.science.mapper.PostMySQLMapper;
import com.science.service.PostService;
import com.science.vo.response.CommentVo;
import com.science.vo.response.PostVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @Description: Post Service 实现类
 * @Author: Cauchy
 * @CreateTime: 2022/10/6
 */
@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    PostMySQLMapper postMySQLMapper;

    PostMongoMapper postMongoMapper;

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

    @Override
    public List<PostVo> getTop20HotPost() {
        List<Post> topPosts = postMongoMapper.findAll();
        List<PostVo> postVoList = new ArrayList<>();
        topPosts.forEach(post -> {
            PostVo postVo = new PostVo();
            postVo.setAuthor(post.getAuthor());
            postVo.setContent(post.getContent());
            postVo.setLike(post.getLike());
            postVo.setTitle(post.getTitle());
            List<CommentVo> commentVos = new ArrayList<>();
            List<Comment> comments = post.getComments();
            comments.forEach(comment -> {
                CommentVo commentVo = new CommentVo();
                commentVo.setAuthor(comment.getAuthor());
                commentVo.setLike(comment.getLike());
                commentVo.setContent(comment.getContent());
                commentVos.add(commentVo);
            });
            postVo.setComments(commentVos);
            postVoList.add(postVo);
        });
        return postVoList;
    }
}
