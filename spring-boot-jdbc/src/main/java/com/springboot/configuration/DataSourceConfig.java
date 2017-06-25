package com.springboot.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * 之前在介绍使用JdbcTemplate和Spring-data-jpa时，都使用了单数据源。在单数据源的情况下，Spring Boot的配置非常简单，只需要在application.properties文件中配置连接参数即可。但是往往随着业务量发展，我们通常会进行数据库拆分或是引入其他数据库，从而我们需要配置多个数据源，下面基于之前的JdbcTemplate和Spring-data-jpa例子分别介绍两种多数据源的配置方式。
 * 多数据源配置
 * 创建一个Spring配置类，定义两个DataSource用来读取application.properties中的不同配置。如下例子中，主数据源配置为spring.datasource.primary开头的配置，第二数据源配置为spring.datasource.secondary开头的配置。
 * @Description 
 * @author yunfeng
 * @date 2017年6月25日 下午5:15:35 
 * @version V1.0.0
 */
@Configuration
public class DataSourceConfig {
	

	@Bean(name = "primaryDataSource")
	@Qualifier("primaryDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.primary")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "secondaryDataSource")
	@Qualifier("secondaryDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.secondary")
	public DataSource secondaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	/**
	 * 对JdbcTemplate的支持比较简单，只需要为其注入对应的datasource即可，如下例子，在创建JdbcTemplate的时候分别注入名为primaryDataSource和secondaryDataSource的数据源来区分不同的JdbcTemplate。
	 * 
	 * @Description
	 * @param dataSource
	 * @return
	 */
	@Bean(name = "primaryJdbcTemplate")
	public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean(name = "secondaryJdbcTemplate")
	public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}