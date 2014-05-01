package edu.neumont.csc380.auth.Test;

import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.txw2.annotation.XmlElement;

@XmlRootElement
public class Test {
	String what = "what";
	public Test()
	{
		
	}
	@XmlElement
	public String getWhat() {
		return what;
	}
	public void setWhat(String what) {
		this.what = what;
	}
	
	
}
