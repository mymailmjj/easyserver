package easyserver.startup;

import java.util.concurrent.CountDownLatch;

import easyserver.connector.TcpConnector;

public class ServerStarter {
    
    public static void main(String[] args) {
        
        
        CountDownLatch countDownLatch = new CountDownLatch(1);
        
        TcpConnector tcpConnector = new TcpConnector();
        
        tcpConnector.start();
        
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

}
