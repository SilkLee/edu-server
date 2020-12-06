package com.silklee.video.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;

import java.util.Date;

@Data
@SuperBuilder
public class VideoDTO {
    private int id;

    private String title;

    private String summary;

    private int price;

    private String coverImg;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createTime;

    private double point;

    @Tolerate
    public VideoDTO() {
        super();
    }
}
