/**
 * 
 */
package easyserver.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 使用bio实现的服务器单线程阻塞模型
 * 经过测试，使用NIO服务器的性能远好于BIO方式的性能，在实际中推荐使用NIO
 * 
 * @author mujjiang
 * 
 */
public class SingleThreadBIOServer {

	static class SingleThreadServer implements Runnable {

		ServerSocket serverSocket;

		Random random;

		@Override
		public void run() {
			try {
				System.out.println("启动单线程bio服务器..........");
				serverSocket = new ServerSocket(8081);
				random = new Random();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			InputStream inputStream = null;

			OutputStream outputStream = null;
			
			Socket accept = null;

			while (true) {

				try {
					accept = serverSocket.accept();

					inputStream = accept.getInputStream();

					byte[] bytes = new byte[inputStream.available()];

					inputStream.read(bytes);

					System.out.println(new String(bytes));

					outputStream = accept.getOutputStream();

					PrintWriter writer = new PrintWriter(outputStream);

					writer.println("HTTP/1.1 200 OK");// 返回应答消息,并结束应答
					writer.println();// 根据 HTTP 协议, 空行将结束头信息
					
					writer.flush();
					
					TimeUnit.SECONDS.sleep(1);
					
					writer.close();

				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						outputStream.close();
						inputStream.close();
						accept.close();
					} catch (IOException e) {
						e.printStackTrace();
					}

				}
			}
		}

	}

	public static void main(String[] args) {

		SingleThreadServer singleThreadServer = new SingleThreadServer();

		new Thread(singleThreadServer).start();

	}

}
