package com.silklee.video.model.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;

import java.util.Date;

@Data
@SuperBuilder
public class VideoBanner {

    private Integer id;

    private String url;

    private String img;

    private Date createTime;

    private Integer weight;

    @Tolerate
    public VideoBanner() {
        super();
    }
}
