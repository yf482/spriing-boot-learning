package com.yf.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yf.springboot.exception.MyException;


/**
 * 统一异常处理
 * 虽然，Spring Boot中实现了默认的error映射，但是在实际应用中，上面你的错误页面对用户来说并不够友好，我们通常需要去实现我们自己的异常提示
 * 创建全局异常处理类：通过使用@ControllerAdvice定义统一的异常处理类，而不是在每个Controller中逐个定义
 * 实现error.html页面展示：在templates目录下创建error.html，将请求的URL和Exception对象的message输出。
 * 通过实现上述内容之后，我们只需要在Controller中抛出Exception，当然我们可能会有多种不同的Exception。然后在@ControllerAdvice类中，根据抛出的具体Exception类型匹配@ExceptionHandler中配置的异常类型来匹配错误映射和处理。
 * 返回JSON格式
 * 在上述例子中，通过@ControllerAdvice统一定义不同Exception映射到不同错误处理页面。而当我们要实现RESTful API时，返回的错误是JSON格式的数据，而不是HTML页面，这时候我们也能轻松支持。
 * 本质上，只需在@ExceptionHandler之后加入@ResponseBody，就能让处理函数return的内容转换为JSON格式。
 * @ExceptionHandler用来定义函数针对的异常类型，最后将Exception对象和请求URL映射到error.html中
 * spring boot异常发生处理
 * 需要@ControllerAdvice 和 @ExceptionHandler 、@ResponseBody
 * @Description 
 * @author yunfeng
 * @date 2017-4-21 下午9:06:28 
 * @version V1.0.0
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

	   @RequestMapping("/hello")
	    public String hello() throws Exception {
	        throw new Exception("发生错误");
	    }

	    @RequestMapping("/json")
	    public String json() throws MyException {
	        throw new MyException("发生错误2");
	    }
}