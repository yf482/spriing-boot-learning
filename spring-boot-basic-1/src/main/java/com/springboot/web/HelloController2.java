package com.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * springboot controller风格请求
 * @Description 
 * @author yunfeng
 * @date 2017年6月24日 下午12:50:54 
 * @version V1.3.1
 */
@Controller
@RequestMapping("/test2")
public class HelloController2 {

	/**
	 * 返回text/plain风格string 文本
	 * @Description 
	 * @return
	 */
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World";
    }
    /**
     * 使用freekmarker模板页面,需要在pom文件引入依赖 。ModelMap是模板变量容器，默认调用resources下template目录页面
     * @Description 
     * @param map
     * @return
     */
    @RequestMapping("/hello2")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }

}