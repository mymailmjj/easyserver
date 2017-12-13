/**
 * 
 */
package com.easyserver.protocol;

/**
 * 
 * @author mujjiang
 * 
 */
public interface Request {

	/**
	 * 获取请求的某个参数
	 * @param paramter
	 * @return
	 */
	public String getParameter(String paramter);
	
	
	public HttpHeader getHeader();

}
