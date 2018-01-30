/**
 * 
 */
package easyserver.handler;

import java.nio.ByteBuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 把NIO转换成byte[]
 * @author cango
 *
 */
public class ByteHandler extends AbstractHandler {
    
    Logger logger = LoggerFactory.getLogger(ByteHandler.class);
    

    /* (non-Javadoc)
     * @see easyserver.handler.Handler#canHandle(java.lang.Object)
     */
    public boolean canHandle(Object obj) {
        return obj instanceof ByteBuffer;
    }

    @Override
    public Object innerhandle(Object o) {
        
        logger.info(this.getClass()+"\tprint:"+o);
        
        return o;
        
    }

}
