/**
 * 
 */
package easyserver.server;

import sun.java2d.loops.ProcessPath.ProcessHandler;
import easyserver.core.AbstractComponent;
import easyserver.handler.Handler;

/**
 * @author cango
 * 
 */
public abstract class AbstractServer extends AbstractComponent implements Server{

	protected ProcessHandler processHandler;

	protected Handler heaHandler;
	
	protected abstract Object invokeHandler(Object o);
	
	protected abstract void createHandler();

}
