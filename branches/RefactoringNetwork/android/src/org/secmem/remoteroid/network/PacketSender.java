package org.secmem.remoteroid.network;

import java.io.*;

/**
 * Provides method for sending packet via stream
 * @author ssm
 */
public class PacketSender {
	
	private OutputStream sendStream;	
	
	public PacketSender(OutputStream stream){
		this.sendStream = stream;		
	}
	
	public void setOutputStream(OutputStream stream){
		this.sendStream = stream;
	}
	
	public void send(Packet packet) throws IOException{
		
		//get packet size for transmission
		int packetSize = packet.getHeader().getPacketLength();
		sendStream.write(packet.asByteArray(), 0, packetSize);		
	}
}
