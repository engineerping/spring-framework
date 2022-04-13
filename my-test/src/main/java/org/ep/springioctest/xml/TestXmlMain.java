package org.ep.springioctest.xml;

import org.ep.springioctest.SysUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestXmlMain {
	public static void main(String[] args) {
		// 获取容器
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("application-context-test.xml");
		// 获取 bean
		SysUser user = applicationContext.getBean(SysUser.class);
		// 使用 bean
		System.out.println(user.getUsername());
	}
}
