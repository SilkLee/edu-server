package com.silklee.video.model.request;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import lombok.experimental.Tolerate;

/**
 * 登录 request
 */
@Data
@SuperBuilder
public class LoginRequest {

    private String phone;

    private String pwd;

    @Tolerate
    public LoginRequest() {
        super();
    }
}
