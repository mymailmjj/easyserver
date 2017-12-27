/**
 * 
 */
package requestchain;

/**
 * @author cango
 *
 */
public class LastInteceptor extends AbstractInteceptor{

	@Override
	protected void execute(Message message) {
		System.out.print("LastInteceptor process");
	}


}
