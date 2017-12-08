/**
 * 
 */
package com.easyserver.protocol;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author mujjiang
 * 
 */
public class Request {

	private final Map<String, Object> attributes = new ConcurrentHashMap<String, Object>();

	/**
	 * Path parameters
	 */
	protected Map<String, String> pathParameters = new HashMap<String, String>();

	protected void addPathParameter(String name, String value) {
		pathParameters.put(name, value);
	}

	public Object getAttribute(String name) {

		Object attr = attributes.get(name);

		if (attr != null) {
			return (attr);
		}

		return null;

	}

	public void setAttribute(String name, Object value) {

		// Null value is the same as removeAttribute()
		if (value == null) {
			removeAttribute(name);
			return;
		}

		Object oldValue = attributes.put(name, value);

	}

	public void removeAttribute(String name) {
		// Remove the specified attribute

		boolean found = attributes.containsKey(name);
		if (found) {
			Object value = attributes.get(name);
			attributes.remove(name);
		} else {
			return;
		}
	}

}
