package com.zyc.annotation.basic;

import org.springframework.stereotype.Component;

/**
 * @author zhuyc
 * @date 2021/11/22 22:06
 **/
@Component
public class NoLazyBean {

	public NoLazyBean() {
		System.out.println("NoLazyBean constructor()");
	}
}
