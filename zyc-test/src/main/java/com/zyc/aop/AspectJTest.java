//package com.zyc.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//
///**
// * @author zhuyc
// * @date 2021/12/05 09:34
// **/
//@Aspect
//public class AspectJTest {
//
//	@Pointcut("execution(* *.test(..))")
//	public void test() {
//
//	}
//
//	@Before("test()")
//	public void beforeTest() {
//		System.out.println("beforeTest");
//	}
//
//	@After("test()")
//	public void afterTest() {
//		System.out.println("afterTest");
//	}
//
//	public Object arountTest(ProceedingJoinPoint p) {
//		System.out.println("before1");
//		Object obj = null;
//		try {
//			obj = p.proceed();
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
//		System.out.println("after1");
//		return obj;
//	}
//}
