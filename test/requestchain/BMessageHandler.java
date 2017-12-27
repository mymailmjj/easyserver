/**
 * 
 */
package requestchain;


/**
 * @author cango
 *
 */
public class BMessageHandler implements MessageHandler {

	/* (non-Javadoc)
	 * @see multicast.MessageHandler#canProcess(multicast.Request)
	 */
	public boolean canProcess(Message request) {
		return request instanceof BMesssage;
	}

	/* (non-Javadoc)
	 * @see multicast.MessageHandler#handle(multicast.Request)
	 */
	public void handle(Message r) {
		// TODO Auto-generated method stub

	}

}
