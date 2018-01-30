/**
 * 
 */
package easyserver.common;

import java.util.Set;

import easyserver.session.Session;

/**
 * @author cango
 *
 */
public interface Request {
    
    public String getReqeustUrl();
    
    public Session getSession();
    
    public Set<String> getParamaterNames();
    
    public String getParameterValue(String name);

}
