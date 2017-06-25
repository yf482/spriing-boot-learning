package com.springboot.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Spring Boot 会自动转换类型，当使用List的时候需要注意在配置中对List进行初始化！
Spring Boot 还支持嵌套属性注入，例如：
name=isea533
jdbc.username=root
jdbc.password=root
...
jdbc开头的属性都会注入到Jdbc对象中。
 * @Description 
 * @author yunfeng
 * @date 2017年6月25日 上午2:10:37 
 * @version V1.0.0
 */
@ConfigurationProperties
public class ConfigBean2 {
	private String name;
	private Jdbc jdbc;
	private int port;

	class Jdbc {
		private String username;
		private String password;
		// getter...
	}

	public Integer gePort() {
		return this.port;
	}

	public Jdbc getJdbc() {
		return this.jdbc;
	}
}
