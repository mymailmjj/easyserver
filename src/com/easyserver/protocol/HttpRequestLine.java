/**
 * 
 */
package com.easyserver.protocol;

/**
 * 
 * http前台的请求行
 * @author cango
 *
 *请求的例子：
 *GET /books/?name=Professional%20Ajax HTTP/1.1
 *
 */
public class HttpRequestLine {
	
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


	public enum Method{
		GOT,POST
	}
	
	public enum Protocol{
		HTTP11
	}
	
	/**
	 * 请求的方法
	 */
	public Method requestMethod;
	
	/**
	 * 请求协议
	 */
	public Protocol requestProtocol;
	
	
	/**
	 * 请求的url
	 */
	public String requestUrl;


	public Method getRequestMethod() {
		return requestMethod;
	}


	public void setRequestMethod(Method requestMethod) {
		this.requestMethod = requestMethod;
	}


	public Protocol getRequestProtocol() {
		return requestProtocol;
	}


	public void setRequestProtocol(Protocol requestProtocol) {
		this.requestProtocol = requestProtocol;
	}


	public String getRequestUrl() {
		return requestUrl;
	}


	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	
	
	

}
