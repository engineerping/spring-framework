package org.gcsp.springaoptest;

import org.gcsp.springioctest.SysUser;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	/**
	 * Modify the application context's internal bean factory after its standard
	 * initialization. All bean definitions will have been loaded, but no beans
	 * will have been instantiated yet. This allows for overriding or adding
	 * properties even to eager-initializing beans.
	 *
	 * @param beanFactory the bean factory used by the application context
	 * @throws BeansException in case of errors
	 */
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("使用自定义的MyBeanFactoryPostProcessor增强BeanDefinition");
		BeanDefinition sysUserBeanDefinition = beanFactory.getBeanDefinition("sysUser1");
		System.out.println(sysUserBeanDefinition.getInitMethodName());
		System.out.println(sysUserBeanDefinition.getFactoryBeanName());
	}
}
