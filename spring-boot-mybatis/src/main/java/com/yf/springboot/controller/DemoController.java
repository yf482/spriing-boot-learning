package com.yf.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.yf.springboot.entity.Demo;
import com.yf.springboot.service.DemoService;
/**
 * 1、maven project
 * 2、引入mybatis依赖和 pageHelper
 * 3、mapperScan注解
 * 4、编写 mapper 使用@Select @Save注解
 * 5、使用PageHelper.startPage(pageNum,pageSize)进行分页
 * @Description 
 * @author Administrator
 * @date 2017年5月21日 下午8:17:52 
 * @version V1.3.1
 */
@RestController
@RequestMapping("/mybatis")
public class DemoController {
	
	@Autowired
	DemoService demoService;
	
	@RequestMapping("/likeName")
	public List<Demo> likeName(String name){
		return demoService.likeName(name);
	}
	
	@RequestMapping("/likeName2")
	public List<Demo> likeName2(String name){
		PageHelper.startPage(1, 2);
		return demoService.likeName(name);
	}
	
	@RequestMapping("/save")
	public Demo save(String name){
		Demo demo = new Demo();
		demo.setName(name);
		demoService.save(demo);
		return demo;
	}

}
