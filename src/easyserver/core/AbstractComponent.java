/**
 * 
 */
package easyserver.core;

import easyserver.lifecycle.LifeCycleBase;
import easyserver.status.ComponentStatus;

/**
 * @author cango
 * 
 */
public abstract class AbstractComponent extends LifeCycleBase {

	protected ComponentStatus componentStatus;

	protected void setComponentStatus(ComponentStatus componentStatus) {
		this.componentStatus = componentStatus;
	}

	protected abstract void initComponent();

    @Override
    protected void init_inner() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void start_inner() {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void stop_inner() {
        // TODO Auto-generated method stub
        
    }


}
