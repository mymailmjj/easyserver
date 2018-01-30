package easyserver.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SessionHandler extends AbstractHandler {
    
    Logger logger = LoggerFactory.getLogger(ServletHandler.class);

    @Override
    public Object innerhandle(Object o) {
        
        logger.info(this.getClass()+"print:"+o);
        
        //这里调用request的getsession方法，创建session;
        
        return o;
    }

}
