package pei.spring.lab.cdi.autowire;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component @ToString @AllArgsConstructor @NoArgsConstructor @Setter
public class FooImpl3 implements Foo {

	String desc = "DEFAULT foo impl 3";

}
