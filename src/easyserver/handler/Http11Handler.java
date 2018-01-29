/**
 * 
 */
package easyserver.handler;

/**
 * @author cango
 *
 */
public class Http11Handler extends AbstractHandler {

    /* (non-Javadoc)
     * @see easyserver.handler.Handler#canHandle(java.lang.Object)
     */
    public boolean canHandle(Object obj) {
        return false;
    }

    @Override
    public Object innerhandle(Object o) {
        // TODO Auto-generated method stub
        
        return null;
        
    }


}
