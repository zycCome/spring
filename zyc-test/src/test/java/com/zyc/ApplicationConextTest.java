package com.zyc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhuyc
 * @date 2021/11/20 12:13
 **/
public class ApplicationConextTest {

	/**
	 * 对应prepareRefresh();
	 * 故意引入一个不存在的外部配置文件.
	 * 结论：这里getEnvironment().validateRequiredProperties();和引入外部配置文件无关，只扩展用的
	 */
	@Test
	public void test1() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext/beans.xml");
		User user = ctx.getBean(User.class);
		System.out.println("user = " + user);
		ctx.close();
	}


}
