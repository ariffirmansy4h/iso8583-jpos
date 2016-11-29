package net.iso8583.server;

import org.jpos.iso.ISOServer;
import org.jpos.iso.ISOPackager;
import org.jpos.iso.channel.CSChannel;
import org.jpos.iso.packager.GenericPackager;
import net.iso8583.server.Listener;

class Application{

	private static String host = "localhost";
	private static int port = 4444;

	public static void main(String[]args) throws Exception{
		
		ISOPackager packager = new GenericPackager("../packager/descriptionPackager.xml");
		CSChannel channel = new CSChannel(host, port, packager);
		ISOServer server = new ISOServer(port, channel, null);

		server.addISORequestListener(new Listener());
		new Thread(server).start();

		System.out.println("Server start on ["+port+"]...");
	}
}