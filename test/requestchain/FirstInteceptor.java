/**
 * 
 */
package requestchain;

/**
 * @author cango
 *
 */
public class FirstInteceptor extends AbstractInteceptor {

	@Override
	protected void execute(Message message) {
		System.out.print("FirstInteceptor process");
	}


}
