/**
 * 
 */
package easyserver.servlet;

import easyserver.common.Request;
import easyserver.common.Response;

/**
 * @author cango
 *
 */
public interface Servlet {
    
    public void service(Request request,Response response);

}
