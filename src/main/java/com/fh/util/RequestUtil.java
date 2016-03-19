package com.fh.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


public class RequestUtil {
	
	public static String getValue(){
		
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		@SuppressWarnings("unchecked")
		Map<String,Object> properties = request.getParameterMap();
		Iterator<Entry<String,Object>> entries = properties.entrySet().iterator(); 
		Map.Entry<String,Object> entry; 
		String value = "";  
		
		while (entries.hasNext()) {
			entry = (Entry<String, Object>) entries.next(); 
			value = (String) entry.getValue(); 
		}
		
		return value;
	}

}