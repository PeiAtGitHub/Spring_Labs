package pei.spring.lab.cdi.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

@Component @Getter @ToString
public class Target1 {

	Foo foo1, foo2;
	Bar bar;

	public Target1() {}
	public Target1(Foo foo1) {}
	public Target1(Foo foo1, Bar bar) {}

	@Autowired @Qualifier("fooImpl1")
	public void setFoo1(Foo foo1) {
		this.foo1 = foo1;
	}

	@Autowired @Qualifier("fooImpl2")
	public void setFoo2(Foo foo2) {
		this.foo2 = foo2;
	}

	@Autowired
	public void setBar(Bar bar) {
		this.bar = bar;
	}


}
