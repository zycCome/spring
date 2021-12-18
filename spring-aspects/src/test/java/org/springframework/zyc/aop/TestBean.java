package org.springframework.zyc.aop;

/**
 * @author zhuyc
 * @date 2021/12/05 09:34
 **/
public class TestBean {

	private String testStr = "testStr";

	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}

	public void test(){
		System.out.println("test");
	}

}
