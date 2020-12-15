package com.demo.ajiranet.deviceinfo.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "devices")
@XmlAccessorType(XmlAccessType.FIELD)
public class Connection {
	//{"source" : "A1", "targets" : ["A2"]}'
	private String source;
	private String target;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public Connection(String source, String target) {
		super();
		this.source = source;
		this.target = target;
	}
	public Connection() {
		super();
	}

	
}
