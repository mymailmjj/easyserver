/**
 * 
 */
package easyserver.handler;

import java.util.HashMap;
import java.util.Map;

import easyserver.servlet.Servlet;

/**
 * @author cango
 *
 */
public class HandlerMapping {
    
    /**
     * 保存url映射
     * 
     */
    public Map<String,Object> map = new HashMap<String, Object>();
    
    
    public void init(){
        
    }
    
    public Servlet getServlet(String url){
        Servlet servlet = (Servlet) map.get(url);
        return servlet;
    }

}
