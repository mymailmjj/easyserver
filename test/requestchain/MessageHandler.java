/**
 * 
 */
package requestchain;


/**
 * @author cango
 *
 */
public interface MessageHandler {
	
	public boolean canProcess(Message request);
	
	public void handle(Message r);
	

}
