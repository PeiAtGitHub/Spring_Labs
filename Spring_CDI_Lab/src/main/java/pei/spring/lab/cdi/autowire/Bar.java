package pei.spring.lab.cdi.autowire;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component @ToString @NoArgsConstructor @AllArgsConstructor @Setter
public class Bar {
    
	String desc = "DEFAULT bar";

}
