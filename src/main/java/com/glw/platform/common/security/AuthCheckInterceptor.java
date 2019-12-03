package com.glw.platform.common.security;

import com.glw.platform.common.constant.Constants;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : glw
 * @date : 2019/11/29
 * @time : 15:29
 * @Description : 权限拦截器
 */
@Component
public class AuthCheckInterceptor implements HandlerInterceptor {

    /**
     * http请求进入之前拦截处理
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(Constants.TOKEN_STRING);
        if (StringUtils.isEmpty(token)) {
            throw new Exception("Header 中缺少" + Constants.TOKEN_STRING);
        }
        if (!token.equals(Constants.TOKEN)) {
            throw new Exception("Header 中的" + Constants.TOKEN_STRING + "错误！");
        }
        AccessContext.setToken(token);

        return true;
    }

    /**
     * 请求完执行业务逻辑
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * http请求执行完之后处理
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        AccessContext.clearAccessKey();
    }
}
