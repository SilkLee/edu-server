package com.silklee.common.utils;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.silklee.common.bean.TokenUser;
import com.silklee.common.enums.RedisHeaderEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TokenUtil {

    @Autowired
    private RedisUtil redisUtil;

    private static final Log log = LogFactory.get();


    /**
     * 获取当前用户
     *
     * @return
     */
    public TokenUser getUser() {
        String token = getToken();
        if (StringUtils.isNotEmpty(token)) {
            String userStr = redisUtil.get(RedisHeaderEnum.TOKEN.getCode() + token);
            log.info("【从Redis获取后】-userStr:{}", userStr);

            if (!StringUtils.isEmpty(userStr)) {
                TokenUser user = JSONUtil.toBean(userStr, TokenUser.class);
                log.info("【将Redis的值转换后】-user:{}", user);
                return user;
            }
        }
        return new TokenUser();
    }

    /**
     * 获取当前用户的token
     */
    public String getToken() {
        if (null == HttpKit.getRequest()) {
            return null;
        }
        final String requestHeader = HttpKit.getRequest().getHeader("Authorization");
        log.info("requestHeader Authorization-{}", requestHeader);
        String authToken = null;
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            authToken = requestHeader.substring(7);
        }
        log.info("authToken-{}", authToken);
        return authToken;
    }

}
