package config;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//<context:component-scan base-package="annotation.member" />
@Configuration
@ComponentScan(basePackages = "config")
public class MyConfig {
	public static void main(String[] args) {
		ApplicationContext factory =
				new AnnotationConfigApplicationContext(MyConfig.class);
		System.out.println("===================================");
		String[] beanNames = factory.getBeanDefinitionNames();
		for(String name : beanNames) {
			System.out.println(name);
		}// for end
		}
	@Bean
	ArrayList getList() {
		ArrayList list = new ArrayList();
		list.add(100);
		return list;
	}
}
