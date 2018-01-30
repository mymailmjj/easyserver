/**
 * 
 */
package easyserver.handler;

import java.nio.ByteBuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cango
 *
 */
public class ResponseHandler extends AbstractHandler {
    
    Logger logger = LoggerFactory.getLogger(ResponseHandler.class);

    /* (non-Javadoc)
     * @see easyserver.handler.Handler#canHandle(java.lang.Object)
     */
    public boolean canHandle(Object obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Object heandle(Object o) {
        
        logger.info(this.getClass()+"\tprint:"+o);
        
        ByteBuffer buffer = ByteBuffer.wrap("HTTP/1.1 200 OK \r\n".getBytes());
        
        return buffer;
    }


}
