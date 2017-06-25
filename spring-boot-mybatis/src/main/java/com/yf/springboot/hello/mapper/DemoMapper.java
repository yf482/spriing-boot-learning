package com.yf.springboot.hello.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.yf.springboot.entity.Demo;

public interface DemoMapper {

	//#{XX}占位符
	@Select("select * from demo where name = #{name}")
	public List<Demo> likeName(String name);
	
	@Select("select * from demo where id = #{id}")
	public Demo getById(long id);
	
	@Select("select name from demo where id = #{id}")
	public String getNameById(long id);
	
	//获取子自增长主键值
	@Insert("insert into demo (name) values (#{name})")
	@Options(useGeneratedKeys=true,keyProperty="id", keyColumn="id")
	public void save(Demo demo);
}
