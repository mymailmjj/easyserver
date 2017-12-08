/**
 * 
 */
package com.easyserver.servlet;

/**
 * @author mujjiang
 * 
 */
public interface Servlet {

	
	public void init(ServletConfig servletConfig) throws ServletException;

	
	public ServletConfig getServletConfig();

}
