package com.yf.springboot.entity;

public class PersonBean {
    private String  name;  
    private Integer age;  
    private String  mN;
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
	public String getmN() {
		return mN;
	}
	public void setmN(String mN) {
		this.mN = mN;
	}
	@Override
	public String toString() {
		return "PersonBean [name=" + name + ", age=" + age + ", mN=" + mN + "]";
	}  
    
}
