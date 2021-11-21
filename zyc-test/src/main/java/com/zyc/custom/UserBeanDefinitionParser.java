package com.zyc.custom;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSimpleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class UserBeanDefinitionParser extends AbstractSimpleBeanDefinitionParser {

	// 从 Elment 中找到相应的类
	@Override
	protected Class getBeanClass(Element element){
		return User.class;
	}

	// 从 element 中解析并提取出对应的元素
	@Override
	protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {
		String userName = element.getAttribute("userName");
		String email = element.getAttribute("email");
		//将提取的数据放到 BeanDefinitionBuilder 中，待完成所有的 bean 注册后，统一注册到 beanFactory 中
		if(!StringUtils.isEmpty(userName)){
			builder.addPropertyValue("userName", userName);
		}
		if(!StringUtils.isEmpty(email)){
			builder.addPropertyValue("email",email);
		}
	}
}

