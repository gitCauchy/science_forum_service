package com.science.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description: Post 实体类
 * @Author: Cauchy
 * @CreateTime: 2022/10/5
 *
 */
@Data
public class Post {
    /**
     * 主键 id
     */
    private Long id;
    /**
     * 内容
     */
    private String content;
    /**
     * 标题
     */
    private String title;
    /**
     * 作者
     */
    private Long authorId;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 评论
     */
    private List<Comment> comments;
    /**
     * 点赞
     */
    private int like;
    /**
     * 状态
     */
    private Boolean state;
    /**
     * 作者
     */
    private String author;
    /**
     * 热度
     */
    private int hotDegree;
    /**
     * 浏览
     */
    private int scan;
}
