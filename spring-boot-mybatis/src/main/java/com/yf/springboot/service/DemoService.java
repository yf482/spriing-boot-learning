package com.yf.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yf.springboot.entity.Demo;
import com.yf.springboot.hello.mapper.DemoMapper;

@Service
public class DemoService {
	
	@Autowired
	DemoMapper demoMapper;
	
	public List<Demo> likeName(String name){
		return demoMapper.likeName(name);
	}
	
	
	@Transactional
	public void save(Demo demo){
		 demoMapper.save(demo);
	}



}
