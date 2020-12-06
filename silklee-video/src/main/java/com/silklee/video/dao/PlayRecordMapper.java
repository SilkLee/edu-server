package com.silklee.video.dao;

import com.silklee.video.model.entity.PlayRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlayRecordMapper {

    int saveRecord(PlayRecord playRecord);

}
