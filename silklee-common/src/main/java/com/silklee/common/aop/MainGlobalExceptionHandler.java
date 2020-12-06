package com.silklee.common.aop;


import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.silklee.common.bean.Resp;
import com.silklee.common.exception.BizException;
import com.silklee.common.exception.BizExceptionCommonEnum;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;


/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 */
@RestControllerAdvice
@Order(-200)
public class MainGlobalExceptionHandler {

    private final Log log = LogFactory.get();

    /**
     * 拦截校验异常
     */
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Resp validException(ConstraintViolationException e) {
        return Resp.error(10000, e.getMessage());
    }

    /**
     * 拦截未知的运行时异常
     */
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Resp notFount(RuntimeException e) {

        /**
         * 拦截数据库异常（超出数据长度）
         * Cause: com.microsoft.sqlserver.jdbc.SQLServerException: 将截断字符串或二进制数据。
         */
        if (e.getMessage().contains("将截断字符串或二进制数据。")) {
            log.error("数据库长度超出限制:", e);
            return Resp.error(BizExceptionCommonEnum.DATABASE_LIMIT);
        }

        log.error("运行时异常:", e);
        return Resp.error(BizExceptionCommonEnum.SERVER_ERROR);

    }

    /**
     * redis 连接失败
     */
    @ExceptionHandler(RedisConnectionFailureException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Resp redisConnectionFailure(RuntimeException e) {
        //getRequest().setAttribute("tip", "Redis连接失败异常");
        log.error("运行时异常:", e);
        return Resp.error(BizExceptionCommonEnum.REDIS_CONNECTION_FAILURE);
    }


    /**
     * 拦截业务异常
     */
    @ExceptionHandler(BizException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Resp business(BizException e) {
        log.error("业务异常:{}", e.getMessage());
        return Resp.error(e.getCode(), e.getMessage());
    }

}
