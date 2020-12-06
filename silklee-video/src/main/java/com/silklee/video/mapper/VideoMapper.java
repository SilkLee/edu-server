//package com.silklee.video.mapper;
//
//import com.silklee.video.model.domain.Video;
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//
//@Repository
//public class VideoMapper {
//
//    private static Map<Integer, Video> videoMap = new HashMap<>();
//
//    static {
//        Video.builder().id(1).title("Java基础课程，jdk8~13新特性").build();
//        Video.builder().id(2).title("SpringBoot2.X零基础到实战").build();
//        Video.builder().id(3).title("微服务SpringCLoud全家桶").build();
//        Video.builder().id(4).title("SpringBoot实战微信支付课程").build();
//        Video.builder().id(5).title("小滴课堂面试专题第一季，300道大厂连环问").build();
//    }
//
//
//
//    public List<Video> listVideo(){
//
//        List<Video> list = new ArrayList<>();
//        list.addAll(videoMap.values());
//
//        return  list;
//    }
//
//
//}
