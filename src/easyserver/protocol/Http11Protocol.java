/**
 * 
 */
package easyserver.protocol;

import easyserver.acceptor.Http11NioAcceptor;
import easyserver.processor.Http11Processor;

/**
 * @author cango
 *
 */
public class Http11Protocol extends Protocol{
	
	private Http11Processor http11Processor = new Http11Processor();
	
	private Http11NioAcceptor http11NioAcceptor = new Http11NioAcceptor();
	
	public void start(){
		
	}


}
