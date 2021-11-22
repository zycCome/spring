package com.zyc;

import com.zyc.circle.contructor.A;
import com.zyc.circle.contructor.B;
import com.zyc.circle.contructor.C;
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


	/**
	 * 测试构造器循环依赖
	 */
	@Test
	public void test4() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("circle-constructor.xml");
		System.out.println("success");
		ctx.close();
	}


	/**
	 * 测试prototype循环依赖
	 */
	@Test
	public void test5() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("circle-prototype.xml");
		ctx.setAllowCircularReferences(false);
		/*
		 * prototype类型的Bean测试必须要getBean来触发。
		 * 因为在ApplicationContext容器会启动时就初始化所有singleton类型的bean，prototype类型需要主动触发！
		 */
		A a = ctx.getBean(A.class);
		B b = ctx.getBean(B.class);
		C c = ctx.getBean(C.class);
		System.out.println("success");
		ctx.close();
	}
}
