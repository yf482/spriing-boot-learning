package com.springboot;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 使用 @SpringBootApplication  该类需要是包的顶级
 * @Description 
 * @author yunfeng
 * @date 2017年6月24日 下午1:13:01 
 * @version V1.0.0
 */
@SpringBootApplication
public class MyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}
	

}
