package com.springboot.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * 
 * JpaRepository  API　@url http://docs.spring.io/spring-data/data-jpa/docs/current/api/
 * 由于Spring-data-jpa依赖于Hibernate。如果您对Hibernate有一定了解，下面内容可以毫不费力的看懂并上手使用Spring-data-jpa
 * Spring-data-jpa的能力远不止本文提到的这些，由于本文主要以整合介绍为主，对于Spring-data-jpa的使用只是介绍了常见的使用方式。诸如@Modifying操作、分页排序、原生SQL支持以及与Spring MVC的结合使用等等内容就不在本文中详细展开，这里先挖个坑，后续再补文章填坑，如您对这些感兴趣可以关注我博客或简书，同样欢迎大家留言交流想法。
 * 
 * 然而，在实际开发过程中，对数据库的操作无非就“增删改查”。就最为普遍的单表操作而言，除了表和字段不同外，语句都是类似的，开发人员需要写大量类似而枯燥的语句来完成业务逻辑。
 * 为了解决这些大量枯燥的数据操作语句，我们第一个想到的是使用ORM框架，比如：Hibernate。通过整合Hibernate之后，我们以操作Java实体的方式最终将数据改变映射到数据库表中。
 * 为了解决抽象各个Java实体基本的“增删改查”操作，我们通常会以泛型的方式封装一个模板Dao来进行抽象简化，但是这样依然不是很方便，我们需要针对每个实体编写一个继承自泛型模板Dao的接口，再编写该接口的实现。虽然一些基础的数据访问已经可以得到很好的复用，但是在代码结构上针对每个实体都会有一堆Dao的接口和实现。
 * 由于模板Dao的实现，使得这些具体实体的Dao层已经变的非常“薄”，有一些具体实体的Dao实现可能完全就是对模板Dao的简单代理，并且往往这样的实现类可能会出现在很多实体上。Spring-data-jpa的出现正可以让这样一个已经很“薄”的数据访问层变成只是一层接口的编写方式。比如，下面的例子：
 * @Description 我们只需要通过编写一个继承自JpaRepository的接口就能完成数据访问，下面以一个具体实例来体验Spring-data-jpa给我们带来的强大功能。
 * @author yunfeng
 * @date 2017年6月25日 下午4:27:58 
 * @version V1.0.0
 */
public interface UserRepository extends JpaRepository<User, Long> {
	//它们分别实现了按name查询User实体和按name和age查询User实体，可以看到我们这里没有任何类SQL语句就完成了两个条件查询方法。这就是Spring-data-jpa的一大特性：通过解析方法名创建查询。
    User findByName(String name);
    User findByNameAndAge(String name, Integer age);

    //除了通过解析方法名来创建查询外，它也提供通过使用@Query 注解来创建查询，您只需要编写JPQL语句，并通过类似“:name”来映射@Param指定的参数，就像例子中的第三个findUser函数一样。
    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);


}
