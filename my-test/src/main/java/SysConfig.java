import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 *
 */
@Configuration
public class SysConfig {
	@Bean
	public SysUser sysUser(){
		return new SysUser("新用户","123");
	}
}