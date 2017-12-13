/**
 * 
 */
package com.easyserver.protocol;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 请求体,也是key-value形式
 * @author cango
 *
 */
public class HttpBody {
	
	/**
	 * 默认没有初始化
	 */
	private boolean isInitialized = false;
	

	public boolean isInitialized() {
		return isInitialized;
	}

	public void setInitialized(boolean isInitialized) {
		this.isInitialized = isInitialized;
	}

	public Map<String, String> getBody() {
		return body;
	}

	public void setBody(Map<String, String> body) {
		this.body = body;
	}

	public Map<String,String> body = new ConcurrentHashMap<String, String>();
	
	/**
	 * 添加入头信息
	 * @param key
	 * @param value
	 */
	public void addHeader(String key,String value){
		body.put(key, value);
	}
	
	/**
	 * 
	 * 从header里面取出某个值
	 * @param key
	 * @return
	 */
	public String getHeaderValue(String key){
		return body.get(key);
	}
	
}
