package com.demo.ajiranet.process;

import com.demo.ajiranet.deviceinfo.model.Devices;
import com.demo.ajiranet.deviceinfo.model.StrengthValue;
import com.demo.ajiranet.deviceinfo.model.Connection;
import com.demo.ajiranet.deviceinfo.model.DeviceStrength;
import com.demo.ajiranet.processing.DeviceRequest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/")
public class NetworkResource {


	@GET
	@Path("FETCH/devices")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Devices> getDevicesfromarray()
	{	
		return DeviceRequest.deviceRequestfromarray();
	}
	
	 @POST
	 @Path("CREATE/devices")
	 @Produces("application/json")
	 @Consumes("application/json")
	 public Response addDevicesinarray(Devices devices) {
		Map<String, String> values = new HashMap<>();
		try{
		if(devices.gettype()== null || devices.getname()==null){
			System.out.println("invalid command");
			}
		}
		catch(NullPointerException e) { 
			String msg="Invalid Command";
	    	values.put("msg", msg);
			return Response.ok(values).build();
        } 	
		DeviceRequest deviceRequest = new DeviceRequest();
		String result = deviceRequest.addDeviceinarray(devices);

	    if(result=="duplicate")
	    {
	    	String msg="Device"+ "'"+devices.getname()+"'" +"already exists ";
	    	values.put("msg", msg);
	    	return Response.ok(values).build();
	    }
	    else if(result=="typeNotSupported"){
	    	String msg="type "+ "'"+devices.gettype()+"'" +"is not supported";
	    	values.put("msg", msg);
	    	return Response.ok(values).build();
	    }
	    else{	    	
	    	String msg="Successfully added "+devices.getname();
	    	values.put("msg", msg);
	    	return Response.ok(values).build();
	    }
	 }
	
	 @PUT
	 @Path("MODIFY/devices/{deviceName}/strength")
	 @Produces("application/json")
	 @Consumes("application/json")
	 public Response modifyDevicesStrength(@PathParam("deviceName") String deviceName, StrengthValue value) {
		 Map<String, String> values = new HashMap<>();
		 List<String> arr= DeviceRequest.deviceNameRequest();
		 boolean ans = DeviceRequest.containDevice(deviceName, arr); 
		 boolean typeresult;
		 if(ans)
		 {
			 typeresult=DeviceRequest.checkDeviceType(deviceName);
			 System.out.println("DeviceNames in get --"+arr+"--devicename--"+deviceName+"--ans--"+ans+"typeresult-"+typeresult);
			 if(typeresult)
			 {
				 if(value.getvalue()<0)
				 {
					 String msg="value should be an integer";
					 values.put("msg", msg);
					 return Response.ok(values).build(); 
				 }
				 else
				 {
				 String msg="Successfully defined strength";
				 values.put("msg", msg);
				 return Response.ok(values).build();
				 }
			 }
			 else
			 {
				 String msg="Repeater Strength can not be modified";
				 values.put("msg", msg);
				 return Response.ok(values).build();
			 }
		 }
		 else{
			 String msg="Device not Found";
			 values.put("msg", msg);
			 return Response.ok(values).build();		 
		 }		
	}
	 
	
	
}
