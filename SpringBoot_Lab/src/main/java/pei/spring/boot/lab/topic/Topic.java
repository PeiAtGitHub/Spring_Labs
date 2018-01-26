package pei.spring.boot.lab.topic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Topic {
	
	private String id;
	private String name;
	private String description;
	
}
