/**
 * 
 */
package com.easyserver.protocol;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cango
 *
 */
public class HttpRequest {
	
	//这里是http请求的对象
	
	//请求行
	private HttpRequestLine httpRequestLine;
	
	//请求头
	private HttpHeader httpHeader;  
	
	public HttpRequestLine getHttpRequestLine() {
		return httpRequestLine;
	}

	public void setHttpRequestLine(HttpRequestLine httpRequestLine) {
		this.httpRequestLine = httpRequestLine;
	}

	public HttpHeader getHttpHeader() {
		return httpHeader;
	}

	public void setHttpHeader(HttpHeader httpHeader) {
		this.httpHeader = httpHeader;
	}

	public HttpBody getHttpBody() {
		return httpBody;
	}

	public void setHttpBody(HttpBody httpBody) {
		this.httpBody = httpBody;
	}

	//请求体
	private HttpBody httpBody;
	
	
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
