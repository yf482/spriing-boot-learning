package com.yf.springboot.jpa;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 使用jpa hibernate 步骤
 * 1、添加相应的依赖
 * 2、配置appliacation.yml .properties
 * 3、创建实体类 ，加注解
 * 4、创建接口继承crudRepository
 * 5、创建service 注入repository
 * 6、创建conroller 注入 service
 * @Description 
 * @author Administrator
 * @date 2017年5月20日 下午5:11:56 
 * @version V1.3.1
 */
@Entity
public class Cat {
	
	/**
	 * 使用@Id指定主键
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private  int id;
	private String catName;
	private Date catBirthday;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public Date getCatBirthday() {
		return catBirthday;
	}
	public void setCatBirthday(Date catBirthday) {
		this.catBirthday = catBirthday;
	}
	@Override
	public String toString() {
		return "Cat [id=" + id + ", catName=" + catName + ", catBirthday=" + catBirthday + "]";
	}
	
	

	
}
