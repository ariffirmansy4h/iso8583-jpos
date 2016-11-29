package net.iso8583.client;

import org.jpos.iso.ISOPackager;
import org.jpos.iso.packager.GenericPackager;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.channel.CSChannel;
import java.util.Date;
import java.text.SimpleDateFormat;

class Application{
	public static void main(String[]args){
		try{
			Date date = new Date();
    		SimpleDateFormat sdf = new SimpleDateFormat ("hhmmssddMM");
    		String dateTime = sdf.format(date);

			ISOMsg request = new ISOMsg();
			ISOPackager packager = new GenericPackager("../packager/descriptionPackager.xml");
			CSChannel channel = new CSChannel("localhost", 4444, packager);
			
			request.setMTI("0200");
			request.set(2, "user1");
			request.set(3, "pass1");
			request.set(4, "100000");
			request.set(5, "pay00");
			request.set(6, dateTime);

			channel.connect();
			channel.send(request);
			System.out.println("Send Message "+new String(request.pack()));

			ISOMsg response = channel.receive();
			System.out.println("Response Message "+new String(response.pack()));

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}