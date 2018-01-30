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
public class Http11Handler extends AbstractHandler {
    
    Logger logger = LoggerFactory.getLogger(Http11Handler.class);

    /* (non-Javadoc)
     * @see easyserver.handler.Handler#canHandle(java.lang.Object)
     */
    public boolean canHandle(Object obj) {
        return false;
    }

    @Override
    public Object innerhandle(Object o) {
        logger.info(this.getClass()+"\tprint:"+o);
        return o;
        
    }


}
