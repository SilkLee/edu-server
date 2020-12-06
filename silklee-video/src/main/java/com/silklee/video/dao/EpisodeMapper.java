package com.silklee.video.dao;

import com.silklee.video.model.entity.Episode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EpisodeMapper {
    Episode findFirstEpisodeByVideoId(@Param("video_id") int videoId);
}
