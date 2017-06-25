package com.springboot.service;

/**
 * 
 * @Description 
 * @author yunfeng
 * @date 2017年6月25日 下午4:06:42 
 * @version V1.0.0
 */
public interface UserService {

    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    void create(String name, Integer age);

    /**
     * 根据name删除一个用户高
     * @param name
     */
    void deleteByName(String name);

    /**
     * 获取用户总量
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();


}
