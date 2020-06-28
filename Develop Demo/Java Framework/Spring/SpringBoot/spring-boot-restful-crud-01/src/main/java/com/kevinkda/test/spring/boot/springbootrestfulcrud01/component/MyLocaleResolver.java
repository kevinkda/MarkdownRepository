package com.kevinkda.test.spring.boot.springbootrestfulcrud01.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 可以在连接上携帯区域信息
 *
 * @author Kevin KDA on 2020/6/28 22:04
 * @version 1.0.0
 * @project maven-test-01
 * @package com.kevinkda.test.spring.boot.springbootrestfulcrud01.component
 * @classname MyLocaleResolver
 * @apiNote <p></p>
 * @since 1.0.0
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取请求参数中的语言
        String language = httpServletRequest.getParameter("l");
        //没带区域信息参数就用系统默认的
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(language)) {
            //提交的参数是zh_CN （语言代码_国家代码）
            String[] split = language.split("_");

            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {
    }
}
