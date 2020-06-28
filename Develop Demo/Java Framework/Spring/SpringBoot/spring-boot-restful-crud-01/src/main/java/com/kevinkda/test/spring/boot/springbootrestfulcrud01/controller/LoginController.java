package com.kevinkda.test.spring.boot.springbootrestfulcrud01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Kevin KDA on 2020/6/28 22:54
 * @version 1.0.0
 * @project maven-test-01
 * @package com.kevinkda.test.spring.boot.springbootrestfulcrud01.controller
 * @classname LoginController
 * @apiNote <p></p>
 * @since 1.0.0
 */
@Controller
public class LoginController {
    @PostMapping(value = "/user/login")
//    @DeleteMapping
//    @PutMapping
//    @GetMapping
//    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
//            登陆成功，防止表单重复提交，可以重定向到主页
//            return "dashboard";
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        } else {
            map.put("msg", "用户名或密码错误");
            return "login";
        }
    }
}
