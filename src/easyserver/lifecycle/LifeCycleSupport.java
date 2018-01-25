/**
 * 
 */
package easyserver.lifecycle;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author cango
 *
 */
public class LifeCycleSupport {
    
    private LifeCycle lifeCycle;
    
    private HashSet<LifeCycleListener> listeners = new HashSet<LifeCycleListener>();

    public LifeCycleSupport(LifeCycle lifeCycle) {
        this.lifeCycle = lifeCycle;
    }
    
    
    public void notifyAll(String type){
        
        LifeCycleEvent lifeCycleEvent = new LifeCycleEvent(lifeCycle, type);
        
        Iterator<LifeCycleListener> iterator = listeners.iterator();
        
        while(iterator.hasNext()){
            LifeCycleListener listener = iterator.next();
            listener.listen(lifeCycleEvent);
        }
        
    }
    

}
