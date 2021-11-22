package com.zyc.circle.contructor;

/**
 * @author zhuyc
 * @date 2021/11/21 15:54
 **/
public class B {
	private C c;

	public B() {
	}

	public B (C c){
		this.c = c;
	}

	public C getC() {
		return c;
	}

	public void setC(C c) {
		this.c = c;
	}
}

