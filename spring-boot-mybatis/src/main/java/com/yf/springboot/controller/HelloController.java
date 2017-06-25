package com.yf.springboot.controller;

import java.util.Date;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yf.springboot.entity.User;
import com.yf.springboot.entity.User2;


/**
 * import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.bind.annotation.ResponseBody;
 * @Description 使用RestController 相当于@Controller 和 @RequestBody
 * @author Administrator
 * @date 2017-4-21 下午9:06:28 
 * @version V1.3.1
 */
//@Controller @ResponseBody
@RestController
@EnableAutoConfiguration  
public class HelloController {

	@RequestMapping("/")  
    public String index() {  
        return "Hello page";  
    }
	
	
	
	@RequestMapping("/hello")  
	public String hello() {  
        return "Hello 123 abc 123 123 !!!";  
    } 
	
	@RequestMapping("/hello2")  
	public String hello2() {  
        return "Hello 123 abc 123 123 !!!";  
    } 
	
    @RequestMapping("/hello3/{myName}")  
    public  String hello3(@PathVariable String myName) {  
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
