package com.silklee.video.service;

import com.silklee.video.model.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 新增用户
     * @param userInfo
     * @return
     */
    int save(Map<String, String> userInfo);
    String findByPhoneAndPwd(String phone, String pwd);
    User findByUserId(Integer userId);
    <E> void show(E e);
}
