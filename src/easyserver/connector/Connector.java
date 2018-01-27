/**
 * 
 */
package easyserver.connector;

import easyserver.server.AbstractServer;

/**
 * @author cango
 *
 */
public interface Connector {
    
    public void connect();
    
    public AbstractServer getServer();

}
