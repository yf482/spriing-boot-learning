package com.yf.springboot.test;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yf.springboot.Application;
import com.yf.springboot.hello.mapper.CatMapper;
import com.yf.springboot.hello.mapper.User;
import com.yf.springboot.hello.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class SpringBootTest {

	Logger logger = LoggerFactory.getLogger(SpringBootTest.class);
	@Autowired
	private UserMapper userMapper;
	
	@Test
	@Rollback
	public void findByName() throws Exception {
		userMapper.insert("AAA2", 20);
		User u = userMapper.findByName("AAA2");
		System.out.println(u);
		Assert.assertEquals(20, u.getAge().intValue());
	}
	
	@Test
	@Rollback
	public void testUserMapper() throws Exception {
		// insert一条数据，并select出来验证
		userMapper.insert("AAA", 20);
		User u = userMapper.findByName("AAA");
		Assert.assertEquals(20, u.getAge().intValue());
		// update一条数据，并select出来验证
		u.setAge(30);
		userMapper.update(u);
		u = userMapper.findByName("AAA");
		Assert.assertEquals(30, u.getAge().intValue());
		// 删除这条数据，并select验证
		userMapper.delete(u.getId());
		u = userMapper.findByName("AAA");
		Assert.assertEquals(null, u);

		u = new User("BBB", 30);
		userMapper.insertByUser(u);
		Assert.assertEquals(30, userMapper.findByName("BBB").getAge().intValue());

		Map<String, Object> map = new HashMap<>();
		map.put("name", "CCC");
		map.put("age", 40);
		userMapper.insertByMap(map);
		Assert.assertEquals(40, userMapper.findByName("CCC").getAge().intValue());

		List<User> userList = userMapper.findAll();
		for(User user : userList) {
			Assert.assertEquals(null, user.getId());
			Assert.assertNotEquals(null, user.getName());
		}

	}
	
	@Test
	public void testDelete(){
		Long id = 14l;
		userMapper.delete(id);
	}
	
	
	@Test
	public void testInsertByMap(){
		Map<String, Object> map = new HashMap<>();
		map.put("name", "CCC");
		map.put("age", 40);
		userMapper.insertByMap(map);
	}
	
	@Test
	public void testInsertByUser(){
		User u = new User("BBB", 30);
		userMapper.insertByUser(u);
	}
	@Test
	@Rollback
	public void testUpdate(){
		User u = new User("BBB", 40);
		userMapper.update(u);
		User user = userMapper.findByName("BBB");
		logger.trace("user: " + user);
		System.out.println(user);
	}
	
	@Test
	@Rollback
	public void testFindAll(){
		List<User> userList = userMapper.findAll();
		for(User user : userList) 
		{
			logger.info("user:" + user);
			Assert.assertEquals(null, user.getId());
			Assert.assertNotEquals(null, user.getName());
		}
	}
	
	
	
}
