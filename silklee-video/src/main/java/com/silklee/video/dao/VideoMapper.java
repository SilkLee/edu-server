package com.silklee.video.dao;

import com.silklee.video.annotations.MidTableMapping;
import com.silklee.video.model.dto.VideoDTO;
import com.silklee.video.model.entity.Video;
import com.silklee.video.model.entity.VideoBanner;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
@MidTableMapping(name = "midtablemapper1")
public interface VideoMapper {

    /**
     * 查询视频列表
     *
     * @return
     */
    List<Video> listVideo();

    /**
     * 首页轮播图列表
     *
     * @return
     */
    List<VideoBanner> listVideoBanner();

    /**
     * 查询视频详情
     *
     * @param videoId
     * @return
     */
    Video findDetailById(@Param("video_id") int videoId);

    /**
     * 简单查询视频信息
     *
     * @param videoId
     * @return
     */
    Video findById(@Param("video_id") int videoId);

    /**
     * 批量插入
     *
     * @param videoDTOList
     * @return
     */
    int addBatch(List<VideoDTO> videoDTOList);
}
