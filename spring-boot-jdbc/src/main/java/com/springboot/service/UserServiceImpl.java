package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * JdbcTemplate API
 * @url https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html
 * 使用JdbcTemplate操作数据库
 * Spring的JdbcTemplate是自动配置的，你可以直接使用@Autowired来注入到你自己的bean中来使用。
 * 举例：我们在创建User表，包含属性name、age，下面来编写数据访问对象和单元测试用例。
 * @Description 
 * @author yunfeng
 * @date 2017年6月25日 下午4:58:39 
 * @version V1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

	//避免跟多数据冲突先注释
//    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into USER(NAME, AGE) values(?, ?)", name, age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from USER where NAME = ?", name);
    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from USER");
    }
}
