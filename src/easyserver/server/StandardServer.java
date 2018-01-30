/**
 * 
 */
package easyserver.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import easyserver.handler.ByteHandler;
import easyserver.handler.Handler;
import easyserver.handler.Http11Handler;
import easyserver.handler.RequestHandler;
import easyserver.handler.ResponseHandler;
import easyserver.handler.ServletHandler;

/**
 * @author cango
 * 
 */
public class StandardServer extends AbstractServer {
    
    Logger logger = LoggerFactory.getLogger(StandardServer.class);
    
    private final static int BUFFER_SIZE = 1024;
    
    private Handler handler;

    public void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
        SocketChannel sc = ssChannel.accept();
        sc.configureBlocking(false);    
        sc.register(key.selector(), SelectionKey.OP_READ,
                ByteBuffer.allocateDirect(BUFFER_SIZE));
    }

    public void handleRead(SelectionKey key) throws IOException {
        SocketChannel sc = (SocketChannel) key.channel();
        ByteBuffer buf1 = (ByteBuffer) key.attachment();
        
        Object o = invokeHandler(buf1);
        
       /* int bytesRead = sc.read(buf);
        while (bytesRead > 0) {
            byte[] r = new byte[bytesRead];
            buf.flip();
            while (buf.hasRemaining()) {
                buf.get(r);
            }
            logger.info(new String(r));
            buf.compact();
            bytesRead = sc.read(buf);
        }*/
        
        
        //"HTTP/1.1 200 OK \r\n"
        
        ByteBuffer buf = (ByteBuffer)o;
        
        while(buf.hasRemaining()){
            sc.write(buf);
        }
        buf.compact();
        
    //  这个代码结束
    /*  if (bytesRead <= 0) {
            sc.close();
        }*/
        
        sc.close();
        
    }

    public void handleWrite(SelectionKey key) throws IOException {
        ByteBuffer buf = (ByteBuffer) key.attachment();
        buf.flip();
        SocketChannel sc = (SocketChannel) key.channel();
        while (buf.hasRemaining()) {
            sc.write(buf);
        }
        buf.compact();
    }
    
    
    
    
    @Override
    protected void start_inner() {
        super.start_inner();
        Thread thread = new Thread(new Acceptor());
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    protected void stop_inner() {
        // TODO Auto-generated method stub
        super.stop_inner();
    }




    class Acceptor implements Runnable{
        
        public void run() {
            
            while (true) {

                // 如果没有key，则等待
                try {
                    if (selector.select(2000) == 0) {
                        logger.info("==========");
                        continue;
                    }

                    //这里的方法是阻塞的，请求的时候会触发想要的keytype,然后继续往下执行
                    Set<SelectionKey> selectedKeys = selector.selectedKeys();

                    Iterator<SelectionKey> iterator = selectedKeys.iterator();

                    while (iterator.hasNext()) {

                        SelectionKey key = iterator.next();
                        if (key.isAcceptable()) {
                            handleAccept(key);
                        } else if (key.isReadable()) {
                            handleRead(key);
                        } else if (key.isWritable()) {
                            handleWrite(key);
                        } else if (key.isConnectable()) {

                        }

                        iterator.remove();

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        
    }

    private int port;

    private Selector selector;

    public StandardServer(int port) {
        this.port = port;
    }

    @Override
    protected void init_inner() {
        try {
            
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

            serverSocketChannel.bind(new InetSocketAddress(this.port));

            serverSocketChannel.configureBlocking(false);

            selector = Selector.open();

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            
            createHandler();
            
        } catch (ClosedChannelException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void createHandler() {
        ByteHandler byteHandler = new ByteHandler();
        RequestHandler requestHandler = new RequestHandler();
        Http11Handler http11Handler = new Http11Handler();
        ServletHandler servletHandler = new ServletHandler();
        ResponseHandler responseHandler = new ResponseHandler();
        
        byteHandler.setNext(requestHandler);
        requestHandler.setNext(http11Handler);
        http11Handler.setNext(servletHandler);
        servletHandler.setNext(responseHandler);
        
        this.handler = byteHandler;
        
    }

    @Override
    protected Object invokeHandler(Object o) {
        return this.handler.heandle(o);
    }

}
