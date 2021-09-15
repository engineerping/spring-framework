package org.gcsp.springioctest.annotation;

import org.gcsp.springioctest.SysUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class SysConfig {
	@Bean
	public SysUser sysUser2(){
		return new SysUser("新用户","123456789");
	}
}