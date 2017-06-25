package com.springboot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MyApplication.class)
public class ApplicationTests2 {
	@Autowired
	@Qualifier("primaryJdbcTemplate")
	protected JdbcTemplate jdbcTemplate1;
	@Autowired
	@Qualifier("secondaryJdbcTemplate")
	protected JdbcTemplate jdbcTemplate2;
	@Before
	public void setUp() {
		jdbcTemplate1.update("DELETE  FROM  USER ");
		jdbcTemplate2.update("DELETE  FROM  USER ");
	}
	//报错  Failed to parse configuration class [org.springframework.boot.autoconfigure.SpringBootApplication]; nested exception is java.io.FileNotFoundException: class path resource [org/springframework/batch/core/configuration/annotation/BatchConfigurer.class] cannot be opened because it does not exist
	@Test
	public void test() throws Exception {
		// 往第一个数据源中插入两条数据
		jdbcTemplate1.update("insert into user(id,name,age) values(?, ?, ?)", 1, "aaa", 20);
		jdbcTemplate1.update("insert into user(id,name,age) values(?, ?, ?)", 2, "bbb", 30);
		// 往第二个数据源中插入一条数据，若插入的是第一个数据源，则会主键冲突报错
		jdbcTemplate2.update("insert into user(id,name,age) values(?, ?, ?)", 1, "aaa", 20);
		// 查一下第一个数据源中是否有两条数据，验证插入是否成功
		Assert.assertEquals("2", jdbcTemplate1.queryForObject("select count(1) from user", String.class));
		// 查一下第一个数据源中是否有两条数据，验证插入是否成功
		Assert.assertEquals("1", jdbcTemplate2.queryForObject("select count(1) from user", String.class));
	}
}