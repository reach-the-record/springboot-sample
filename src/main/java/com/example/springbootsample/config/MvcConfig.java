package com.example.springbootsample.config;

import com.example.springbootsample.config.interceptor.ApiInterceptor;
import com.example.springbootsample.config.interceptor.BaseInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    BaseInterceptor baseInterceptor() { return new BaseInterceptor(); }
    @Bean
    ApiInterceptor apiInterCeptor() { return new ApiInterceptor(); }

    /*
    * 설정해 둔 apiInterceptor를 적용시킨다.
    * 각 상황에 맞게 적용이 가능하다.
    * 일반적인 케이스에 interceptor A, 일부 케이스만 interceptor B 형태로도 조합이 가능
    * */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] patterns = new String[] { "/**" }; // 모든 경우에 interceptor로 가로채도록
        String[] excludePatterns = new String[] { "/api/**", "/exclude" }; //interceptor가 제외할 패턴 정의
        String[] apiPatterns = new String[] { "/api/**"};

        registry.addInterceptor(apiInterCeptor()).addPathPatterns(patterns).excludePathPatterns(excludePatterns);
        registry.addInterceptor(baseInterceptor()).addPathPatterns(apiPatterns);
    }
}
