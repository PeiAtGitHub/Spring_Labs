package pei.spring.lab.cdi.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyInjectionDemo {
	
    public static void main(String... args) {
    	//
    	new ClassPathXmlApplicationContext("cdi-helloworld/app-context.xml")
        .getBean("renderer", MessageRenderer.class)
        .render();
    	
    	//
		new AnnotationConfigApplicationContext(AppConfig.class)
		.getBean("renderer", MessageRenderer.class)
		.render();
    }
}


@Configuration
class AppConfig {

	@Bean
	public MessageRenderer renderer(){
		MessageRenderer renderer = new StdErrMessageRenderer();
		renderer.setMessageProvider(provider());
		return renderer;
	}
	
	@Bean
	public MessageProvider provider() {
		return new HelloMessageProvider();
	}
}