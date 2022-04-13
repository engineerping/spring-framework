package org.ep.springioctest.annotationcomponentscanautowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@ComponentScan(basePackageClasses = {SysRole.class, SysUser.class})
public class TestAnnotationMain {
	public static void main(String[] args) {
		// 获取容器
		ApplicationContext ac =new AnnotationConfigApplicationContext("org.ep.springioctest.annotationcomponentscanautowired");
		// 获取 bean
		SysUser user = (SysUser) ac.getBean("sysUser");
		//使用bean
		user.setUsername("新用户3");
		System.out.println(user.getUsername());

	}
}
