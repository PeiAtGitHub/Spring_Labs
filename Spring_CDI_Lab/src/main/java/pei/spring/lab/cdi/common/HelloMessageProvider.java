package pei.spring.lab.cdi.common;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HelloMessageProvider implements MessageProvider {

    public String getMessage() {
        return "Hello!";
    }
}
