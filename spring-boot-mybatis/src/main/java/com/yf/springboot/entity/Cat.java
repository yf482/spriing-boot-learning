package com.yf.springboot.entity;

import java.util.Date;

public class Cat {
	private int id;
	private Date catBirthday;
	private String catName;
	
	public Cat(int id, Date catBirthday, String catName) {
		super();
		this.id = id;
		this.catBirthday = catBirthday;
		this.catName = catName;
	}
	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCatBirthday() {
		return catBirthday;
	}
	public void setCatBirthday(Date catBirthday) {
		this.catBirthday = catBirthday;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	@Override
	public String toString() {
		return "Cat [id=" + id + ", catBirthday=" + catBirthday + ", catName=" + catName + "]";
	}
	
	

}
