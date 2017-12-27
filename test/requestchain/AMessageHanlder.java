/**
 * 
 */
package requestchain;


/**
 * @author cango
 *
 */
public class AMessageHanlder implements MessageHandler {

	/* (non-Javadoc)
	 * @see multicast.MessageHandler#canProcess(multicast.Request)
	 */
	public boolean canProcess(Message request) {
		return request instanceof AMessage;
	}

	/* (non-Javadoc)
	 * @see multicast.MessageHandler#handle(multicast.Request)
	 */
	public void handle(Message r) {
		AMessage ra = (AMessage)r;
		System.out.println("A messageHandler");
	}

}
