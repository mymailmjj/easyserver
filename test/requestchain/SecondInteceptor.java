/**
 * 
 */
package requestchain;

/**
 * @author cango
 *
 */
public class SecondInteceptor extends AbstractInteceptor {

	@Override
	protected void execute(Message message) {
		System.out.print("SecondInteceptor process");
	}

}
