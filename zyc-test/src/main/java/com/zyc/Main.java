package com.zyc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhuyc
 * @date 2021/11/15 22:39
 **/
public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:beans.xml");
		User user = ctx.getBean(User.class);
		System.out.println("user = " + user);
	}




}
