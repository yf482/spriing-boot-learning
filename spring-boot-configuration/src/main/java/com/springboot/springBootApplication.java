package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.springboot.configuration.FooComponent;

/**
 * Spring Boot 支持多种外部配置方式

这些方式优先级如下：

命令行参数
来自java:comp/env的JNDI属性
Java系统属性（System.getProperties()）
操作系统环境变量
RandomValuePropertySource配置的random.*属性值
jar包外部的application-{profile}.properties或application.yml(带spring.profile)配置文件
jar包内部的application-{profile}.properties或application.yml(带spring.profile)配置文件
jar包外部的application.properties或application.yml(不带spring.profile)配置文件
jar包内部的application.properties或application.yml(不带spring.profile)配置文件
@Configuration注解类上的@PropertySource
通过SpringApplication.setDefaultProperties指定的默认属性

命令行参数

通过Java -jar app.jar --name="Spring" --server.port=9090方式来传递参数。

参数用--xxx=xxx的形式传递。
可以使用的参数可以是我们自己定义的，也可以是Spring Boot中默认的参数。

注意：命令行参数在app.jar的后面！

可以通过SpringApplication.setAddCommandLineProperties(false)禁用命令行配置。

Java系统属性

注意Java系统属性位置java -Dname="isea533" -jar app.jar，可以配置的属性都是一样的，优先级不同。

例如java -Dname="isea533" -jar app.jar --name="Spring!"中name值为Spring!
操作系统环境变量

配置过JAVA_HOME的应该都了解这一个。

这里需要注意的地方，有些OS可以不支持使用.这种名字，如server.port，这种情况可以使用SERVER_PORT来配置。

RandomValuePropertySource

系统中用到随机数的地方，例如：

my.secret=${random.value}
my.number=${random.int}
my.bignumber=${random.long}
my.number.less.than.ten=${random.int(10)}
my.number.in.range=${random.int[1024,65536]}
应用配置文件（.properties或.yml）

在配置文件中直接写：

name=Isea533
server.port=8080

.yml格式的配置文件如：

name: Isea533
server:
    port: 8080

当有前缀的情况下，使用.yml格式的配置文件更简单。关于.yml配置文件用法请看这里

注意：使用.yml时，属性名的值和冒号中间必须有空格，如name: Isea533正确，name:Isea533就是错的

属性配置文件的位置

spring会从classpath下的/config目录或者classpath的根目录查找application.properties或application.yml。

/config优先于classpath根目录



@PropertySource

这个注解可以指定具体的属性配置文件，优先级比较低。


pringApplication.setDefaultProperties

例如：

SpringApplication application = new SpringApplication(Application.class);
Map<String, Object> defaultMap = new HashMap<String, Object>();
defaultMap.put("name", "Isea-Blog");
//还可以是Properties对象
application.setDefaultProperties(defaultMap);
application.run(args);

应用（使用）属性

@Value(“${xxx}”)

这种方式是最简单的，通过@Value注解可以将属性值注入进来。

yml
my:
   servers:
       - dev.bar.com
       - foo.bar.com
properties
my.servers[0]=dev.bar.com
my.servers[1]=foo.bar.com

@ConfigurationProperties(prefix="my")
public class Config {

    private List<String> servers = new ArrayList<String>();

    public List<String> getServers() {
        return this.servers;
    }
}
 * 
 * 
 * 使用 @SpringBootApplication  该类需要是包的顶级
 * @Description 
 * @author yunfeng
 * @date 2017年6月24日 下午1:13:01 
 * @version V1.0.0
 */
@SpringBootApplication
public class springBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(springBootApplication.class, args);
	}
	
	@ConfigurationProperties(prefix = "foo")
	@Bean
	public FooComponent fooComponent() {
		return new FooComponent();
	}

}
