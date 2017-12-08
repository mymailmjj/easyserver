package com.easyserver.servlet;

import java.util.Locale;

public interface ServletResponse {

	public String getCharacterEncoding();

	public String getContentType();

	public void setCharacterEncoding(String charset);

	public void setContentLength(int len);

	public void setContentType(String type);

	public void setBufferSize(int size);

	public int getBufferSize();

	public void reset();

	public void setLocale(Locale loc);

	public Locale getLocale();

}
