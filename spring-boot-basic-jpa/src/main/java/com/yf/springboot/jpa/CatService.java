package com.yf.springboot.jpa;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yf.springboot.jdbctemplate.CatDao;

@Service
public class CatService {

	/**
	 * save delete update 需要事物绑定
	 * @Transactional
	 */
	@Resource
	private CatRepository catRepository; 
	
	
	@Resource
	private CatRepository2 catRepository2; 
	
	@Resource
	private CatDao catDao; 
	
	@Transactional
	public void save(Cat cat){
		
		catRepository.save(cat);
	}
	
	@Transactional
	public void delete(int id){
		
		catRepository.delete(id);
	}
	
	public Iterable<Cat> getAll(){
		
		return catRepository.findAll();
	}
	//org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'catController': Injection of resource dependencies failed; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'catService': Injection of resource dependencies failed; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'catRepository': Invocation of init method failed; nested exception is org.springframework.data.mapping.PropertyReferenceException: No property name found for type Cat!
	public Cat findCatByName(String catName){
		return catRepository.findByCatName(catName);
	}
	
	public Cat findMyByName(String catName){
		return catRepository.findMyCatName(catName);
	}
	
	public Cat selectByCatName(String catName){
		return catDao.selectByCatName(catName);
	}

}
