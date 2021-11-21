package com.zyc;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author zhuyc
 * @date 2021/11/20 12:13
 **/
public class BeanFactoryTest {

	@Test
	public void test1() {
		XmlBeanFactory ctx = new XmlBeanFactory(new ClassPathResource("beans.xml"));
		User user = (User) ctx.getBean("com.zyc.User");
		System.out.println("user = " + user);
	}

	@Test
	public void test2() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:beans.xml");
		User user = ctx.getBean(User.class);
		System.out.println("user = " + user);
		ctx.close();
	}


	/**
	 * 测试自定义标签
	 */
	@Test
	public void test3() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("custom-beans.xml");
		com.zyc.custom.User user = ctx.getBean(com.zyc.custom.User.class);
		System.out.println(user.getUserName() + "," + user.getEmail());
		ctx.close();
	}
}
