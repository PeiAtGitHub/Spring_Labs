package pei.spring.lab.cdi.autowire;

import static org.junit.Assert.*;
import static pei.spring.lab.cdi.utils.Utils.*;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import lombok.Getter;

public class AutowireDemo {

	@Test
	public void testSetterAutowire() throws Exception {
		try (GenericXmlApplicationContext ctx = new GenericXmlApplicationContext()) {
			ctx.load("classpath:"+ APP_CTX_ANNO);
			ctx.refresh();
			System.out.println(ctx.getBean(Target1.class).toString());
		}
	}

	@Test
	public void testAppConfig() throws Exception {
		try (GenericApplicationContext ctx = new AnnotationConfigApplicationContext(TargetConfig.class)) {
			System.out.println(ctx.getBean(Target1.class).toString());
		}
	}
	
	@Test
	public void testXmlAutowire() throws Exception {

		try(GenericXmlApplicationContext ctx = new GenericXmlApplicationContext()){
			ctx.load("classpath:"+ APP_CTX_XML);
			ctx.refresh();
			System.out.println(ctx.getBean("target2ByName", Target2.class).toString());
			System.out.println(ctx.getBean("target2ByType", Target2.class).toString());
			System.out.println(ctx.getBean("target2Constructor", Target2.class).toString());
		}
	}
	
}

@Configuration @Getter
class TargetConfig {

	@Bean
	public Target1 target1() {
		return new Target1();
	}

	@Bean
	public Foo fooImpl1() {
		return new FooImpl1("ANNO Config Foo Impl 1");
	}

	@Bean 
	public Foo fooImpl2() {
		return new FooImpl2("ANNO Config Foo Impl 2");
	}

	@Bean
	public Bar bar() {
		return new Bar("ANNO Config bar");
	}

}
