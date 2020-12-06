package com.silklee.common.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;

/**
 * 数据库基类
 */
@Data
@SuperBuilder
@ApiModel
public class BaseEntity {

    /**
     * 构造函数
     */
    @Tolerate
    public BaseEntity() {
        super();
    }

    /**
     * 乐观锁
     */
    @Version
    //@TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("乐观锁")
    private Integer revision;

    /**
     * 创建者id
     */
    @ApiModelProperty("创建者id")
    private Long createdBy;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间")
    private LocalDateTime createdTime;

    /**
     * 更新者id
     */
    @ApiModelProperty("更新者id")
    private Long updatedBy;


    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("更新时间")
    private LocalDateTime updatedTime;

    /**
     * 是否启用(Y:启用，N:停用)
     */
    @ApiModelProperty("是否启用(Y:启用，N:停用)")
    private String enableFlag;

    /**
     * 是否删除：N-未删除，Y-已删除
     */
    @ApiModelProperty("是否删除：N-未删除，Y-已删除")
    private String delFlag;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;
}
