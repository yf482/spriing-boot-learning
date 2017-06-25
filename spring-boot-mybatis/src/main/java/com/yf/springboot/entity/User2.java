package com.yf.springboot.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @Description fastjson测试实体类 
 * @author Administrator
 * @date 2017-4-21 下午9:14:27 
 * @version V1.3.1
 */
public class User2 {
	private int id;
	private String name;
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	
	//不出现
	@JSONField(serialize=false)
	private String remark;//备注信息
	
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	
	public User2() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
}
