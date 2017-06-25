package com.yf.springboot.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

	Logger logger = LoggerFactory.getLogger(HelloController.class);
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
        return "hello 123";  
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
	 * 返回类型：通过produces返回application/x-www-form-urlencoded
	 * 
	 * @Description 
	 * @return
	 */
	@RequestMapping(value="/hello3",produces=MediaType.APPLICATION_FORM_URLENCODED_VALUE)  
	public String helloForm() {  
		User user = new User();
		user.setId(123);
		user.setName("abc");
		user.setCreateTime(new Date());
		
		//fastJson  JSONObject 转换
        return "id=123&user=abc&createTime=123";  
    } 
	
	/**
	 * 请求URL：http://localhost:8080/restTest/helloGet?id=123&name=abc
	 * 通过框架将get参数自动封装到bean中，基本数据类型可以自动转换，特殊类型需要转换不然会报错。
	 * 返回类型：默认返回类型  
	 * @Description 
	 * @return
	 */
	@RequestMapping(value="/helloGet")  
	public User helloGet(User user) {  
		System.out.println(user);
		//fastJson  JSONObject 转换
        return user;  
    }
	

	/**
	 * 请求URL：http://localhost:8080/restTest/helloPost
	 * 请求json数据类型 post请求 {"createTime":1498284521928,"id":123,"name":"abc"}
	 * 通过框架将get参数自动封装到bean中，基本数据类型可以自动转换，特殊类型需要转换不然会报错。
	 * 返回类型：默认返回类型  
	 * @Description 
	 * @return
	 */
	@RequestMapping(value="/helloPostJson")  
	public User helloPost(@RequestBody User user) {  
		System.out.println(user);
		//fastJson  JSONObject 转换
        return user;  
    }
	
	/**
	 * 请求URL：http://localhost:8080/restTest/helloPost
	 * 请求json数据类型 post请求 {"createTime":1498284521928,"id":123,"name":"abc"}
	 * 通过框架将get参数自动封装到bean中，基本数据类型可以自动转换，特殊类型需要转换不然会报错。
	 * 返回类型：默认返回类型  
	 * @Description 
	 * @return
	 */
	@RequestMapping(value="/helloPostJson2",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)  
	public String helloPostJson(@RequestBody String json) {  
		System.out.println(json);
		//fastJson  JSONObject 转换
        return json;  
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
     * 使用fastjson返回json  
     * 对应解析bean使用相应转换注解
     * 返回头是Content-Type:application/json;charset=UTF-8
     * @Description 
     * @author Administrator
     * @param myName
     * @return {"createTime":"2017-05-20 13:23:57","id":123,"name":"sss"}
     */
    @RequestMapping("/getFastJson")  
    public User2 getJson() {  
    	User2 user = new User2();
    	user.setId(123);
    	user.setName("sss");
    	user.setCreateTime(new Date());
        return user;
    }
    
    /**
     * http://localhost:8080/restTest/getBody
     * {"createTime":"2017-05-20 13:23:57","id":123,"name":"sss"}
     * 
     * 能获取post传输的body字符串，不需要进行bean封装时候用到
     * text/plain 、 x-form 、 json都可以保存到requestBody  
     * syntax error, pos 1, json : %7B%22createTime%22%3A%222017-05-20+13%3A23%3A57%22%2C%22id%22%3A123%2C%22name%22%3A%22sss%22%7D=] with root cause
     *使用fastJson @Requestbody post x-form报错  text/plain 、json可以
     * {
	    "timestamp": 1498318149816,
	    "status": 500,
	    "error": "Internal Server Error",
	    "exception": "com.alibaba.fastjson.JSONException",
	    "message": "syntax error, pos 1, json : id=123&name=abc",
	    "path": "/restTest/getBody"
	 } 
     * @Description 
     * @param str
     * @return
     */
    @RequestMapping("/getBody")  
    public User2 getBody(@RequestBody String str) {  
    	logger.info("requestBody:" + str);
    	User2 user = new User2();
    	user.setId(123);
    	user.setName("sss");
    	user.setCreateTime(new Date());
        return user;
    }
}
