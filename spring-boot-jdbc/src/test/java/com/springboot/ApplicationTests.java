package com.springboot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springboot.service.UserService;

/**
 * a)assertThat( n, allOf( greaterThan(1), lessThan(15) ) );
assertThat( n, anyOf( greaterThan(16), lessThan(8) ) );
assertThat( n, anything() );
assertThat( str, is( "bjsxt" ) );//字符串是不是”bjsxt”
assertThat( str, not( "bjxxt" ) );
b)assertThat( str, containsString( "bjsxt" ) );
assertThat( str, endsWith("bjsxt" ) );
assertThat( str, startsWith( "bjsxt" ) );
assertThat( n, equalTo( nExpected ) );
assertThat( str, equalToIgnoringCase( "bjsxt" ) );  //字符串忽略大小写是否相等
assertThat( str, equalToIgnoringWhiteSpace( "bjsxt" ) );  //字符串忽略空格是否相等
c)assertThat( d, closeTo( 3.0, 0.3 ) );//数值接近3.0 误差不超过0.3
assertThat( d, greaterThan(3.0) );
assertThat( d, lessThan (10.0) );
assertThat( d, greaterThanOrEqualTo (5.0) );//大于等于
assertThat( d, lessThanOrEqualTo (16.0) );
d)assertThat( map, hasEntry( "bjsxt", "bjsxt" ) );//map里面key-value判断
assertThat( iterable, hasItem ( "bjsxt" ) );
assertThat( map, hasKey ( "bjsxt" ) );
assertThat( map, hasValue ( "bjsxt" ) );
 * @Description 
 * @author yunfeng
 * @date 2017年6月25日 下午4:11:20 
 * @version V1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(MyApplication.class)
public class ApplicationTests {

	@Autowired
	private UserService userSerivce;

	@Before
	public void setUp() {
		// 准备，清空user表
		userSerivce.deleteAllUsers();
	}

	@Test
	public void test() throws Exception {
		// 插入5个用户
		userSerivce.create("a", 1);
		userSerivce.create("b", 2);
		userSerivce.create("c", 3);
		userSerivce.create("d", 4);
		userSerivce.create("e", 5);

		// 查数据库，应该有5个用户
		Assert.assertEquals(5, userSerivce.getAllUsers().intValue());

		// 删除两个用户
		userSerivce.deleteByName("a");
		userSerivce.deleteByName("e");

		// 查数据库，应该有5个用户
		Assert.assertEquals(3, userSerivce.getAllUsers().intValue());
//		Assert.assertThat();
	}


}
