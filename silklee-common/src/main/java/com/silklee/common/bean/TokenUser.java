package com.silklee.common.bean;

import lombok.Data;

@Data
public class TokenUser {

    //用户id
    private Long uid;

    //客户id
    private Long cid;

    //推送id
    private String pid;

    @Override
    public String toString() {
        return "uid=" + uid +
                ", cid=" + cid +
                ", pid=" + pid
                ;
    }
}
