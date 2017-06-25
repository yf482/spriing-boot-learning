package com.yf.springboot;

import javax.servlet.annotation.WebServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.DispatcherServlet;

import com.yf.springboot.filter.FilterDemo;
import com.yf.springboot.listener.ListenerDemo;
import com.yf.springboot.servlet.MyServlet1;

/**

Web开发使用 Controller 基本上可以完成大部分需求，但是我们还可能会用到 Servlet、Filter、Listener、Interceptor 等等。

当使用spring-Boot时，嵌入式Servlet容器通过扫描注解的方式注册Servlet、Filter和Servlet规范的所有监听器（如HttpSessionListener监听器）。 
Spring boot 的主 Servlet 为DispatcherServlet，其默认的url-pattern为“/”。也许我们在应用中还需要定义更多的Servlet，该如何使用SpringBoot来完成呢？

在spring boot中添加自己的Servlet有两种方法， 
一、代码注册通过ServletRegistrationBean、 FilterRegistrationBean 和ServletListenerRegistrationBean 获得控制。 
也可以通过实现 ServletContextInitializer 接口直接注册。
二、在SpringBootApplication 上使用@ServletComponentScan注解后，Servlet、Filter、Listener 可以直接通过 @WebServlet、@WebFilter、@WebListener 注解自动注册，无需其他代码。
 * @Description 这里使用@SpringBootApplication只是一个springBoot应用程序
 * @author Administrator
 * @date 2017-4-21 下午9:08:54 
 * @version V1.3.1
 */
@SpringBootApplication
//使用方式二：包扫描支持通配符，更符合springboot全注解风格推荐 ，对应servlet 类加@WebServlet(urlPatterns="/myServlet2/*",description="Servlet的说明")
//@ServletComponentScan("com.yf.spring.*.servlet")
@ServletComponentScan("com.yf.springboot.*")
//@ServletComponentScan("com.yf.spring.servlet")
public class Application{
	
	/**
     * 使用servlet方式一: 通过bean注册Servlet.不需要添加注解：@ServletComponentScan
     * 而且servlet不用添加注解@WebServlet,servlet数量多建议使用注解扫描
     * @return
     */
//    @Bean
//    public ServletRegistrationBean myServlet1(){
//
//           return new ServletRegistrationBean(new MyServlet1(),"/myServlet1/*");
//    }
	
		/*@Bean
	    public FilterRegistrationBean indexFilterRegistration() {
	        FilterRegistrationBean registration = new FilterRegistrationBean(new FilterDemo());
	        registration.addUrlPatterns("/");
	        return registration;
	    }
	    @Bean
	    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
	        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
	        servletListenerRegistrationBean.setListener(new ListenerDemo());
	        return servletListenerRegistrationBean;
	    }*/
	    
	    /**
	     * 大家在使用的时候有没有发觉，其实SpringBoot在使用SpringMvc的时候不需要配置DispatcherServlet的，因为已经自动配置了， 但是如果想要加一些初始配置参数如何解决，方案如下：
	     * @Description 
	     * @param dispatcherServlet
	     * @return
	     */
	   /* @Bean
	    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
	        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
	        registration.addUrlMappings("*.do");
	        registration.addUrlMappings("*.json");
	        return registration;
	    }*/
	public static void main ( String[] args )
    {
    	SpringApplication.run(Application.class, args);  
    }

}
