package com.yf.springboot.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yf.springboot.entity.User;

/**
 *GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE; 方式restful http请求
 * @Description 
 * @author yunfeng
 * @date 2017年6月25日 下午12:35:52 
 * @version V1.0.0
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

	static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<Integer, User>());

	/**
	 * http://localhost:8080/users/  
	 * get请求
	 * @Description 
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> getUserList() {
		// 处理"/users/"的GET请求，用来获取用户列表
		// 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
		List<User> r = new ArrayList<User>(users.values());
		return r;
	}

	/**
	 * http://localhost:8080/users/
	 * application/x-www-form-urlencoded
	 * id=123&name=abc&creatTime=1498284521928
	 * @Description 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String postUser(@ModelAttribute User user) {
		// 处理"/users/"的POST请求，用来创建User
		// 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
		users.put(user.getId(), user);
		return "success";
	}

	/**
	 * http://localhost:8080/users/123
	 * @Description 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable Integer id) {
		// 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
		// url中的id可通过@PathVariable绑定到函数的参数中
		return users.get(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Integer id, @ModelAttribute User user) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        u.setCreateTime(user.getCreateTime());
        users.put(id, u);
        return "success";
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        users.remove(id);
        return "success";
    }
}
