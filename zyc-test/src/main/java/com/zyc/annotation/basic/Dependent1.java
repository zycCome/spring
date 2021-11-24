package com.zyc.annotation.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhuyc
 * @date 2021/11/22 22:07
 **/
@Component
public class Dependent1 {

	@Autowired
	private LazyBean1 lazyBean1;

	@Autowired
	private NoLazyBean noLazyBean;

	public Dependent1() {
		System.out.println("Dependent1 constructor()");
	}

	public LazyBean1 getLazyBean1() {
		return lazyBean1;
	}

	public void setLazyBean1(LazyBean1 lazyBean1) {
		this.lazyBean1 = lazyBean1;
	}

	public NoLazyBean getNoLazyBean() {
		return noLazyBean;
	}

	public void setNoLazyBean(NoLazyBean noLazyBean) {
		this.noLazyBean = noLazyBean;
	}
}
