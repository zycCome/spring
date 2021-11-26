package com.zyc.factorybean;

import com.zyc.User;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User工厂类
 * 不重写getObject
 *
 * @author zhuyc
 * @date 2021/09/03 22:30
 **/
public class UserFactoryBeanNotOverride implements FactoryBean<User> {
    User user = new User();


	private UserHolder userHolder;

	public UserHolder getUserHolder() {
		return userHolder;
	}

	public void setUserHolder(@Autowired UserHolder userHolder) {
		this.userHolder = userHolder;
	}

	public UserFactoryBeanNotOverride() {
        System.out.println("UserFactoryBeanNotOverride create...");
    }

	@Override
	public User getObject() throws Exception {
		return user;
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}


	@Override
    public boolean isSingleton() {
        return true;
    }
}
