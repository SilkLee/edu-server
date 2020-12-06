package com.silklee.video.controller;

import com.silklee.common.bean.Resp;
import com.silklee.video.model.entity.VideoOrder;
import com.silklee.video.model.request.VideoOrderRequest;
import com.silklee.video.service.VideoOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("api/v1/pub/order")
public class VideoOrderController {

    @Resource
    private VideoOrderService videoOrderService;

    /**
     * 下单接口
     * @return
     */
    @RequestMapping("save")
    public Resp saveOrder(@RequestBody VideoOrderRequest videoOrderRequest, HttpServletRequest request){

        Integer userId = (Integer) request.getAttribute("user_id");

        int rows = videoOrderService.save(userId, videoOrderRequest.getVideoId());

        return rows == 0 ? Resp.error(-1,"下单失败"): Resp.ok("下单成功");
    }

    /**
     * 订单列表
     * @param request
     * @return
     */
    @GetMapping("list")
    public Resp listOrder(HttpServletRequest request){
        Integer userId = (Integer) request.getAttribute("user_id");

        List<VideoOrder> videoOrderList = videoOrderService.listOrderByUserId(userId);

        return Resp.ok(videoOrderList);
    }
}
