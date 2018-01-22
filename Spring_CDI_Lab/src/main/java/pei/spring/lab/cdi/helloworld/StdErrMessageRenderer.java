package pei.spring.lab.cdi.helloworld;

import java.util.Objects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Setter @Getter
public class StdErrMessageRenderer implements MessageRenderer{

	private MessageProvider messageProvider;

	public void render() {
		Objects.requireNonNull(messageProvider, "You must set the property messageProvider of:"
				+ StdErrMessageRenderer.class.getName());
		System.err.println(messageProvider.getMessage());
	}

}
