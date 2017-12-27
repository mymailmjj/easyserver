/**
 * 
 */
package multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 这个是组播的原理测试案例
 * @author cango
 * 
 */
public class MultiCastServer {
	
	private DatagramPacket datagramPacket;

	private DatagramPacket receivePacket;

	private int port;

	private String nodeName;

	private String sendContent = "I sende messages from " + nodeName;

	private InetAddress address;
	
	private GroupChannel groupChannel;

	public MultiCastServer(int port, String nodeName,GroupChannel groupChannel) {
		this.port = port;
		this.nodeName = nodeName;
		this.groupChannel = groupChannel;
		init();
	}
	
	public MultiCastServer(int port, String nodeName){
		this(port, nodeName, null);
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
					//invoke handler
					Messsage messsage = new Messsage(datagramPacket);
					invokeMessageSendListen(messsage);
					
					TimeUnit.SECONDS.sleep(1);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}
	
	
	/**
	 * 接收消息监听器
	 * @param messsage
	 */
	private void invokeMessageSendListen(Messsage messsage){
	
		if(this.groupChannel!=null){
			List<Object> lists = groupChannel.messageHandlers;
			
			Iterator<Object> iterator = lists.iterator();
			
			while(iterator.hasNext()){
				MessageHandler messageHandler = (MessageHandler) iterator.next();
				messageHandler.sendMessage(messsage);
			}
		}
		
	}
	
	
	
	
	/**
	 * 接收消息监听器
	 * @param messsage
	 */
	private void invokeMessageReceiveListen(Messsage messsage){
	
		if(this.groupChannel!=null){
			List<Object> lists = groupChannel.messageHandlers;
			
			Iterator<Object> iterator = lists.iterator();
			
			while(iterator.hasNext()){
				MessageHandler messageHandler = (MessageHandler) iterator.next();
				messageHandler.messageReceived(messsage);
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
					
					Messsage messsage = new Messsage(datagramPacket);
					
					invokeMessageReceiveListen(messsage);
					
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
