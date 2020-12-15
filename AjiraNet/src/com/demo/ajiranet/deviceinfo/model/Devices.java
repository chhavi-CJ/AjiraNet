package com.demo.ajiranet.deviceinfo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "devices")
@XmlAccessorType(XmlAccessType.FIELD)
public class Devices {

 
  @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Devices other = (Devices) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

private String type;
  private String name;
//  private HashMap<String, String> adddevicelist = new HashMap<String, String>();

  public String gettype() {
	return type;
}

  public Devices() {
  }
  
public Devices(String type, String name) {
	super();
	this.type = type;
	this.name = name;
}

public void settype(String type) {
	this.type = type;
}

public String getname() {
	return name;
}

public void setname(String name) {
	this.name = name;
}



 


//  @Override
 /* public String toString() {
    return "Event{" +
        "eventId=" + eventId +
        ", eventName='" + eventName + '\'' +
        ", speaker='" + speaker + '\'' +
        ", eventDate='" + eventDate + '\'' +
        ", venue='" + venue + '\'' +
        ", users=" + users +
        '}';
  }*/
}
