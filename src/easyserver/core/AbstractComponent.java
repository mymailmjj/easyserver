/**
 * 
 */
package easyserver.core;

import easyserver.lifecycle.LifeCycleBase;
import easyserver.lifecycle.LifeCycleStatus;

/**
 * @author cango
 * 
 */
public abstract class AbstractComponent extends LifeCycleBase {

    @Override
    protected void init_inner() {
       setLifeCycleStatus(LifeCycleStatus.INITLIZING);
        
    }

    @Override
    protected void start_inner() {
        setLifeCycleStatus(LifeCycleStatus.STARTING);
        
    }

    @Override
    protected void stop_inner() {
        setLifeCycleStatus(LifeCycleStatus.STOPING);
        
    }


}
