package com.silklee.video.exception;

import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * 自定义异常类
 */
@Data
public class XDException extends RuntimeException{

    private Integer code;

    private String msg;

    public XDException(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    @Tolerate
    public XDException() {
        super();
    }
}
