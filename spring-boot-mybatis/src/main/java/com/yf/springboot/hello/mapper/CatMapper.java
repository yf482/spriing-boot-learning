package com.yf.springboot.hello.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yf.springboot.entity.Cat;

@Mapper
public interface CatMapper {
	
	@Results(
			{
			@Result(property="catBirthday",column="cat_birthday"),
			@Result(property="catName",column="cat_name")
			}
			)
	@Select("select * from cat where cat_name = #{catName} ")
	public List<Cat> getCatByName(String catName);
	
	@Results(
			{
			@Result(property="catBirthday",column="cat_birthday"),
			@Result(property="catName",column="cat_name")
			}
			)
	@Select("select * from cat where id = #{id} ")
	public Cat getCatById(int id);
	
	@Select("select name from cat where id = #{id}")
	public String getNameById(long id);
	
	//获取子自增长主键值
	@Insert("insert into cat (cat_birthday,cat_name) values (CURRENT_TIMESTAMP(),#{catName})")
//	@Options(useGeneratedKeys=true,keyProperty="id", keyColumn="id")
	public void save(Cat cat);
	
	
	@Update("UPDATE cat SET cat_birthday=#{catBirthday},cat_name=#{catName} WHERE id=#{id}")
    void update(Cat cat);
	
	@Delete("DELETE FROM cat WHERE id =#{id}")
    void delete(int id);
}
