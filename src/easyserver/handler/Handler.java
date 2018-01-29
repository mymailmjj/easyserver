/**
 * 
 */
package easyserver.handler;

/**
 * @author cango
 *
 */
public interface Handler {
    
    public void setNext(Handler next);
    
    public boolean canHandle(Object obj);
    
    public Object heandle(Object o);

}
