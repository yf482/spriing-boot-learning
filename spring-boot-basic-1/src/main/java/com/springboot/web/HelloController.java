package com.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @Description 
 * @author yunfeng
 * @date 2017年6月24日 下午12:55:38 
 * @version V1.3.1
 */
@RestController
@RequestMapping("/test")
public class HelloController {

	/**
	 * request URL : http://localhost:8080/test/hello
	 * return : text/plain, Hello World
	 * @Description 
	 * @return
	 */
    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

}