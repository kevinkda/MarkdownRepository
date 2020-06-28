package com.kevinkda.test.spring.boot.springbootrestfulcrud01.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆检查
 *
 * @author Kevin KDA on 2020/6/28 23:25
 * @version 1.0.0
 * @project maven-test-01
 * @package com.kevinkda.test.spring.boot.springbootrestfulcrud01.component
 * @classname LoginHandlerInterceptor
 * @apiNote <p></p>
 * @since 1.0.0
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    // 目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if (user == null) {
            request.setAttribute("msg", "没有权限访问，请先登录");
            request.getRequestDispatcher("index.html").forward(request, response);
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
