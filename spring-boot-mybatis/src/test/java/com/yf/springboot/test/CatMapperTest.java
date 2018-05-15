package com.yf.springboot.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yf.springboot.Application;
import com.yf.springboot.entity.Cat;
import com.yf.springboot.hello.mapper.CatMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class CatMapperTest {

	Logger logger = LoggerFactory.getLogger(CatMapperTest.class);
	@Autowired
	private CatMapper catMapper;
	
	
	@Test
	public void testSelectByName(){
		List<Cat> cats= catMapper.getCatByName("tomcat");
		logger.info(cats.toString());
	}
	
	@Test
	public void testInsert(){
		Cat cat = new Cat();
		cat.setCatName("tomcat3");
		catMapper.save(cat);
		List<Cat> cats= catMapper.getCatByName("tomcat3");
		logger.info(cats.toString());
	}
	
	@Test
	public void testGetCatById(){
		Cat cat = catMapper.getCatById(1);
		System.out.println(cat);
	}
	
	@Test
	public void testUpdate(){
		Cat cat = new Cat();
		cat.setId(1);
		cat.setCatBirthday(new Date());
		cat.setCatName("tomcat2");
		catMapper.update(cat);
	}
	
	@Test
	public void testDelete(){
		catMapper.delete(2);
	}
}
