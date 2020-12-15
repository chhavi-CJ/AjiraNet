package com.demo.ajiranet.dummydatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import com.demo.ajiranet.deviceinfo.model.Devices;

public class Database {
	
	private static Map< String, String> devices = new IdentityHashMap<>();
	private static LinkedHashSet<String> linkedset = new LinkedHashSet<String>();
	private static Map< String, Integer > deviceStrength = new IdentityHashMap<>();
	
	private static List<Devices> devicearray = new  ArrayList<>();
	
	public static Map< String, String> getAllDevices()
	{
		return devices;
	}
	
	public static Map< String, Integer> getAllDevicesStrengths()
	{
		return deviceStrength;
	}
	
	public static List<Devices> getAllDevicesinarray()
	{
		return devicearray;
	}
}
