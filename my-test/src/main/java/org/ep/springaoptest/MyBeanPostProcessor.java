package org.ep.springaoptest;

import org.ep.springioctest.SysUser;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("使用自定义的MyBeanPostProcessor#postProcessBeforeInitialization增强bean");
		if (bean instanceof SysUser) {
			SysUser sysUser = (SysUser) bean;
			System.out.println(sysUser.getUsername());
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("使用自定义的MyBeanPostProcessor#postProcessAfterInitialization增强bean");
		if (bean instanceof SysUser) {
			SysUser sysUser = (SysUser) bean;
			System.out.println(sysUser.getUsername());
		}
		return bean;
	}
}
