package com.yf.springboot.jdbctemplate;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yf.springboot.jpa.Cat;

/**
 * 持久化操作对象
 * @Description 
 * @author Administrator
 * @date 2017年5月20日 下午10:38:44 
 * @version V1.3.1
 */
@Repository
public class CatDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;

	public Cat selectByCatName(String catName){
		/**
		 * 1、定义一个sql语句
		 * 2、定义一个RowMapper
		 * 3、执行查询算法
		 */
		//Cat  java.lang.IllegalStateException: Mapped class was not specified] with root cause
		String sql = "select * from cat where cat_name= ?";
		RowMapper<Cat> rowMapper = new BeanPropertyRowMapper<Cat>(Cat.class);
		Cat cat = jdbcTemplate.queryForObject(sql,new Object[]{catName} , rowMapper);
		
		return cat;
	}
}
