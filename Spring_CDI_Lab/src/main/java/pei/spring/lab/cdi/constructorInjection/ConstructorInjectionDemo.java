package pei.spring.lab.cdi.constructorInjection;


import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import pei.spring.lab.cdi.common.MessageProvider;
import static pei.spring.lab.cdi.utils.Utils.*;


public class ConstructorInjectionDemo {
	
	@Test
	public void testCiViaXml() throws Exception {
		try(GenericXmlApplicationContext ctx = new GenericXmlApplicationContext()){
			ctx.load("classpath:" + APP_CTX_XML);
			ctx.refresh();
			System.out.println((ctx.getBean("xmlSomeService", XmlSomeService.class)).getSth());
		}
	}
	
	@Test
	public void testCiViaXml2() throws Exception {
		try(ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(APP_CTX_XML)){
			System.out.println(ctx.getBean("provider2", MessageProvider.class).getMessage());
		}
	}
	
	@Test
	public void testCiViaAnnotation() throws Exception {
		try(GenericXmlApplicationContext ctx = new GenericXmlApplicationContext()){
			ctx.load("classpath:"+ APP_CTX_ANNO);
			ctx.refresh();
			System.out.println((ctx.getBean("annotationSomeService", AnnotationSomeService.class)).getSth());
		}
	}
	

	@Test
	public void testCiViaAnnotation2() throws Exception {
		try(GenericXmlApplicationContext ctx = new GenericXmlApplicationContext()){
			ctx.load("classpath:"+ APP_CTX_ANNO);
			ctx.refresh();
			System.out.println(ctx.getBean("provider3", MessageProvider.class).getMessage());
		}

	}

}
