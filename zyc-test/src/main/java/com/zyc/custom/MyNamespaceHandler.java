package com.zyc.custom;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author zhuyc
 * @date 2021/11/20 21:51
 **/
public class MyNamespaceHandler extends NamespaceHandlerSupport {
	@Override
	public void init() {
		registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
	}
}

