package com.science.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDate;

@Data
@TableName("f_hot_list_record")
public class HotListRecord {
    /**
     * 主键 id
     */
    private int id;
    /**
     * 日期
     */
    private LocalDate date;
    /**
     * post id 列表
     */
    private String hotIdList;
}
