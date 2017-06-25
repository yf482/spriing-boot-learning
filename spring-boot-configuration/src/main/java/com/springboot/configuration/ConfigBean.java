package com.springboot.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 有时候使用@value 则会显得有些笨重
 * @ConfigurationProperties Spring Boot 可以方便的将属性注入到一个配置对象中。例如：
 * my.name=Isea533
	my.port=8080
	my.servers[0]=dev.bar.com
	my.servers[1]=foo.bar.com
	
	Spring Boot 会自动转换类型，当使用List的时候需要注意在配置中对List进行初始化！

 * @Description 
 * @author yunfeng
 * @date 2017年6月25日 上午2:08:50 
 * @version V1.0.0
 */
@ConfigurationProperties(prefix="my")
public class ConfigBean {
    private String name;
    private Integer port;
    private List<String> servers = new ArrayList<String>();

    public String geName(){
        return this.name;
    }

    public Integer gePort(){
        return this.port;
    }
    public List<String> getServers() {
        return this.servers;
    }
}