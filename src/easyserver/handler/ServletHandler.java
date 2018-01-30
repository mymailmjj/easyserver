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
public class ServletHandler extends AbstractHandler{
    
    Logger logger = LoggerFactory.getLogger(ServletHandler.class);
    
    HandlerMapping handlerMapping = new HandlerMapping();

    
    @Override
    public boolean canHandle(Object obj) {
        return true;
    }





    @Override
    public Object innerhandle(Object o) {
        
        logger.info(this.getClass()+"\tprint:"+o);
        
        return o;
    }
    

}
