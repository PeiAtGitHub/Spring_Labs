package pei.spring.lab.cdi.constructorInjection;


import lombok.Getter;

@Getter
public class XmlSomeService {

	private String sth;
	
	public XmlSomeService(String sth) {
		this.sth = sth;
	}

	public XmlSomeService(int sth) {
		this.sth = "Number: " + Integer.toString(sth);
	}

}
