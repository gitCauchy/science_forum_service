package com.science.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("f_comment")
public class Comment {
    /**
     * 主键 ID
     */
    private long id;
    /**
     * 内容
     */
    private String content;
    /**
     * 发布者 ID
     */
    private long userId;
    /**
     * post ID
     */
    private long postId;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 状态
     */
    private int status;
    /**
     * 作者
     */
    private String author;
    /**
     * 点赞
     */
    private int like;
}
