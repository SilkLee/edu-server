package com.silklee.video.service;

import com.silklee.video.model.entity.Video;
import com.silklee.video.model.dto.VideoDTO;
import com.silklee.video.model.entity.VideoBanner;

import java.util.List;
import java.util.Map;

public interface VideoService {

    List<Video> showVideoList();
    Video selectById(int id);
    List<Video> showVideoListByTitleAndPoint(String titile, double point);
    int addVideo(VideoDTO videoDTO);
    int addBatch(List<VideoDTO> videoDTOList);
    int updateVideo(Video video);
    int deleteVideo(Map<String, Object> map);
    List<VideoBanner> listBanner();
    Video findDetailById(int videoId);
}
