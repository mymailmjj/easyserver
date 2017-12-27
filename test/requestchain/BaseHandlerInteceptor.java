/**
 * 
 */
package requestchain;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author cango
 *
 */
public class BaseHandlerInteceptor extends AbstractHandlerInteceptor {
	
	private HashSet<MessageHandler> handlers = new HashSet<MessageHandler>();
	
	public void addMessageHandler(MessageHandler messageHandler){
		handlers.add(messageHandler);
	}
	
	
	public void intecept(Message r) {
		
		Iterator iterator = handlers.iterator();
		
		while(iterator.hasNext()){
			MessageHandler handler = (MessageHandler) iterator.next();
			if(handler.canProcess(r)){
				handler.handle(r);
			}
		}
		
		getNext().intecept(r);
	}

}
