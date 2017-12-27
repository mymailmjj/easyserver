/**
 * 
 */
package requestchain;

/**
 * @author cango
 *
 */
public abstract class AbstractHandlerInteceptor implements Inteceptor {
	
	private Inteceptor inteceptor;
	

	/* (non-Javadoc)
	 * @see multicast.Inteceptor#setNext(multicast.Inteceptor)
	 */
	public void setNext(Inteceptor inteceptor) {
		this.inteceptor = inteceptor;

	}

	/* (non-Javadoc)
	 * @see multicast.Inteceptor#getNext()
	 */
	public Inteceptor getNext() {
		return inteceptor;
	}

}
