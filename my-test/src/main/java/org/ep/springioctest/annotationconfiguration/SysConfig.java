package org.ep.springioctest.annotationconfiguration;

import org.ep.springaoptest.MyBeanFactoryPostProcessor;
import org.ep.springaoptest.MyBeanPostProcessor;
import org.ep.springioctest.SysRole;
import org.ep.springioctest.SysUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class SysConfig {
	@Bean
	public SysUser sysUser2(){
		return new SysUser("新用户", sysRole2());
	}

	@Bean
	public SysRole sysRole2() {
		return new SysRole(2, "sysRole2");
	}

	@Bean
	public static MyBeanFactoryPostProcessor myBeanFactoryPostProcessor2() {
		return new MyBeanFactoryPostProcessor();
	}

	@Bean
	public static MyBeanPostProcessor myBeanPostProcessor2() {
		return new MyBeanPostProcessor();
	}
}