package pei.spring.lab.cdi.alias;

import static org.junit.Assert.assertSame;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.function.Consumer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class BeanAliasDemo {

	@Rule public TestName name = new TestName();
	
	@Before
	public void beforeTest() {
		System.out.println("xxxxxxxxxxxxxxxxxxx " + name.getMethodName());
	}

	@Test
	public void testName() throws Exception {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring-cdi/app-context-alias.xml");
		ctx.refresh();
		ctx.getBeansOfType(String.class).entrySet().stream().forEach(new idAliasPrinter(ctx));
		
		assertSame((String) ctx.getBean("mike"), (String) ctx.getBean("michael"));
		ctx.close();
	}
	
	@Test
	public void testAnnotated() throws Exception {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring-cdi/app-context-annotated.xml");
		ctx.refresh();
		ctx.getBeansOfType(Singer.class).entrySet().stream().forEach(new idAliasPrinter(ctx));
		ctx.close();
	}
	
	@Test
	public void testAnnoConfig() throws Exception {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AliasBeanConfig.class);
		ctx.getBeansOfType(Singer.class).entrySet().stream().forEach(new idAliasPrinter(ctx));
		ctx.close();
	}
	
	
	@Configuration
	static class AliasBeanConfig {
		@Bean(name = {"johnMayer", "john", "johnny"})
		public Singer singer() {
			return new Singer();
		}
	}

	@Component("bird")
	@Getter @Setter
	static class Singer {
		String name = "";
	}
	
	@AllArgsConstructor
	class idAliasPrinter implements Consumer<Entry<String, ?>>{
		
		GenericApplicationContext ctx;
		
		@Override
		public void accept(Entry<String, ?> entry) {
			String id = entry.getKey();
			System.out.format("Id: %s; Aliases: %s%n", id ,Arrays.toString(ctx.getAliases(id)));
		}
		
	}

}
