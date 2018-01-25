/**
 * 
 */
package easyserver.lifecycle;

/**
 * @author cango
 *
 */
public class LifeCycleEvent {
    
    public Object source;
    
    private String lifeCycleType;

    public LifeCycleEvent(Object source, String lifeCycleType) {
        this.source = source;
        this.lifeCycleType = lifeCycleType;
    }
    
    
}
