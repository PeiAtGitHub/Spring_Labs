package pei.spring.lab.cdi.autowire;

import org.springframework.context.support.GenericXmlApplicationContext;

import lombok.Setter;
import lombok.ToString;

@Setter @ToString
public class Target2 {
	
    private Foo foo1, foo2;
    private Bar bar;

    public Target2() {}
    public Target2(Foo foo) {}
    public Target2(Foo foo, Bar bar) {}
    
}
