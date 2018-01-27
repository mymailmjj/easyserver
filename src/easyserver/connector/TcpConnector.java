/**
 * 
 */
package easyserver.connector;

import easyserver.server.StandardServer;

/**
 * @author cango
 *
 */
public class TcpConnector extends AbstractConnector{
    
    private int port = 8081;
    
    @Override
    protected void init_inner() {
        server = new StandardServer(port);
        super.init_inner();
    }

    @Override
    public void start() {
        super.start();
        
    }
    

}
