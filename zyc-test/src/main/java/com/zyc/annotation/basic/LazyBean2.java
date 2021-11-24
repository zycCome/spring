package com.zyc.annotation.basic;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * 没被依赖
 * @author zhuyc
 * @date 2021/11/22 22:05
 **/
@Lazy
@Component
public class LazyBean2 {

	public LazyBean2() {
		System.out.println("LazyBean2 constructor()");
	}


	public void sayHello() {
		System.out.println("hello, i am LazyBean2");
	}

}
