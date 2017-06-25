package com.yf.springboot.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @Description 
 * @author yunfeng
 * @date 2017年6月24日 下午4:10:41 
 * @version V1.0.0
 */
@WebFilter(urlPatterns = "/*", filterName = "FilterDemo")
public class FilterDemo implements Filter {
    Logger logger = LoggerFactory.getLogger(Filter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("init IndexFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("doFilter IndexFilter");
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}