package com.yf.springboot.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yf.springboot.entity.User;

/**
 * 访问此类的 url: http://localhost:8080/test/list-all
 * filter和interceptor一起生效
 * 访问servlet只有filter生效
 * 
 * 注解全名：
 * @Description 使用RestController 相当于@Controller 和 @RequestBody
 * @author Administrator
 * @date 2017-4-21 下午9:06:28
 * @version V1.3.1
 */
// 相当于 @Controller + @ResponseBody
// 该注解 方法method 返回类型是String时候则返回string,返回对象时候则讲json_encode 该对象的json字符串
@Controller
@RequestMapping("/test")
public class HelloController {

	Logger logger = LoggerFactory.getLogger(HelloController.class);
	/**
	 * 请求：http://localhost:8800/test/list-all 
	 * http方式：get 请求返回contentType:
	 * 请求responseBody: [ { "createTime": 1495641815658, "id": 1, "name":
	 * "zhangsan" }, { "createTime": 1495641815658, "id": 1, "name": "zhangsan"
	 * }, { "createTime": 1495641815658, "id": 1, "name": "zhangsan" } ]
	 * 
	 * @Description
	 * @param user
	 * @return
	 */
	@GetMapping("/list-all")
	@ResponseBody
	public List<User> listAll() {
		ArrayList<User> list = new ArrayList<User>();
		User user = new User(1, "zhangsan", new Date());
		User user2 = new User(1, "zhangsan", new Date());
		User user3 = new User(1, "zhangsan", new Date());
		list.add(user);
		list.add(user2);
		list.add(user3);
		return list;

	}
	
	/**
	 * 很明显，要使用Sevlet的一些API，只要直接将其作为参数传入即可。你需要request，就传入request， 需要session，就传入session。springmvc支持传入的Sevlet原生api一共有以下这些： 
		1. HttpServletRequest 
		2. HttpServletResponse 
		3. HttpSession 
		4. Java.security.Principal 
		5. Locale 
		6. InputStream 
		7. OutputStream 
		8. Reader 
		9. Writer
	 * controller中使用httpRequest
	 * @Description 
	 * @param request
	 * @param response
	 * @param session
	 * @param out
	 * @throws IOException
	 */
	 @RequestMapping("/testServletAPI")
	 public void testServletAPI(HttpServletRequest request,
            HttpServletResponse response,HttpSession session,
            Writer  out) throws IOException{
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
        out.write("hello");
	 }
	 
	 
	 @RequestMapping("/testServletAPI2")
	 public void testServletAPI2(@RequestBody String body, HttpServletRequest request,HttpServletResponse response) throws IOException{
		logger.info("body: " + body);
		logger.info("request: " + request);
		logger.info("response: " + response);
		PrintWriter out = response.getWriter();
//		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		//不设置charset application/x-www-form-urlencoded;charset=ISO-8859-1
//		response.setContentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		response.setContentType("application/x-www-form-urlencoded;charset=UTF-8");
		//默认是charset=ISO-8859-1
		response.setCharacterEncoding("UTF-8");
		out.write("id=123&name=abc");
	 }
}
