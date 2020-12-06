package com.silklee.common.bean;

import com.silklee.common.exception.ServiceExceptionEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class Resp<T> {

    @ApiModelProperty(name = "code", value = "响应状态码")
    private Integer code;

    @ApiModelProperty(name = "msg", value = "提示消息")
    private String msg;

    @ApiModelProperty(name = "data", value = "响应数据")
    private T data;

    public Resp(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Resp() {
    }

    public Resp(T data) {
        this.data = data;
    }

    public static <T> Resp<T> ok() {
        Resp<T> resp = new Resp<T>(null);
        resp.setCode(0);//操作成功
        resp.setMsg("操作成功");
        return resp;
    }

    public static <T> Resp<T> ok(T data) {
        Resp<T> resp = new Resp<T>(data);
        resp.setCode(0);//操作成功
        resp.setMsg("操作成功");
        return resp;
    }


    public static Resp error() {
        Resp<String> resp = new Resp<String>(null);
        resp.setCode(1);//操作失败
        resp.setMsg("操作失败");
        return resp;
    }

    public static Resp error(int code, String message) {
        Resp<String> resp = new Resp<String>(null);
        resp.setCode(code);//操作失败
        resp.setMsg(message);
        return resp;
    }

    public static <T> Resp<T> error(ServiceExceptionEnum exceptionEnum) {
        Resp<T> resp = new Resp<T>(null);
        resp.setCode(exceptionEnum.getCode());//操作失败
        resp.setMsg(exceptionEnum.getMessage());
        return resp;
    }

    public static <T> Resp<T> msg(String msg) {
        Resp<T> resp = new Resp<T>(null);
        resp.setMsg(msg);
        return resp;
    }

    public static <T> Resp<T> code(Integer code) {
        Resp<T> resp = new Resp<T>(null);
        resp.setCode(code);
        return resp;
    }

}
