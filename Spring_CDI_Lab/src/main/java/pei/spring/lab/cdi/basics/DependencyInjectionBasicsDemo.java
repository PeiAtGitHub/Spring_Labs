package pei.spring.lab.cdi.basics;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pei.spring.lab.cdi.common.HelloMessageProvider;
import pei.spring.lab.cdi.common.MessageProvider;
import pei.spring.lab.cdi.common.MessageRenderer;
import pei.spring.lab.cdi.common.StdErrMessageRenderer;

import static pei.spring.lab.cdi.utils.Utils.*;

public class DependencyInjectionBasicsDemo {
	
    public static void main(String... args) {
    	//
    	try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(APP_CTX_XML)){
    		ctx.getBean("renderer", MessageRenderer.class).render();
    	}
    	
    	//
    	try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)){
    		ctx.getBean("renderer", MessageRenderer.class).render();
    	}
		
    }
    
    @Configuration
    static class AppConfig {

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
}


