/**
 * 
 */
package easyserver.lifecycle;

/**
 * @author cango
 *
 */
public abstract class LifeCycleBase implements LifeCycle {
    
    protected LifeCycleStatus lifeCycleStatus = LifeCycleStatus.NEW;   //刚开始默认是new的状态
    
    public LifeCycleStatus getLifeCycleStatus() {
        return lifeCycleStatus;
    }

    public void setLifeCycleStatus(LifeCycleStatus lifeCycleStatus) {
        this.lifeCycleStatus = lifeCycleStatus;
    }

    protected LifeCycleSupport lifeCycleSupport = new LifeCycleSupport(this);
    
    protected abstract void init_inner();
    
    protected abstract void start_inner();
    
    protected abstract void stop_inner();
    
    public void init(){
        setLifeCycleStatus(LifeCycleStatus.BEFORE_INIT);
        init_inner();
        setLifeCycleStatus(LifeCycleStatus.INILIZED);
    }

    /* (non-Javadoc)
     * @see easyserver.lifecycle.LifeCycle#start()
     */
    public void start() {
        if(!this.lifeCycleStatus.equals(LifeCycleStatus.NEW)){
            try {
                throw new IllegalAccessException("状态异常");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        
        if(this.lifeCycleStatus.equals(LifeCycleStatus.NEW)){
            init();
        }
        
        setLifeCycleStatus(LifeCycleStatus.BEFORE_START);
        start_inner();
        setLifeCycleStatus(LifeCycleStatus.STARTED);

    }

    /* (non-Javadoc)
     * @see easyserver.lifecycle.LifeCycle#stop()
     */
    public void stop() {
        setLifeCycleStatus(LifeCycleStatus.BEFORE_STOP);
        stop_inner();
        setLifeCycleStatus(LifeCycleStatus.STOPPED);
    }
    
    public void notifyAll(String type){
        lifeCycleSupport.notifyAll(type);
    }

}
