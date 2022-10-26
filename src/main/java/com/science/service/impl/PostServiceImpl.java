package com.science.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.science.entity.Comment;
import com.science.entity.HotListRecord;
import com.science.entity.Post;
import com.science.mapper.PostMongoMapper;
import com.science.mapper.PostMySQLMapper;
import com.science.service.HotListRecordService;
import com.science.service.PostService;
import com.science.system.utils.RedisUtil;
import com.science.vo.response.CommentVo;
import com.science.vo.response.PostVo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description: Post Service 实现类
 * @Author: Cauchy
 * @CreateTime: 2022/10/6
 */
@Service
@AllArgsConstructor
public class PostServiceImpl extends ServiceImpl<PostMySQLMapper, Post> implements PostService {

    PostMySQLMapper postMySQLMapper;

    PostMongoMapper postMongoMapper;

    HotListRecordService hotListRecordService;

    RedisUtil redisUtil;

    @Override
    public List<PostVo> getTop20HotPost() {

        List<Post> topPosts = postMongoMapper.findTop20HotPosts();
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

    @Override
    public int getHotDegree(LocalDateTime createTime, int comments, int like, int scan) {
        LocalDate now = LocalDate.now();
        int distance = Period.between(now, createTime.toLocalDate()).getDays();
        return (scan + 2 * distance * like + 3 * distance * comments);
    }

    @Override
    public void synchronizeHotList() {
        List<Post> topPosts = postMongoMapper.findTop20HotPosts();
        topPosts.forEach(post -> {
            String key = "post_" + post.getId().toString();
            redisUtil.put(key, "author", post.getAuthor());
            redisUtil.put(key, "like", post.getLike());
            redisUtil.put(key, "content", post.getContent());
            redisUtil.put(key, "title", post.getTitle());
            redisUtil.put(key, "scan", post.getScan());
            redisUtil.put(key, "createTime", post.getCreateTime());
        });
    }

    @Override
    public List<Post> getHotList() {
        List<Post> hostList = new ArrayList<>();
        String hotIdList = redisUtil.get(LocalDate.now().toString());
        // 22|33|44|55|66|
        String[] ids = hotIdList.split("\\|");
        List<Post> postList = new ArrayList<>();
        // 从 redis 中取出热榜数据
        for (String id : ids) {
            // key : post_id
            Map<Object, Object> postMap = redisUtil.entries("post_" + id);
            Post post = new Post();
            post.setAuthor((String) postMap.get("author"));
            post.setContent((String) postMap.get("content"));
            post.setTitle((String) postMap.get("title"));
            post.setLike((int) postMap.get("like"));
            post.setScan((int) postMap.get("scan"));
            post.setCreateTime((LocalDateTime) postMap.get("createTime"));
            post.setId(Long.valueOf(id));
            postList.add(post);
        }
        return postList;
    }

    /**
     * 保存 Post 热榜 Id 持久化到 MySQL 中
     */
    private void saveHotIdList(List<Post> topPosts) {
        StringBuilder sb = new StringBuilder();
        topPosts.forEach(post -> {
            sb.append(post.getId());
            sb.append("|");
        });
        HotListRecord hotListRecord = new HotListRecord();
        hotListRecord.setDate(LocalDate.now());
        hotListRecord.setHotIdList(sb.toString());
        hotListRecordService.save(hotListRecord);
    }
}
