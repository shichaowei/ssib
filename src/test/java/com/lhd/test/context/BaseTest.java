package com.lhd.test.context;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.fh.dao.DAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
		"classpath:/spring/ApplicationContext-mvc.xml", 
		"classpath:/spring/ApplicationContext.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class BaseTest extends Assert {

	protected Log logger = LogFactory.getLog(getClass());

	@Autowired
	protected DAO dao;
	@Autowired
	protected Service service;

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/** 第一页 */
	protected int page = 1;
	/** 每页显示20条 */
	protected int pageSize = 20;

	/** view structure */
	protected void print(Object obj) {
	}

	protected void printJson(Object obj) {
		ObjectMapper om = new ObjectMapper();
		try {
			om.writeValue(System.out, obj);
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
}
