/**
 * 
 */
package easyserver.session;

import java.util.UUID;

/**
 * @author cango
 *
 */
public class DefaultSessionIdGenerator implements SessionIdGenerator {

    /* (non-Javadoc)
     * @see easyserver.session.SessionIdGenerator#generateId()
     */
    public String generateId() {
        return UUID.randomUUID().toString();
    }

}
