package net.iso8583.server;

import org.jpos.iso.ISOSource;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOException;
import java.io.IOException;

class Handle{
	Boolean Payment(ISOSource isoSource, ISOMsg isoMsg) throws IOException, ISOException{
		
		System.out.println("Message in "+new String(isoMsg.pack()));

		ISOMsg respon = (ISOMsg) isoMsg.clone();
		respon.setMTI("0210");
		respon.set(7, "00");
		isoSource.send(respon);

		System.out.println("Message out "+new String(respon.pack()));

		return true;
	}
}