package com.silklee.video.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;

import java.util.Date;
import java.util.List;

@Data
@SuperBuilder
public class Video {
    @Tolerate
    public Video() {
        super();
    }

    private int id;

    private String title;

    private String summary;

    private int price;

    private String coverImg;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createTime;

    private Double point;

    private List<Chapter> chapterList;

}
