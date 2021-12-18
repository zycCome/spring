package org.springframework.zyc.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhuyc
 * @date 2021/12/05 11:35
 **/
public class Test {

	/**
	 * 测试PropertyEditor默认初始化的时间
	 */
	@org.junit.Test
	public void testAop1() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:cus-aop1.xml");
		TestBean bean = (TestBean)ctx.getBean("test");
		bean.test();
		ctx.close();
	}

}
