/**
 * 
 */
package easyserver.core;

import easyserver.status.ComponentStatus;

/**
 * @author cango
 * 
 */
public abstract class AbstractComponent implements Component {

	protected ComponentStatus componentStatus;

	protected void setComponentStatus(ComponentStatus componentStatus) {
		this.componentStatus = componentStatus;
	}

	protected abstract void initComponent();

	public void start() {

	}

	public void stop() {

	}

}
