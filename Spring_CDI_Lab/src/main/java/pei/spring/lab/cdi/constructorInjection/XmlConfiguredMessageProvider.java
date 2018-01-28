package pei.spring.lab.cdi.constructorInjection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pei.spring.lab.cdi.common.MessageProvider;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class XmlConfiguredMessageProvider implements MessageProvider {
	
	private String message = "Default message";

}
