package com.science.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("f_user")
public class User {
    /**
     * 主键 ID
     */
    private long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 是否锁定
     */
    private Boolean isLocked;
}
