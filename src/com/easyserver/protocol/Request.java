/**
 * 
 */
package com.easyserver.protocol;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author mujjiang
 * 
 */
public class Request {

	// ��Ų���������
	private Map<String, String> map = new HashMap<String, String>();

	public String getParameter(String key) {
		return map.get(key);
	}

	/**
	 * �������
	 * @param key
	 * @param value
	 */
	public void addParameter(String key, String value) {

		map.put(key, value);

	}

}
