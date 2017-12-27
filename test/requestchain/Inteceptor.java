/**
 * 
 */
package requestchain;

/**
 * @author cango
 *
 */
public interface Inteceptor {
	
	public void setNext(Inteceptor next);
	
	public Inteceptor getNext();
	
	public void intecept(Message request);
	

}
