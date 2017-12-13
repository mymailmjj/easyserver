/**
 * 
 */
package com.easyserver.protocol;

import com.easyserver.base.NioChannel;
import com.easyserver.base.SocketWapper;

/**
 * 对输入的byte[]进行处理
 * @author cango
 *
 */
public class HttpRequestHandler<T> {
	
	/**
	 * 解析请求体
	 * @param socketWapper
	 */
	private void parseRequestBody(SocketWapper<T> socketWapper){
		
	}
	
	
	/**
	 * 解析请求行
	 */
	private void parseRequestLine(SocketWapper<T> socketWapper){
		
	}
	
	/**
	 * 解析请求头
	 * @param socketWapper
	 */
	private void parseMimeHeader(SocketWapper<T> socketWapper){
		
	}
	
	
	/**
	 * 
	 * @param socketWapper
	 * @param request
	 */
	public void parseRequest(SocketWapper<T> socketWapper,HttpRequest request){
		
		System.out.println("hihi");
		
	}

}
