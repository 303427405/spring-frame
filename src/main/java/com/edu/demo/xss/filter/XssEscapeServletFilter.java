package com.edu.demo.xss;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import java.io.IOException;

/**
 * xss过滤器
 * Created By zhangyufei on 2019/7/4
 */
public class XssEscapeServletFilter implements Filter {

    @Autowired
    private XSSFilterFactoryBean xssFilterFactoryBean;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if(false){
            /**覆盖request 取值*/
            XssEscapeServletFilterWrapper requestFilterWrapper = new XssEscapeServletFilterWrapper(request,xssFilterFactoryBean);
            chain.doFilter(requestFilterWrapper, response);
        }else{
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
