package com.filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class SetCharacterEncodingFilte
 */
@WebFilter("/SetCharacterEncodingFilte")
public class SetCharacterEncodingFilte implements Filter {
	protected FilterConfig filterConfig;
	protected String  encodingName;
	protected boolean enable;

    /**
     * Default constructor. 
     */
    public SetCharacterEncodingFilte() {
        // TODO Auto-generated constructor stub
    	this.encodingName = "gb2312";
    	this.enable = false;
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		if(this.enable)
			request.setCharacterEncoding(this.encodingName);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = fConfig;
		this.encodingName = filterConfig.getInitParameter("encoding");
	}
	
}


