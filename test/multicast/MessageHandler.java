/**
 * 
 */
package multicast;

/**
 * @author cango
 *
 */
public interface MessageHandler {
	
	public void sendMessage(Messsage messsage);
	
	public void messageReceived(Messsage message);

}
