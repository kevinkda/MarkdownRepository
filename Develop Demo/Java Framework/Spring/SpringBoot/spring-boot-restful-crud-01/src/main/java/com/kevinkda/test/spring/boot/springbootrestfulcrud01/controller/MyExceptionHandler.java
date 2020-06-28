package com.kevinkda.test.spring.boot.springbootrestfulcrud01.controller;

import com.kevinkda.test.spring.boot.springbootrestfulcrud01.exception.UserNotException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin KDA on 2020/6/29 00:35
 * @version 1.0.0
 * @project maven-test-01
 * @package com.kevinkda.test.spring.boot.springbootrestfulcrud01.controller
 * @classname MyExceptionHandler
 * @apiNote <p></p>
 * @since 1.0.0
 */
@ControllerAdvice
public class MyExceptionHandler {

    // 浏览器客户端返回的都是json
//    @ResponseBody
//    @ExceptionHandler(UserNotException.class)
//    public Map<String, Object> handleException(Exception e){
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", "user.notexist");
//        map.put("message", e.getMessage());
//
//        return map;
//    }

    // 浏览器客户端返回的都是json
    @ExceptionHandler(UserNotException.class)
    public String handleException(Exception e, HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();
        // 传入我们自己的错误状态码
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", "user.notexist");
        map.put("message", "用户出错了");

        request.setAttribute("ext", map);

        return "forward:/error";
    }
}

