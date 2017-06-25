package com.springboot.configuration;

import java.net.InetAddress;

import javax.validation.constraints.NotNull;

import org.apache.catalina.Server;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 属性名匹配规则
 * person.firstName，标准的驼峰式命名
 * person.first-name，虚线（-）分割方式，推荐在.properties和.yml配置文件中使用
 * PERSON_FIRST_NAME，大写下划线形式，建议在系统环境变量中使用
 * 
connection:
    username: admin
    remoteAddress: 192.168.1.1
 * @Description 
 * @author yunfeng
 * @date 2017年6月25日 上午2:17:38 
 * @version V1.0.0
 */
@Component
@ConfigurationProperties(prefix="connection")
public class ConnectionSettings {

    private String username;

    private InetAddress remoteAddress;

	public void configure(Server server) {
		
	}

    // ... getters and setters

}