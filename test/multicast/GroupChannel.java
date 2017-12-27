/**
 * 
 */
package multicast;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author cango
 *
 */
public class GroupChannel implements MessageHandler,HeartBeat{
	
	/**
     * A list of membership listeners that subscribe to membership announcements
     */
    protected List<Object> messageHandlers = new CopyOnWriteArrayList<Object>();
    
    
    
    
    
    private int port;
    
    private String nodeName;
    
    public GroupChannel (int port,String nodeName){
    	this.port = port;
    	this.nodeName = nodeName;
    	init();
    	addListener(this);
    	
    }
    
	
	private MultiCastServer multiCastServer;
	
	private void init(){
		
		multiCastServer = new MultiCastServer(port, nodeName);
		
	}

	public void addListener(MessageHandler hanlder){
		messageHandlers.add(hanlder);
	}
	
	public void start(){
		
		multiCastServer.start();
		
	}

	public void sendMessage(Messsage messsage) {
		
		
		
	}

	public void messageReceived(Messsage message) {
		
		
		
	}

	public void heatbeat() {
		
	}
	
	
	
	
}
