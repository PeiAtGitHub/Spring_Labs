package pei.spring.lab.cdi.helloworld;

public interface MessageRenderer {
    
	void render();
    
    void setMessageProvider(MessageProvider provider);

    MessageProvider getMessageProvider();
}
