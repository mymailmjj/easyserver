/**
 * 
 */
package multicast;

import java.net.DatagramPacket;

import requestchain.Message;

/**
 * @author cango
 *
 */
public class Messsage {

	private DatagramPacket datagramPacket; 
	
	public Messsage(DatagramPacket datagramPacket){
		this.datagramPacket = datagramPacket;
	}
	
	public static Message createHeartBeatMessage(){
		
		
		
		
		
		return null;
	}
	
	
}
