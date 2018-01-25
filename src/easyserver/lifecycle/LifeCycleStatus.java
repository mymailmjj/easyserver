/**
 * 
 */
package easyserver.lifecycle;

/**
 * @author cango
 *
 */
public enum LifeCycleStatus {
    
    NEW(LifeCycle.NEW),
    BEFORE_INIT(LifeCycle.START_INIT),
    INITLIZING(LifeCycle.INITING),
    INILIZED(LifeCycle.INITIZED),
    BEFORE_START(LifeCycle.BEFORE_START),
    STARTING(LifeCycle.STARTING),
    STARTED(LifeCycle.STARTED),
    BEFORE_STOP(LifeCycle.BEFORE_STOP),
    STOPING(LifeCycle.STOPING),
    STOPPED(LifeCycle.STOPPED);
    
    private String status;
    
    LifeCycleStatus(String status){
        this.status = status;
    }
    
    public String getStatus(){
        return status;
    }
    

}
