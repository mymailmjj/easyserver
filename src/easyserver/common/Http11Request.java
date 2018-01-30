/**
 * 
 */
package easyserver.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import easyserver.session.Session;

/**
 * @author cango
 *
 */
public class Http11Request extends AbstractRequest {
    
    private Http11RequestLine http11RequestLine;
    
    private Map<String,String> attribute = new HashMap<String,String>();

    public String getReqeustUrl() {
        return http11RequestLine.getRequestUrl();
    }
    
    /**
     * 解析的header头消息
     * @param key
     * @param name
     */
    public void putAttri(String key,String name){
        attribute.put(key, name);
    }
    
    private Session session;

    public Session getSession() {
        return session;
    }


    public void setSession(Session session) {
        this.session = session;
    }

    public Set<String> getParamaterNames() {
        return attribute.keySet();
    }


    public String getParameterValue(String name) {
        return attribute.get(name);
    }

}
