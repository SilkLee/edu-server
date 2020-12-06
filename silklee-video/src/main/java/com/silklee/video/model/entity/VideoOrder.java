package com.silklee.video.model.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;

import java.util.Date;

@Data
@SuperBuilder
public class VideoOrder {

    private int id;

    private String outTradeNo;

    private int  state;

    private Date createTime;

    private int  totalFee;

    private int videoId ;

    private String videoTitle;

    private String videoImg;

    private int userId;

    private User user;

    private Video video;

    @Tolerate
    public VideoOrder() {
        super();
    }

}
