/**
 * 
 */
package easyserver.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cango
 *
 */
public class RequestHandler extends AbstractHandler {
    
    Logger logger = LoggerFactory.getLogger(RequestHandler.class);

    /* (non-Javadoc)
     * @see easyserver.handler.Handler#canHandle(java.lang.Object)
     */
    public boolean canHandle(Object obj) {
        // TODO Auto-generated method stub
        return false;
    }


    @Override
    public Object innerhandle(Object o) {
        logger.info(this.getClass()+"\tprint:"+o);
        return o;
    }

}
