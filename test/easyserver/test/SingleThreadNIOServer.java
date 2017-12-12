/**
 * 
 */
package easyserver.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 经过测试，使用NIO服务器的性能远好于BIO方式的性能，在实际中推荐使用NIO
 * 
 * @author mujjiang
 * 
 */
public class SingleThreadNIOServer {

	public static void handleAccept(SelectionKey key) throws IOException {
		ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
		SocketChannel sc = ssChannel.accept();
		sc.configureBlocking(false);
		sc.register(key.selector(), SelectionKey.OP_READ,
				ByteBuffer.allocateDirect(1024));
	}

	public static void handleRead(SelectionKey key) throws IOException {
		SocketChannel sc = (SocketChannel) key.channel();
		ByteBuffer buf = (ByteBuffer) key.attachment();
		long bytesRead = sc.read(buf);
		while (bytesRead > 0) {
			buf.flip();
			while (buf.hasRemaining()) {
				System.out.print((char) buf.get());
			}
			System.out.println();
			buf.compact();
			bytesRead = sc.read(buf);
		}

		// 这个代码结束
		if (bytesRead <= 0) {
			System.out.println("close server socket");
			successResponse(key);
			sc.close();
		}
	}
	
	public static void successResponse(SelectionKey key) throws IOException{
		ByteBuffer buf = ByteBuffer.allocate(1024);
		buf.put("HTTP/1.1 200 OK \r\n".getBytes());
		buf.flip();
		SocketChannel sc = (SocketChannel) key.channel();
		while (buf.hasRemaining()) {
			System.out.println("server response ...");
			sc.write(buf);
		}
		buf.compact();
		
	}
	
	
	public static void handleWrite(SelectionKey key) throws IOException {
		ByteBuffer buf = (ByteBuffer) key.attachment();
		buf.flip();
		SocketChannel sc = (SocketChannel) key.channel();
		while (buf.hasRemaining()) {
			sc.write(buf);
		}
		buf.compact();
	}
	
	

	static class SingleNIOThreadServer implements Runnable {

		ServerSocketChannel serverSocketChannel;

		Selector selector;

		public SingleNIOThreadServer() {
			System.out.println("启动SingleNIOThread Server");
			init();
		}

		public void init() {

			try {
				serverSocketChannel = ServerSocketChannel.open();

				serverSocketChannel.bind(new InetSocketAddress(8082));

				serverSocketChannel.configureBlocking(false);

				selector = Selector.open();

				serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		public void run() {

			while (true) {

				try {
					if (selector.select(2000) == 0) {
						System.out.println("====");
						continue;
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				// 这里的方法是阻塞的，请求的时候会触发想要的keytype,然后继续往下执行
				Set<SelectionKey> selectedKeys = selector.selectedKeys();

				Iterator<SelectionKey> iterator = selectedKeys.iterator();

				while (iterator.hasNext()) {

					SelectionKey key = iterator.next();
					if (key.isAcceptable()) {
						try {
							handleAccept(key);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (key.isReadable()) {
						try {
							handleRead(key);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (key.isWritable()) {
						 try {
							handleWrite(key);
						} catch (IOException e) {
							e.printStackTrace();
						}
					} else if (key.isConnectable()) {

					}

					iterator.remove();

				}

			}

		}

	}
	
	
	public static void main(String[] args) {
		
		new Thread(new SingleNIOThreadServer()).start();
		
	}

}
