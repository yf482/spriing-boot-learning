package com.yf.springboot.hello.mapper;

public class User {
    private Long id;
    private String name;
    private Integer age;
    public User(String name, Integer age) {
    	
    	this.name = name;
    	this.age = age;
	}
    
	public User() {
		super();
	}

	// 省略getter和setter
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
    
}