/**
 * 
 */
package requestchain;


/**
 * @author cango
 *
 */
public class CommonHandler implements MessageHandler {

	/* (non-Javadoc)
	 * @see multicast.MessageHandler#canProcess(multicast.Request)
	 */
	public boolean canProcess(Message request) {
		return true;
	}

	/* (non-Javadoc)
	 * @see multicast.MessageHandler#handle(multicast.Request)
	 */
	public void handle(Message r) {
		System.out.println("commonhandler process "+r);
	}

}
