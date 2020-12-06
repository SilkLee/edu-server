package com.silklee.video.model.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;

import java.util.Date;

@Data
@SuperBuilder
public class Episode {

    private Integer id;
    
    private String title;

    private Integer num;

    private Integer ordered;


    private String playUrl;


    private Integer chapterId;


    private Integer free;

    private Integer videoId;

    private Date createTime;

    @Tolerate
    public Episode() {
        super();
    }
}
