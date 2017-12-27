/**
 * 
 */
package multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.concurrent.TimeUnit;

/**
 * @author cango
 * 
 */
public class MutiCastServer {

	private DatagramPacket datagramPacket;

	private DatagramPacket receivePacket;

	private int port;

	private String nodeName;

	private String sendContent = "I sende messages from " + nodeName;

	private InetAddress address;

	public MutiCastServer(int port, String nodeName) {
		this.port = port;
		this.nodeName = nodeName;
		init();
	}

	private void init() {
		try {
			address = InetAddress.getByName("228.0.0.4");
			multicastSocket = new MulticastSocket(port);
			multicastSocket.joinGroup(address);
			String str = nodeName+"发送的消息";
			byte[] buffer = str.getBytes();
			datagramPacket = new DatagramPacket(buffer,
					buffer.length, address, port); 
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private MulticastSocket multicastSocket;

	private class SendService implements Runnable {

		public void run() {

			while (true) {
				try {
					multicastSocket.send(datagramPacket);
					System.out.println(nodeName+"发送消息");
					TimeUnit.SECONDS.sleep(1);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}

	private class ReceiveService implements Runnable {

		public void run() {
			
			
			while(true){
				try {
					
					byte[] buffer = new byte[1024];

					DatagramPacket datagramPacket = new DatagramPacket(buffer,
							buffer.length);
					
					multicastSocket.receive(datagramPacket);
					
					String s = new String(datagramPacket.getData(), 0,
							datagramPacket.getLength());
					
					System.out.println(nodeName+"\treceive " +"\tcontent:" + s);
					
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	
	public void start(){
		
		Thread t1 = new Thread(new SendService());
		
		Thread t2 = new Thread(new ReceiveService());
		
		t1.start();
		
		t2.start();
		
	}

}
