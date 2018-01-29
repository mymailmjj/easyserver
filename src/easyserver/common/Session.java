/**
 * 
 */
package easyserver.common;

/**
 * @author cango
 *
 */
public interface Session {
    
    public String getSessionId();

    public void setAttr(String key,String name);
    
    public String getAttr(String key);
    
}
