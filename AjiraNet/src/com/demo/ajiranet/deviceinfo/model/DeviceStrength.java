package com.demo.ajiranet.deviceinfo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "devices")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeviceStrength {

  private String name;
  private int strength;

  public int getStrength() {
	return strength;
}

public void setStrength(int strength) {
	this.strength = strength;
}


  public DeviceStrength() {
	  super();
  }
  
public DeviceStrength( String name, int strength) {
	super();
	this.name = name;
	this.strength =strength;
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
