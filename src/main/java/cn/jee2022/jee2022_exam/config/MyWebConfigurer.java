package cn.jee2022.jee2022_exam.config;

import cn.jee2022.jee2022_exam.interceptor.CharacterInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfigurer implements WebMvcConfigurer {
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    WebMvcConfigurer.super.addViewControllers(registry);
    registry.addViewController("/file/input").setViewName("/file/input");
    registry.addViewController("sec/Main").setViewName("Main");
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    WebMvcConfigurer.super.addInterceptors(registry);
    registry.addInterceptor(new CharacterInterceptor()).addPathPatterns("/sec/Main");
  }
}
