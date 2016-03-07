package com.demo.bootstrap.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.demo.bootstrap.DemoBootApplication;
 
 
public class UserSessionInterceptor extends HandlerInterceptorAdapter {
	private static final Logger log = LoggerFactory.getLogger(DemoBootApplication.class);
	
	  @Override
	  public boolean preHandle(HttpServletRequest request,
	      HttpServletResponse response, Object handler) throws Exception {
	    try {
	    	log.info("Intercepting: " + request.getRequestURI());
	      // Do some changes to the incoming request object
	      return true;
	    } catch (Exception e) {
	    	log.info("request update failed");
	      return false;
	    }
	  }
}