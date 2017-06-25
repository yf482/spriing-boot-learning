package com.yf.springboot.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
// 
public interface CatRepository extends 
//Repository<Cat,Integer>
PagingAndSortingRepository<Cat, Integer>
//CrudRepository<Cat,Integer>
{

	/**
	 * 根据 get find read 开头
	 * 涉及查询条件，条件的属性用条件关键字链接，要注意的是条件属性以首字母大写
	 * @Description 
	 * @author Administrator
	 * @param catName
	 * @return
	 */
	Cat findByCatName(String catName);

	@Query("from Cat where catName =:cn")
	Cat findMyCatName(@Param("cn") String catName);
}
