package com.yf.springboot.entity;

import java.util.Date;

/**
 * 
 * @Description 测试实体类 
 * @author Administrator
 * @date 2017-4-21 下午9:14:27 
 * @version V1.3.1
 */
public class User {
	private int id;
	private String name;
	private int age;
	private Date createTime;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", createTime=" + createTime + "]";
	}
	
}
