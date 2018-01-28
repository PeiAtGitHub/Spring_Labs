package pei.spring.lab.cdi.common;

import java.util.Objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Setter @Getter
public class StdOutMessageRenderer implements MessageRenderer {

	private MessageProvider messageProvider;

	public void render() {
		Objects.requireNonNull(messageProvider, "You must set the property messageProvider of:"
				+ StdOutMessageRenderer.class.getName());
		System.out.println(messageProvider.getMessage());
	}

}
