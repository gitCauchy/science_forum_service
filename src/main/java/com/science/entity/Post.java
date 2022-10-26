package com.science.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description: Post 实体类
 * @Author: Cauchy
 * @CreateTime: 2022/10/5
 * <p>
 * Cauchy:
 * 这里使用了 mybatis plus，注解说明如下 :
 * 1. @TableName : 实体对应的表名
 * 2. @TableId : 主键注解 value 为值，type 为主键类型， Auto - 数据库自增主键，Input - 自行输入， ID_Worker
 * 分布式全局唯一长类型， UUID - 32 位字符串， NONE 无状态 ， ID_WORKER_STR : 分布式全局位唯一 ID 字符串
 * 3. @TableField : 解决实体类属性名称和数据库字段名不匹配，数据库 create_time 实体类 createtime (未驼峰)
 * 4. @TableLogic: 逻辑删除注解
 * 5. @EnumValue : 枚举注解
 */
@Data
@TableName("f_post")
public class Post {
    /**
     * 主键 id
     */
    @TableId(value = "id", type = IdType.AUTO)
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
