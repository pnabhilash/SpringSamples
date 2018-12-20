package com.pabs.app.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
	    logger.info("****************Request  --> {} , request uri {}", request,request.getRequestURI());
		return request;
	}
    /**
     * 
     * Decides when the filter to be executed - Before the execution of request or after or both.
     */
	@Override
	public String filterType() {
		return "pre";
	}
	
	/**
	 * if you have multiple filters configured -such Zuul Logging / Zuul Security - you can set a priority order between them.
	 * 1,2,3 etc for ex.
	 * 
	 * 
	 */

	@Override
	public int filterOrder() {
		return 1;
	}

}
