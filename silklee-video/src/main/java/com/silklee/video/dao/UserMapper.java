package com.silklee.video.dao;

import com.silklee.video.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    int save(User user);

    User findByPhone(@Param("phone") String phone);


    User findByPhoneAndPwd(@Param("phone") String phone, @Param("pwd") String pwd);

    User findByUserId(@Param("user_id") Integer userId);
}
