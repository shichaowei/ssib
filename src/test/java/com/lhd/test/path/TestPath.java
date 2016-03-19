package com.lhd.test.path;

import java.util.Properties;

import org.junit.Test;

import com.fh.util.PropertiesUtil;

/** 
 * @author lihongde
 * @date 2016-2-29 下午10:08:41 
 */
public class TestPath  {

	@Test
	public void test() {
		String s = String.valueOf(Thread.currentThread().getContextClassLoader().getResource(""));
		System.out.println(s);
		String d =  this.getClass().getResource("/").getPath();
		System.out.println(d);
	}
	
	@Test
	public void testPro(){
		PropertiesUtil pu = new PropertiesUtil("system.properties");
		Properties pros = pu.getProperties();
		String sn = pros.getProperty("system_name");
		System.out.println(sn);
	}

}
