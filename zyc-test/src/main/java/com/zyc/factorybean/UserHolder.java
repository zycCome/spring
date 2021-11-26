package com.zyc.factorybean;

import com.zyc.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 循环依赖测试
 *
 * @author zhuyc
 * @date 2021/11/25 22:55
 **/
public class UserHolder {

	@Autowired
	private UserFactoryBeanNotOverride userFactoryBeanNotOverride;

	public UserHolder() {
		System.out.println("UserHolder create...");
	}
}
