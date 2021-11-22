package com.zyc.circle.contructor;

/**
 * @author zhuyc
 * @date 2021/11/21 15:54
 **/
public class A {
	private B b;

	public A (B b){
		this.b = b;
	}

	public A() {
	}

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}
}

