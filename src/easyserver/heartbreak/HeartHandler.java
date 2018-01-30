package easyserver.heartbreak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import easyserver.handler.AbstractHandler;

/**
 * 心跳的handler
 * @author cango
 *
 */
public class HeartHandler extends AbstractHandler{
    
    Logger logger = LoggerFactory.getLogger(HeartHandler.class);

    @Override
    public Object innerhandle(Object o) {
        logger.info(this.getClass()+"\tprint:"+o);
        return o;
    }


}
