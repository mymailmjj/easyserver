/**
 * 
 */
package requestchain;

/**
 * @author cango
 *
 */
public abstract class AbstractInteceptor implements Inteceptor {
	
	private Inteceptor inteceptor;

	/* (non-Javadoc)
	 * @see requestchain.Inteceptor#setNext(requestchain.Inteceptor)
	 */
	public void setNext(Inteceptor inteceptor) {
		this.inteceptor = inteceptor;
	}

	/* (non-Javadoc)
	 * @see requestchain.Inteceptor#getNext()
	 */
	public Inteceptor getNext() {
		return inteceptor;
	}
	
	protected void beforeIntecept(Message message){
		
	}
	
	protected abstract void execute(Message message);
	

	/* (non-Javadoc)
	 * @see requestchain.Inteceptor#intecept(requestchain.Message)
	 */
	public void intecept(Message message) {
		
		beforeIntecept(message);
		execute(message);
		if(getNext()!=null) getNext().intecept(message);
		afterIntecept(message);
		

	}
	
	protected void afterIntecept(Message request){
		
	}

}
