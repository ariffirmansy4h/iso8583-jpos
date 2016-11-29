package net.iso8583.server;

import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOSource;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOException;
import java.io.IOException;
import net.iso8583.server.Handle;

class Listener implements ISORequestListener{
	public boolean process(ISOSource isoSource, ISOMsg isoMsg){
		try{
			String mti = isoMsg.getMTI();
			if(mti.equals("0200")){
				return new Handle().Payment(isoSource, isoMsg);
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}catch(ISOException isoe){
			isoe.printStackTrace();
		}
		return false;
	}
}