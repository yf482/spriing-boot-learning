package com.yf.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class ListenerDemo implements ServletContextListener {
    private Logger logger = LoggerFactory.getLogger(ListenerDemo.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("IndexListener contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}