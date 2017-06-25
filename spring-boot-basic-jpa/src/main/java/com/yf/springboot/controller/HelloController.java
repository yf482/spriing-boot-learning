package com.yf.springboot.controller;

import java.util.Date;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.yf.springboot.entity.User;
import com.yf.springboot.entity.User2;


/**
 * spring boot restController风格请求
 * import org.springframework.web.bind.annotation.RequestMapping;
 * import org.springframework.web.bind.annotation.RestController;
 * import org.springframework.web.bind.annotation.ResponseBody;
 * @Description 使用RestController 相当于@Controller 和 @RequestBody
 * @author yunfeng
 * @date 2017-4-21 下午9:06:28 
 * @version V1.0.0
 */
//@Controller @ResponseBody
@RestController
@RequestMapping("/restTest")
//@EnableAutoConfiguration  
public class HelloController {

	/**
	 * 请求URL：http://localhost:8080/restTest/
	 * 返回类型：默认text/plain
	 * @Description 
	 * @return
	 */
	@RequestMapping("/")  
    public String index() {  
        return "Hello page";  
    }
	/**
	 * 请求URL：http://localhost:8080/restTest/hello
	 * 返回类型：默认text/plain
	 * @Description 
	 * @return
	 */
	@RequestMapping("/hello")  
	public String helloText() { 
        return "Hello 123 abc 123 123 !!!";  
    } 
	
	/**
	 * 请求URL：http://localhost:8080/restTest/hello2
	 * 返回类型：通过produces返回application/json;charset=UTF-8
	 * @Description 
	 * @return
	 */
	@RequestMapping(value="/hello2",produces="application/json;charset=UTF-8")  
	public String helloJson() {  
		User user = new User();
		user.setId(123);
		user.setName("abc");
		user.setCreateTime(new Date());
		//fastJson  JSONObject 转换
		String json = JSONObject.toJSONString(user);
        return json;  
    } 
	
	/**
	 * 请求URL：http://localhost:8080/restTest/helloJson
	 * 返回类型：通过produces返回application/json;charset=UTF-8
	 * 通过spring boot 框架自动转换json
	 * @Description 
	 * @return
	 */
	@RequestMapping(value="/helloJson",produces="application/json;charset=UTF-8")  
	public User helloJson2() {  
		User user = new User();
		user.setId(123);
		user.setName("abc");
        return user;  
    }
	
	/**
	 * 请求URL：http://localhost:8080/restTest/helloJson
	 * 返回类型：通过produces返回application/json;charset=UTF-8
	 * 通过spring boot 框架自动转换json
	 * @Description 
	 * @return
	 */
	@RequestMapping(value="/hello3",produces=MediaType.APPLICATION_FORM_URLENCODED_VALUE)  
	public User helloForm() {  
		User user = new User();
		user.setId(123);
		user.setName("abc");
		user.setCreateTime(new Date());
		//fastJson  JSONObject 转换
        return user;  
    } 
	
	/**
	 * 请求URL：http://localhost:8080/restTest/helloJson
	 * 返回类型：通过produces返回application/json;charset=UTF-8
	 * 通过spring boot 框架自动转换json
	 * @Description 
	 * @return
	 */
    @RequestMapping("/hello4/{myName}")  
    public  String helloPath(@PathVariable String myName) {  
        return "Hello "+myName+"!!!";  
    } 
    /**
     * fastjson支持
     * 返回对象则自动解析为json字符串  因为spring boot 默认使用json解析框架自动返回，返回头是Content-Type:application/json;charset=UTF-8
     * @Description 
     * @author Administrator
     * @param myName
     * @return {"id":123,"name":"good","createTime":1492782569909}
     */
    @RequestMapping("/getDemo/{myName}")  
    User getDemo(@PathVariable String myName) {  
    	User user = new User();
    	user.setId(123);
    	user.setName("good122223");
    	user.setCreateTime(new Date());
        System.out.println("Hello "+myName+"!!!"); 
        return user;
    }
    
    /**
     * spring boot 默认使用jackjson来解析json
     * 使用fastjson返回json  因为spring boot 默认使用json解析框架自动返回，
     * 返回头是Content-Type:application/json;charset=UTF-8
     * @Description 
     * @author Administrator
     * @param myName
     * @return {"createTime":"2017-05-20 13:23:57","id":123,"name":"sss"}
     */
    @RequestMapping("/getJson")  
    public User2 getJson() {  
    	User2 user = new User2();
    	user.setId(123);
    	user.setName("sss");
    	user.setCreateTime(new Date());
        return user;
    }
}
