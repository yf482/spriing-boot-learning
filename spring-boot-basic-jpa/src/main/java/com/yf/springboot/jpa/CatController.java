package com.yf.springboot.jpa;

import java.util.Date;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cat")
public class CatController {

	@Resource
	private CatService catService;
	
	@RequestMapping("/save")
    public String save(){
		Cat cat = new Cat();
		cat.setId(123);
		cat.setCatName("tomcat");
		cat.setCatBirthday(new Date());
    	catService.save(cat);
    	return "save ok";
    }
	
	@RequestMapping("/delete/{id}")
    public String delete(@PathVariable int id){
    	catService.delete(id);
    	return "delete ok";
    }
	
	@RequestMapping("/getAll/{id}")
    public String getAll(){
    	Iterable<Cat>  itcat = catService.getAll();
    	return "getAll ok";
    }
	
	@RequestMapping("/find")
    public Cat find(String catName){
    	Cat cat =  catService.findCatByName(catName);
    	return cat;
    }
	
	@RequestMapping("/findMy")
    public Cat findMyCat(String catName){
    	Cat cat =  catService.findMyByName(catName);
    	return cat;
    }
	
	@RequestMapping("/selectByCatName")
    public Cat selectByCatName(String catName){
    	Cat cat =  catService.selectByCatName(catName);
    	return cat;
    }
}
