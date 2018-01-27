/**
 * 
 */
package easyserver.connector;

import easyserver.core.AbstractComponent;
import easyserver.server.AbstractServer;

/**
 * @author cango
 *
 */
public class AbstractConnector extends AbstractComponent implements Connector {
    
    protected AbstractServer server;

    /* (non-Javadoc)
     * @see easyserver.connector.Connector#connect()
     */
    public void connect() {
        // TODO Auto-generated method stub

    }

    public AbstractServer getServer() {
        return this.server;
    }

    public void setServer(AbstractServer server) {
        this.server = server;
    }

    @Override
    public void start() {
        super.start();
        server.start();
    }


}
