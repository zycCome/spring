package com.zyc.annotation.basic;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author zhuyc
 * @date 2021/11/22 22:05
 **/
@Lazy
@Component
public class LazyBean1 {

	public LazyBean1() {
		System.out.println("LazyBean1 constructor()");
	}


	public void sayHello() {
		System.out.println("hello, i am LazyBean1");
	}

}
