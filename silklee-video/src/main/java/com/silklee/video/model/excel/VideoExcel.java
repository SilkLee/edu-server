package com.silklee.video.model.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
public class VideoExcel {

    @ExcelProperty(index = 0, value = "视频标题")
    private String title;

    @ExcelProperty(index = 1, value = "概述")
    private String summary;

    @ExcelProperty(index = 2, value = "封面图")
    private String coverImg;

    @ExcelProperty(index = 3, value = "价格,分")
    private int price;

    @ExcelProperty(index = 4, value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createTime;

    @ExcelProperty(index = 5, value = "评分")
    private Double point;

}
