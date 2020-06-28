package com.kevinkda.test.spring.boot.springbootrestfulcrud01.config;

import com.kevinkda.test.spring.boot.springbootrestfulcrud01.component.LoginHandlerInterceptor;
import com.kevinkda.test.spring.boot.springbootrestfulcrud01.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Kevin KDA on 2020/6/28 16:49
 * @version 1.0.0
 * @project maven-test-01
 * @package com.kevinkda.test.spring.boot.springbootrestfulcrud01.config
 * @classname MyMvcConfig
 * @apiNote <p></p>
 * @since 1.0.0
 */
// 使用 WebMvcConfigurerAdapter 可以来扩展 SpringMVC 的功能
// 不要接管 Springmvc
// @EnableWebMvc
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
////        super.addViewControllers(registry);
////        浏览器发送 /index 请求来到 login
//        registry.addViewController("/").setViewName("login");
//        registry.addViewController("/index").setViewName("login");
//        registry.addViewController("/index.html").setViewName("login");
//    }

    //    所有的 WebMvcConfigurerAdapter 组件都会一起起作用
//    将组件注册在容器
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
//                super.addViewControllers(registry);
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login.html").setViewName("index");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
////                super.addInterceptors(registry);
////                静态资源: *.css, *.js
////                Springbootl 已经做好了静态资源映
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("index.html", "/", "/user/login");
//            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
