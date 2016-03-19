package com.fh.util;

import java.util.Properties;

import org.apache.log4j.Logger;

public class PropertiesUtil {
    protected final Logger log = Logger.getLogger(getClass());

	private String fileName;

	public PropertiesUtil(String fileName) {
		this.fileName = fileName;
	}

	public Properties getProperties() {
		Properties p = new Properties();
		try {
			p.load(this.getClass().getClassLoader().getResourceAsStream(fileName));
		} catch (Exception e) {
			log.error("there is a mistake when load the properties file, fileName : " +
											fileName,e);
		}
		return p;
	}
}
