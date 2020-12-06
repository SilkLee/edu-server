package com.silklee.video.controller;

import com.silklee.common.bean.Resp;
import com.silklee.common.exception.BizExceptionCommonEnum;
import com.silklee.video.model.entity.User;
import com.silklee.video.model.request.LoginRequest;
import com.silklee.video.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 视频控制器
 */
@RestController
@RequestMapping("/api/v1/pri/user")
public class UserController {


    @Resource
    public UserService userService;

    /**
     * 注册接口
     *
     * @param userInfo
     * @return
     */
    @PostMapping("register")
    public Resp register(@RequestBody Map<String, String> userInfo) {

        int rows = userService.save(userInfo);

        return rows == 1 ? Resp.ok() : Resp.error(BizExceptionCommonEnum.REGISTER_ERROR);

    }


    /**
     * 登录接口
     *
     * @param loginRequest
     * @return
     */
    @PostMapping("login")
    public Resp login(@RequestBody LoginRequest loginRequest) {

        String token = userService.findByPhoneAndPwd(loginRequest.getPhone(), loginRequest.getPwd());

        return token == null ? Resp.error(500, "登录失败，账号密码错误") : Resp.ok(token);

    }


    /**
     * 根据用户id查询用户信息
     *
     * @param request
     * @return
     */
    @GetMapping("find_by_token")
    public Resp findUserInfoByToken(HttpServletRequest request) {

        Integer userId = (Integer) request.getAttribute("user_id");

        if (userId == null) {
            return Resp.error(500, "查询失败");
        }

        User user = userService.findByUserId(userId);

        return Resp.ok(user);

    }

}
