package com.silklee.video.controller;

import com.alibaba.excel.EasyExcel;
import com.silklee.video.model.entity.Video;
import com.silklee.video.model.excel.VideoExcel;
import com.silklee.video.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;
import java.util.concurrent.Callable;

@RestController
@RequestMapping("/api/v1/pub/excel")
public class ExcelController {
    private static final Logger logger = LoggerFactory.getLogger(ExcelController.class);
    @Resource
    private VideoService videoService;

    @GetMapping("exportVideoExcel")
    public String exportVideoExcel(HttpServletResponse httpServletResponse) {
        logger.info("主线程开始====>" + Thread.currentThread().getName());
        Callable<String> callable = () -> {
            logger.info("异步线程开始====>" + Thread.currentThread().getName());
            long start = System.currentTimeMillis();

            // 查询数据
            List<Video> videos =  videoService.showVideoList();

            // 导出数据 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
            httpServletResponse.setContentType("application/vnd.ms-excel");
            httpServletResponse.setCharacterEncoding("utf-8");
            httpServletResponse.setHeader("Content-disposition", "attachment;filename=demo.xlsx");

            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
            httpServletResponse.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            EasyExcel.write(httpServletResponse.getOutputStream(), VideoExcel.class).sheet("视频表").doWrite(videos);

            logger.info("异步线程结束====>" + Thread.currentThread().getName());
            logger.info("excel导出耗时：{}", System.currentTimeMillis() - start);
            return "success";
        };
        logger.info("主线程结束====>" + Thread.currentThread().getName());
        try {
            return callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "failed";
    }
}
