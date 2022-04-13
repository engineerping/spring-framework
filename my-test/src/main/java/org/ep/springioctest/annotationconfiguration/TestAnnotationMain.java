package org.ep.springioctest.annotationconfiguration;

import org.ep.springioctest.SysUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

public class TestAnnotationMain {
	public static void main(String[] args) {
		// 获取容器
		ApplicationContext ac =new AnnotationConfigApplicationContext(SysConfig.class);
		// 获取 bean
		SysUser user = (SysUser) ac.getBean("sysUser2");
		// 使用bean
		System.out.println(user.getUsername());
		System.out.println("Success");

	}
}
