package com.silklee.video.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;

import java.util.Date;
import java.util.List;

@Data
@SuperBuilder
public class User {

    private int id;

    private String name;

    @JsonIgnore
    private String pwd;

    private String headImg;

    @JsonIgnore
    private String phone;

    private Date createTime;

    private List<VideoOrder> videoOrderList;

    @Tolerate
    public User() {
        super();
    }

}
