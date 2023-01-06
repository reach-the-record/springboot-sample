package com.example.springbootsample.config.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ApiInterceptor implements HandlerInterceptor {

    /* Interceptor
     *
     * Controller에 request와 response가 발생하기 전 중간에서 가로채는 역할
     * preHandle - 요청 처리 전 (Controller 넘어가기 전)
     * postHandle - 응답 처리 전에 발생 (Controller 실행 후)
     * afterCompletion - 최종 완료 이후
     * Filter의 경우 DispatcherServlet 실행 전, Interceptor는 DispatcherServlet이 실행된 후 처리.
     * Interceptor의 경우 Config로 따로 설정하여 모든 요청 또는 원하는 요청을 가로채서 실행할 수 있다.
     *
     * */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
