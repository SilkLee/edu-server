
package com.silklee.common.exception;


/**
 * @Description 业务异常的枚举
 */
public enum BizExceptionCommonEnum implements ServiceExceptionEnum {


    /**
     * 通用
     */
    SERVER_ERROR(500, "服务器异常"),
    DATA_NOT_EXIST(100, "数据不存在"),
    ERROR_JSONEXCEPTION(101, "数据格式非法"),
    AUTH_ERROR(102, "认证异常"),
    CHRACTER_ERROR(103, "数据编码转换错误"),
    PARAM_ERROR(104, "参数错误"),
    SMS_ERROR(105, "短信发送错误"),
    AUTH_NULL(106, "token为空"),
    AUTH_BEARER_ERRER(107, "token头部异常"),
    TOKEN_ABNORMAL(109, "token过期"),
    TOKEN_GENERATE_ERRER(110, "token生成异常"),
    FLAG_ERRER(111, "标识参数错误"),
    NO_OPERATION_PERMISSION(112, "无权限操作"),
    TOKEN_USER_ERROR(113, "token用户异常"),
    REGISTER_ERROR(114, "注册失败，请重试"),

    /**
     * 数据库异常行
     */
    DATABASE_ERROR(201, "数据库异常"),
    DATABASE_LIMIT(202, "数据库长度超出限制"),
    REDIS_CONNECTION_FAILURE(203, "Redis连接失败"),

    ;


    BizExceptionCommonEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }


    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
