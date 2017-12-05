/**
 * 
 */
package com.easyserver.base;

/**
 * @author mujjiang
 *
 */
public class SocketWapper<T> {
	
	private T t;
	
	public SocketWapper(T t){
		this.t = t;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	
}
