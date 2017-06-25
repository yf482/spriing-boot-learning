package com.yf.springboot.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.yf.springboot.interceptor.MyInterceptor1;
import com.yf.springboot.interceptor.MyInterceptor2;

/**
 * Web开发中，我们除了使用 Filter 来过滤请web求外，还可以使用Spring提供的HandlerInterceptor（拦截器）。

HandlerInterceptor 的功能跟过滤器类似，但是提供更精细的的控制能力：在request被响应之前、request被响应之后、视图渲染之前以及request全部结束之后。我们不能通过拦截器修改request内容，但是可以通过抛出异常（或者返回false）来暂停request的执行。

实现 UserRoleAuthorizationInterceptor 的拦截器有： 
ConversionServiceExposingInterceptor 
CorsInterceptor 
LocaleChangeInterceptor 
PathExposingHandlerInterceptor 
ResourceUrlProviderExposingInterceptor 
ThemeChangeInterceptor 
UriTemplateVariablesHandlerInterceptor 
UserRoleAuthorizationInterceptor

其中 LocaleChangeInterceptor 和 ThemeChangeInterceptor 比较常用。
配置拦截器也很简单，Spring 为什么提供了基础类WebMvcConfigurerAdapter ，我们只需要重写 addInterceptors 方法添加注册拦截器。
实现自定义拦截器只需要3步： 
1、创建我们自己的拦截器类并实现 HandlerInterceptor 接口。 
2、创建一个Java类继承WebMvcConfigurerAdapter，并重写 addInterceptors 方法。 
3、实例化我们自定义的拦截器，然后将对像手动添加到拦截器链中（在addInterceptors方法中添加）。 
PS：本文重点在如何在Spring-Boot中使用拦截器，关于拦截器的原理请大家查阅资料了解。


 * @Description 
 * @author yunfeng
 * @date 2017年6月24日 下午4:30:48 
 * @version V1.0.0
 */
@Configuration
public class MyWebAppConfigurer  extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");
        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}