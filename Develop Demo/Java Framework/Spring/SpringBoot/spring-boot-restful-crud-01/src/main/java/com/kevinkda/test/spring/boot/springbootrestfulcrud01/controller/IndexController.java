package com.kevinkda.test.spring.boot.springbootrestfulcrud01.controller;

import com.kevinkda.test.spring.boot.springbootrestfulcrud01.exception.UserNotException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Kevin KDA on 2020/6/28 16:55
 * @version 1.0.0
 * @project maven-test-01
 * @package com.kevinkda.test.spring.boot.springbootrestfulcrud01.controller
 * @classname IndexController
 * @apiNote <p></p>
 * @since 1.0.0
 */
@Controller
public class IndexController {
//    @RequestMapping({"/","index.html"})
//    public String index(){
//        return "index";
//    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user) {
        if (user.equals("aaa")){
            throw new UserNotException();
        }
        return "Hello World";
    }

//    @RequestMapping({"/", "index.html"})
//    public String index() {
//        return "login";
//    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        // classpath://templates/success.html
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "success";
    }
}
