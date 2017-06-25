package com.springboot.configuration;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 属性名匹配规则
 * person.firstName，标准的驼峰式命名
 * person.first-name，虚线（-）分割方式，推荐在.properties和.yml配置文件中使用
 * PERSON_FIRST_NAME，大写下划线形式，建议在系统环境变量中使用
 * @Description 
 * @author yunfeng
 * @date 2017年6月25日 上午2:17:38 
 * @version V1.0.0
 */
@Component
@ConfigurationProperties(prefix="person")
public class ConnectionSettings2 {
	//属性验证 可以使用JSR-303注解进行验证，例如
	@NotNull
    private String firstName;
	


}