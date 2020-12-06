package com.silklee.video.service.impl;

import com.silklee.video.config.BaseCache;
import com.silklee.video.config.CacheKeyManager;
import com.silklee.video.dao.VideoMapper;
import com.silklee.video.model.dto.VideoDTO;
import com.silklee.video.model.entity.Video;
import com.silklee.video.model.entity.VideoBanner;
import com.silklee.video.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class VideoServiceImpl implements VideoService {

    @Resource
    private VideoMapper videoMapper;

    @Resource
    private BaseCache baseCache;

    private static final Logger logger = LoggerFactory.getLogger(VideoServiceImpl.class);

    @Override
    public List<Video> showVideoList() {
        try {
            Object cacheObj = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_VIDEL_LIST, () -> {
                List<Video> videoList = videoMapper.listVideo();
                return videoList;
            });
            if (cacheObj instanceof List) {
                List<Video> videoList = (List<Video>) cacheObj;
                return videoList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //可以返回兜底数据，业务系统降级-》SpringCloud专题课程
        return null;
    }

    @Override
    public List<VideoBanner> listBanner() {
        try {
            Object cacheObj = baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_BANNER_KEY, () -> {
                List<VideoBanner> bannerList = videoMapper.listVideoBanner();
                System.out.println("从数据库里面找轮播图列表");
                return bannerList;
            });
            if (cacheObj instanceof List) {
                List<VideoBanner> bannerList = (List<VideoBanner>) cacheObj;
                return bannerList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Video findDetailById(int videoId) {
        //单独构建一个缓存key，每个视频的key是不一样的
        String videoCacheKey = String.format(CacheKeyManager.VIDEO_DETAIL, videoId);
        try {
            Object cacheObject = baseCache.getOneHourCache().get(videoCacheKey, () -> {
                // 需要使用mybaits关联复杂查询
                Video video = videoMapper.findDetailById(videoId);
                return video;
            });
            if (cacheObject instanceof Video) {
                Video video = (Video) cacheObject;
                return video;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Video selectById(int id) {
        return null;
    }

    @Override
    public List<Video> showVideoListByTitleAndPoint(String titile, double point) {
        return null;
    }

    @Override
    public int addVideo(VideoDTO videoDTO) {
        return 0;
    }

    @Override
    public int addBatch(List<VideoDTO> videoDTOS) {

        int index = videoDTOS.size() / 10000;
        int num = 0;
        for (int i = 0; i < index; i++) {
            //stream流表达式，skip表示跳过前i*10000条记录，limit表示读取当前流的前10000条记录
            num = videoMapper.addBatch(videoDTOS.stream().skip(i * 10000).limit(10000).collect(Collectors.toList()));
            logger.info("excel导出耗时：{}条", num);
        }
        return index;
    }

    @Override
    public int updateVideo(Video video) {
        return 0;
    }

    @Override
    public int deleteVideo(Map<String, Object> map) {
        return 0;
    }
}
