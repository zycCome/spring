package com.zyc;

import com.zyc.annotation.basic.*;
import com.zyc.circle.contructor.A;
import com.zyc.circle.contructor.B;
import com.zyc.circle.contructor.C;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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


	/**
	 * 测试延迟解析代理@Lazy
	 * 1. 放在类上，只是延迟初始化（如果该bean被立即初始化的bean依赖了，那么该bean也会马上初始化。否则，会延迟），不会生成代理对象！
	 * 2. 如果放在属性上，那么加了@lazy的字段会被注入代理对象；不加不会注入代理对象
	 * 3. 如果两个类中的字段对同一个Bean加上@lazy，那他们的代理对象也是不一样的！
	 */
	@Test
	public void test6() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
		System.out.println("容器启动完成");

		Dependent1 dependent1 = ctx.getBean(Dependent1.class);
		DependentWithLazyField dependentWithLazyField = ctx.getBean(DependentWithLazyField.class);
		DependentWithLazyField2 dependentWithLazyField2 = ctx.getBean(DependentWithLazyField2.class);
		System.out.println(dependent1.getLazyBean1() == dependentWithLazyField.getLazyBean1());//true
		System.out.println(dependent1.getNoLazyBean() == dependentWithLazyField.getNoLazyBean());//false
		System.out.println(dependentWithLazyField2.getNoLazyBean() == dependentWithLazyField.getNoLazyBean());//false。代理对象不一样
		LazyBean2 bean = ctx.getBean(LazyBean2.class);
		bean.sayHello();
		ctx.close();
	}


	/**
	 * 测试
	 * 1.  doGetBean(FACTORY_BEAN_PREFIX + beanName, FactoryBean.class, null, true); 最后一个参数typeCheckOnly=true的场景
	 * 2. typeCheckOnly=true时 ======>
	 * 			if (!typeCheckOnly) {
	 * 				markBeanAsCreated(beanName);//将beanName放入alreadyCreated集合
	 *           }
	 * 3. alreadyCreated又会在循环依赖的    removeSingletonIfCreatedForTypeCheckOnly(dependentBean)中用到
	 *
	 * 结论：
	 * 	1. FactoryBean中循环依赖也没找到removeSingletonIfCreatedForTypeCheckOnly(dependentBean)进入另一个分支的场景
	 * 	2. AbstractBeanFactory#doGetBean中有如下代码，说明创建过程出现异常的bean会从alreadyCreated这个集合中清楚，这样理论上就会进行另一个分支了
	 *
	 * 				catch (BeansException ex) {
	 * 					cleanupAfterBeanCreationFailure(beanName);
	 * 					throw ex;
	 *              }
	 */
	@Test
	public void test7() {
		XmlBeanFactory ctx = new XmlBeanFactory(new ClassPathResource("factoryBean.xml"));
		System.out.println("type1==" + ctx.getType("userFactory1"));
		/**
		 * // No type found for shortcut FactoryBean instance:
		 * // fall back to full creation of the FactoryBean instance.
		 * // 没有找到快捷FactoryBean实例的类型:退回到完全创建FactoryBean实例。(userFactory2的getObjectType==null) 为什么这样做呢？
		 * 	return super.getTypeForFactoryBean(beanName, mbd);
		 */
		System.out.println("type2==" + ctx.getType("userFactory2"));
	}
}
