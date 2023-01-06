package com.example.springbootsample.config.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DefaultFilter implements Filter {

    /* Filter Config 클래스
    * SpringBoot 2.x 버전까지는 javax.servlet 사양으로 설계되어있으나, 3.x 버전부터 jakarta.servlet으로 변경 되었다.
    * Java EE를 Jakarta EE로 이관하면서 변경된 것으로 확인된다.
    * Filter - Web Application context에서 동작하기 때문에, 스프링 Context에 접근하기 어렵다. request 시 DispatcherServlet 앞 단에서 동작
    * 정확히는 Tomcat Context에서 DispatcherServlet으로 진입 전, DispatcherServlet에서 response 진출 후 동작
    * 용도 - 보안 관련 공통 작업 / 모든 요청에 대한 로깅, 감사 / request, response header 세팅, 이미지/데이터 압축, 문자열 인코딩 등
    *
    * init() - 필터가 Web Container에 생성될 때 실행,
    * doFilter() - request, response가 필터를 거쳐갈 때 실행. filterChain에 따라 다음 필터로 넘어간다.
    * destroy() - 필터 소멸 시 실행.
    *
    * */

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*"); // CrossOrigin 헤더 추가
        httpServletResponse.setHeader("Pragma", "no-cache"); // HTTP/1.0 헤더 옵션, Cache-Control과 같은 역할
        httpServletResponse.setHeader("Cache-Control", "no-cache"); // HTTP/1.1 이후 헤더 옵션 말 그대로 cache를 제어한다.
        httpServletResponse.setHeader("Accept-Charset", "UTF-8"); //해당 프로젝트는 UTF-8로 구성하기 때문에 UTF-8 charset을 인가.

        chain.doFilter(request, httpServletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
