package com.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.configuration.PropertiesDemo;


/**
 * 引入配置文件bean，推荐相关配置信息封装到bean中再去引用。
 * @Description 
 * @author yunfeng
 * @date 2017年6月25日 上午12:27:51 
 * @version V1.0.0
 */
@RestController
public class HelloController {

	@Autowired
	PropertiesDemo propertiesDemo;
	
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }
    /**
     * properties UTF-8格式  value 存在中文会乱码
     * PropertiesDemo [name=yunfeng, title=å­¦ä¹ springboot, desc=yunfengæ­£å¨å­¦ä¹ springbootã, value=33b1f7c42118eead33cc6194bad0e26e, number=-1405152412, bignumber=-7589142432441180649, test1=2, test2=11]
     * @Description 
     * @return
     */
    @RequestMapping("/hello2")
    public String index2() {
    	System.out.println(propertiesDemo.toString());
        return "Hello World";
    }
    

}