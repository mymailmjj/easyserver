/**
 * 
 */
package easyserver.lifecycle;

/**
 * @author cango
 *
 */
public interface LifeCycle {
    
    public final static String NEW = "new";
    
    public final static String START_INIT = "start_init";
    
    public final static String INITING = "initing";
    
    public final static String INITIZED = "initized";
    
    
    public final static String BEFORE_START = "before_start";
    
    public final static String STARTING = "starting";
    
    public final static String STARTED = "started";
    
    
    public final static String BEFORE_STOP = "before_stop";
    
    public final static String STOPING = "stoping";
    
    public final static String STOPPED = "started";
    
    public void start();
    
    public void stop();
    
    public void init();

}
