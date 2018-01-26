package pei.spring.lab.cdi.basics;

public interface MessageRenderer {
    
	void render();
    
    void setMessageProvider(MessageProvider provider);

    MessageProvider getMessageProvider();
}
