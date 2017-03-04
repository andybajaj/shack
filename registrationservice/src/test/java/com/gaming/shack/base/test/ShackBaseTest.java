/**

 * Ithaka CONFIDENTIAL INFORMATION

 * Copyright (c) 2015 Ithaka.  All Rights Reserved.
 * Unauthorized reproduction, transmission, or distribution of
 * this software is a violation of applicable laws.

 * Department:  Portico CM System
 *
 * File Name:   PorticoBaseTest.java 
 * Description: 

 * @author:     ybajaj
 * @version:    1.0
 * @since:      Sep 15, 2015

 */
package com.gaming.shack.base.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;





/**
 * The Class PorticoBaseTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@WebAppConfiguration
public class ShackBaseTest {

	/** The Constant logger. */
	protected static final Logger LOGGER = LogManager.getLogger(ShackBaseTest.class);
	
	
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		
	}

}
