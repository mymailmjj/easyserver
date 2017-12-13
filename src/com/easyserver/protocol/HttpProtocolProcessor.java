/**
 * 
 */
package com.easyserver.protocol;

import java.nio.channels.SocketChannel;

import com.easyserver.base.SocketWapper;

/**
 * @author mujjiang
 *
 */
public class HttpProtocolProcessor {
	
	private HttpRequestHandler<SocketChannel> httpRequestHandler = new HttpRequestHandler<SocketChannel>();
	
	public void process(SocketWapper<SocketChannel> socketWapper){
		
		HttpRequest httpRequest = new HttpRequest();
		
		httpRequestHandler.parseRequest(socketWapper, httpRequest);
	
	}

}
