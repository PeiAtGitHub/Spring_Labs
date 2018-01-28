package pei.spring.lab.cdi.common;

public interface MessageRenderer {
    
	void render();
    
    void setMessageProvider(MessageProvider provider);

    MessageProvider getMessageProvider();
}
