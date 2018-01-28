package pei.spring.lab.cdi.constructorInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Getter;
import pei.spring.lab.cdi.common.MessageProvider;

@Service("provider3") @Getter
public class AnnotationConfiguredMessageProvider implements MessageProvider {

	private String message;

	@Autowired
	public AnnotationConfiguredMessageProvider(String message) {
		this.message = message;
	}

}
