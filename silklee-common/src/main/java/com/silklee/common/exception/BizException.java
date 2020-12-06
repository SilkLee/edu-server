package com.silklee.common.exception;


import org.springframework.validation.BindingResult;

/**
 * 封装业务异常
 */
public class BizException extends RuntimeException {

    private Integer code;

    private String msg;

    public BizException(ServiceExceptionEnum bizExceptionEnum) {
        this.code = bizExceptionEnum.getCode();
        this.msg = bizExceptionEnum.getMessage();
    }

    public BizException(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }

    public BizException(BindingResult result) {
        this.code = 99999;
        this.msg = result.getFieldError().getDefaultMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return msg;
    }

    public void setMessage(String message) {
        this.msg = message;
    }
}
