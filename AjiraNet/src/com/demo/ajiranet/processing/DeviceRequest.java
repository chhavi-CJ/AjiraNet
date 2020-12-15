package com.demo.ajiranet.processing;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.demo.ajiranet.deviceinfo.model.Devices;
import com.demo.ajiranet.dummydatabase.Database;

public class DeviceRequest {
	
	private static Map< String, String> devices = Database.getAllDevices();
	private static Map< String, Integer> DeviceStrength = Database.getAllDevicesStrengths();
	private static List<Devices> devicearray = Database.getAllDevicesinarray();

	public static  List<Devices> makeDeviceRequest(){
		Devices d1= new Devices("Computer", "A1");
		Devices d2= new Devices("Repeater", "A2");		
		List<Devices> lis= new ArrayList<>();
		lis.add(d1);
		lis.add(d2);
		return lis;
	}
	
	public static  Map<String, String> deviceRequest(){
		System.out.println("DeviceNames in get --"+devices.values());
		return devices;
	}
	
	
	
	public static  List<String> deviceNameRequest(){
		ArrayList<String> valueList = new ArrayList<String>();
	for(Devices d : devicearray) {
		valueList.add(d.getname());
	}
	return valueList;
	}

	//checks if the entered device name is present in the list  returned by deviceNameRequest
	public static boolean containDevice(String deviceName, List<String> arr){
		return arr.contains(deviceName); 
	}

	//checks if the named devise is a repeater of computer
	public static Boolean checkDeviceType(String deviceName) {
		String deviceType="";
		for(Devices d : devicearray) {
			  if(d.getname().contains(deviceName)){
				  deviceType=d.gettype();
			  }
		}
		System.out.println("devicetype"+deviceType);
		if(deviceType.equalsIgnoreCase("COMPUTER"))
			return true;
		else
			return false;
	}

	public String addDeviceinarray(Devices devices) {	
		String deviceType = devices.gettype();
		String deviceName = devices.getname();
		String message="";
		DeviceStrength.put(deviceName, 5);
		if(!(deviceType.toUpperCase().equalsIgnoreCase("COMPUTER") || deviceType.toUpperCase().equalsIgnoreCase("REPEATER")) ){
			  message = "typeNotSupported";
			  return message;
		}
		for(Devices d : devicearray) {
			  if(d.getname().contains(deviceName)){
				  System.out.println("device alredy added");
				  message="duplicate";
				  return message;
			  }
		}
		devicearray.add(devices); 
		message="good";
		return message;
	}

	public static List<Devices> deviceRequestfromarray() {
		return devicearray;
	}

}
