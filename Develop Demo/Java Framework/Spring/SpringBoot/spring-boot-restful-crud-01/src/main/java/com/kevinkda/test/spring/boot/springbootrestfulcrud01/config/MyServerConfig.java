package com.kevinkda.test.spring.boot.springbootrestfulcrud01.config;

import com.kevinkda.test.spring.boot.springbootrestfulcrud01.web.filter.MyFilter;
import com.kevinkda.test.spring.boot.springbootrestfulcrud01.web.listener.MyListener;
import com.kevinkda.test.spring.boot.springbootrestfulcrud01.web.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author Kevin KDA on 2020/6/29 00:24
 * @version 1.0.0
 * @project maven-test-01
 * @package com.kevinkda.test.spring.boot.springbootrestfulcrud01.config
 * @classname MyServerConfig
 * @apiNote <p></p>
 * @since 1.0.0
 */
@Configuration
public class MyServerConfig {

    // 注册三大组件
    @Bean
    public ServletRegistrationBean myServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener() {
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }
}
