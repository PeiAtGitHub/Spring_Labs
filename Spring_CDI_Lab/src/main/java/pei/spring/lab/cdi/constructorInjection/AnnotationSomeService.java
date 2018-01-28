package pei.spring.lab.cdi.constructorInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Service("annotationSomeService") @Getter
public class AnnotationSomeService {

	private String sth;

	public AnnotationSomeService(String sth) {
		this.sth = sth;
	}

	@Autowired
	public AnnotationSomeService(@Value("100") int sth) {
		this.sth = "Number: " + Integer.toString(sth);
	}

}
