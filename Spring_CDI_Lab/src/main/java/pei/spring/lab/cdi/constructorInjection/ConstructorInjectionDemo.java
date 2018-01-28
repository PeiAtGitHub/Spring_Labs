package pei.spring.lab.cdi.constructorInjection;


import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import pei.spring.lab.cdi.common.MessageProvider;

public class ConstructorInjectionDemo {
	
	@Test
	public void testCiViaXml() throws Exception {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring-cdi/app-context.xml");
		ctx.refresh();
		System.out.println((ctx.getBean("xmlSomeService", XmlSomeService.class)).getSth());
		ctx.close();
	}
	
	@Test
	public void testCiViaXml2() throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-cdi/app-context.xml"); 
		System.out.println(ctx.getBean("provider2", MessageProvider.class).getMessage());
		ctx.close();
	}
	
	@Test
	public void testCiViaAnnotation() throws Exception {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring-cdi/app-context-annotated.xml");
		ctx.refresh();
		System.out.println((ctx.getBean("annotationSomeService", AnnotationSomeService.class)).getSth());
		ctx.close();

	}
	

	@Test
	public void testCiViaAnnotation2() throws Exception {
	    GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring-cdi/app-context-annotated.xml");
        ctx.refresh();
        System.out.println(ctx.getBean("provider3", MessageProvider.class).getMessage());
        ctx.close();

	}

}
