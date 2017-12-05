/**
 * 
 */
package com.easyserver.protocol;

import java.net.Socket;
import java.nio.channels.SocketChannel;

import com.easyserver.base.NioChannel;
import com.easyserver.base.SocketWapper;

/**
 * @author mujjiang
 *
 */
public class HttpProtocolProcessor {
	
	
	public void process(SocketWapper<NioChannel> socketWapper){
		
		NioChannel t = socketWapper.getT();
		
		SocketChannel socketChannel = t.getSocketChannel();
	
	}
	

}
