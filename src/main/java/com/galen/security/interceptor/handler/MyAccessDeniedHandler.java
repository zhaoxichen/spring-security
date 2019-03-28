package com.galen.security.interceptor.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galen.security.pojo.RespBean;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: Galen
 * @Date: 2019/3/27-17:36
 * @Description: Denied是拒签的意思
 * 此处我们可以自定义403响应的内容,让他返回我们的错误逻辑提示
 **/
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse resp,
                       AccessDeniedException e) throws IOException {
        resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        RespBean error = RespBean.error("权限不足，请联系管理员!");
        out.write(new ObjectMapper().writeValueAsString(error));
        out.flush();
        out.close();
    }
}
