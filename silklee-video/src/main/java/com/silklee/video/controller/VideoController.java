package com.silklee.video.controller;

import cn.hutool.extra.spring.SpringUtil;
import com.silklee.common.bean.Resp;
import com.silklee.video.config.MidTableConfig;
import com.silklee.video.dao.VideoMapper;
import com.silklee.video.model.dto.VideoDTO;
import com.silklee.video.model.entity.Video;
import com.silklee.video.service.AsyncService;
import com.silklee.video.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 视频控制器
 */
@RestController
@RequestMapping("/api/v1/pub/video")
public class VideoController {
    private static final Logger logger = LoggerFactory.getLogger(VideoController.class);

    @Resource
    private VideoService videoService;

    @Resource
    private MidTableConfig midTableConfig;

//    @Resource
//    private WeChatConfig weChatConfig;

    @GetMapping("list")
    public Resp<List<Video>> list() {
        Object midtablemapper1 = midTableConfig.getMap().get("midtablemapper1");
        VideoMapper videoMapper = SpringUtil.getBean(VideoMapper.class);
        List<Video> list =  videoMapper.listVideo();
        return Resp.ok(list);
    }

    @PostMapping("save_video_chapter")
    public Resp saveVideoChapter(@RequestBody Video video){

        System.out.println(video.toString());
//        System.out.println(weChatConfig.getPayAppid());
        return Resp.ok(video);
    }

    @GetMapping("show_video/{id}")
    public Resp selectVideoById(@PathVariable int id) {

        return Resp.ok(videoService.selectById(id));
    }

    @GetMapping("showVideosByTitleAndPoint")
    public Resp showVideoListByTitleAndPoint(@RequestParam(value="title") String title, @RequestParam(value="point") double point) {
        return Resp.ok(videoService.showVideoListByTitleAndPoint(title, point));
    }

    @PostMapping("addVideo")
    public Resp addVideo(@RequestBody VideoDTO videoDTO) {
        return Resp.ok(videoService.addVideo(videoDTO));
    }

    @PostMapping("addVideoBatch")// @RequestBody List<VideoDTO> videoDTOList
    public Resp addBatch() {
        VideoDTO videoDTO  = VideoDTO.builder()
                .title("Nodejs教程零基础入门到项目实战前端视频教程")
                .summary("https://xdvideo-file.oss-cn-shenzhen.aliyuncs.com/video/2020/node/%E5%AE%98%E7%BD%91%E8%AF%A6%E6%83%85%E5%9B%BE-node.png")
                .coverImg("https://xdvideo-file.oss-cn-shenzhen.aliyuncs.com/video/2020/node/%E5%AE%98%E7%BD%91%E4%B8%BB%E5%9B%BE-node.png")
                .price(6980)
                .createTime(new Date())
                .point(8.70)
                .build();
        List<VideoDTO> videoDTOS = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            videoDTOS.add(videoDTO);
        }
        return Resp.ok(videoService.addBatch(videoDTOS));
    }

    @PutMapping("updateVideo")
    public Resp updateVideo(@RequestBody Video video) {
        return Resp.ok(videoService.updateVideo(video));
    }

    @DeleteMapping("deleteVideo")
    public Resp deleteVideo(@RequestBody Map<String, Object> map) {
        return Resp.ok(videoService.deleteVideo(map));
    }

    @GetMapping("list_banner")
    public Resp indexBanner() {
        return Resp.ok(videoService.listBanner());
    }

    @GetMapping("find_detail_by_id")
    public Resp findDetailById(@RequestParam(value = "video_id", required = true) int videoId) {
        return Resp.ok(videoService.findDetailById(videoId));
    }

    @Resource
    private AsyncService asyncService;

    @RequestMapping("/testAsync")
    public String submit(){
        logger.info("start submit");

        //调用service层的任务
        asyncService.executeAsync();

        logger.info("end submit");

        return "success";
    }
}
