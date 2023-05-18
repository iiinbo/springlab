package com.kbstar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 스프링부트의 컨피그레이션(기본환경)을 변경하기 위해 만든 java class이다.
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    // @value : import할 때, 두번째 보이는 spring으로 해줄 것
    @Value("${imgdir}")
    String imgdir;
    @Value("${logdir}")
    String logdir;

    // 이미지 또는 로그 쌓이는 폴더명 수정해줄 것! (애플리케이션에 기재한 것과 동일하게. img -> uimg)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uimg/**").addResourceLocations(imgdir);
        registry.addResourceHandler("/logs/**").addResourceLocations(logdir);
    }

}