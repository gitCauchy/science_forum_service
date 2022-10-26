package com.science.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.science.entity.HotListRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface HotListRecordMapper extends BaseMapper<HotListRecord> {
}
