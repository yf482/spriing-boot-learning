package com.yf.springboot.hello.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;



/**
 * 1、@Param中使用参数
 * 2、使用对象，#{name}、#{age}就分别对应了User对象中的name和age属性。
 * 3、使用Map<String, Object> map,map中填入同名的内容即可
 * @Description 
 * @author yunfeng
 * @date 2017年7月2日 下午10:52:11 
 * @version V1.0.0
 */
@Mapper
public interface UserMapper {
    
	/**
	 * 
	 * @Description 
	 * @param name
	 * @return
	 */
	@Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);
    
    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);
    
    //这样语句中的#{name}、#{age}就分别对应了User对象中的name和age属性。
    @Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
    int insertByUser(User user);

    @Insert("INSERT INTO user(name, age) VALUES(#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER})")
    int insertByMap(Map<String, Object> map);
    
    @Update("UPDATE user SET age=#{age} WHERE name=#{name}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);
    
    
    //返回结果的绑定
    //对于增、删、改操作相对变化较小。而对于“查”操作，我们往往需要进行多表关联，汇总计算等操作，那么对于查询的结果往往就不再是简单的实体对象了，往往需要返回一个与数据库实体不同的包装类，那么对于这类情况，就可以通过@Results和@Result注解来进行绑定，具体如下：
    @Results({
        @Result(property = "name", column = "name"),
        @Result(property = "age", column = "age")
    })
	
    @Select("SELECT name, age FROM user")
	List<User> findAll();
}
