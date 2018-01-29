/**
 * 
 */
package easyserver.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cango
 *
 */
public class DefaultSession implements Session {
    
    private String id;
    
    private Map<String,String> attriValues = new HashMap<String,String>();

    public void setAttr(String key, String value) {
        attriValues.put(key, value);
        
    }

    public String getAttr(String key) {
       return attriValues.get(key);
    }

    public String getSessionId() {
        return id;
    }

}
