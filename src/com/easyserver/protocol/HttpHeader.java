/**
 * 
 */
package com.easyserver.protocol;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author mujjiang
 *
 */
public class HttpHeader {
	
	
	/**
	 * 默认没有初始化
	 */
	private boolean isInitialized = false;
	
	
	public HttpHeader(boolean isInitialized, Map<String, String> header) {
		super();
		this.isInitialized = isInitialized;
		this.header = header;
	}

	public Map<String,String> header = new ConcurrentHashMap<String, String>();

	/**
	 * 添加入头信息
	 * @param key
	 * @param value
	 */
	public void addHeader(String key,String value){
		header.put(key, value);
	}
	
	/**
	 * 
	 * 从header里面取出某个值
	 * @param key
	 * @return
	 */
	public String getHeaderValue(String key){
		return header.get(key);
	}
	
}
