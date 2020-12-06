//package com.silklee.video.filter;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.silklee.common.bean.Resp;
//import com.silklee.common.exception.BizExceptionCommonEnum;
//import com.silklee.video.model.entity.User;
//import com.silklee.video.service.impl.UserServiceImpl;
//import org.apache.commons.lang3.StringUtils;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
////@WebFilter(urlPatterns = "/api/v1/pri/*", filterName = "loginFilter")
//public class LoginFilter implements Filter {
//
//    private static final ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("init loginfilter");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("dofilter loginfilter");
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        String token = request.getHeader("token");
//        if (StringUtils.isEmpty(token)) {
//            request.getParameter("token");
//        }
//
//        if (!StringUtils.isEmpty(token)) {
//            // 判断token是否合法
//            User user = UserServiceImpl.sessionMap.get(token);
//            if (user != null) {
//                filterChain.doFilter(servletRequest, servletResponse);
//            } else {
//                Resp error = Resp.error(BizExceptionCommonEnum.TOKEN_ABNORMAL);
//                String jsonStr = objectMapper.writeValueAsString(error);
//                renderJson(response, jsonStr);
//            }
//        } else {
//            Resp error = Resp.error(BizExceptionCommonEnum.AUTH_NULL);
//            String jsonStr = objectMapper.writeValueAsString(error);
//            renderJson(response, jsonStr);
//        }
//    }
//
//    private void renderJson(HttpServletResponse response, String json) {
//
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json");
//
//        try (PrintWriter writer = response.getWriter()) {
//            writer.print(json);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("destroy loginfilter");
//    }
//}
