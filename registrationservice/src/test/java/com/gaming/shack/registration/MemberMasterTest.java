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
package com.gaming.shack.registration;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.gaming.shack.core.annotation.ShackRTX;
import com.gaming.shack.data.entity.registration.Channel;
import com.gaming.shack.data.entity.registration.MemberMaster;
import com.gaming.shack.data.entity.registration.SiteMaster;
import com.gaming.shack.registration.dao.IChannelDAO;
import com.gaming.shack.registration.dao.IMemberMasterDAO;
import com.gaming.shack.registration.dao.ISiteMasterDAO;

/**
 * The test class for the member master
 * functionality
 * @author shahnawf
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/shack-app-config.xml" })
@WebAppConfiguration
public class MemberMasterTest {

	@Autowired
	private IMemberMasterDAO<MemberMaster, Long> memberDAO;
	
	@Autowired
	private ISiteMasterDAO<SiteMaster, Long> siteMasterDAO;
	
	@Autowired
	private IChannelDAO<Channel, Long> channelDAO;
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {

	}

	@Test
	@ShackRTX
	@Rollback(false)
	public void testAddMemberDAO() throws Exception {
		MemberMaster member = new MemberMaster();
		member.setMemberID(1007l);
		member.setNameTitle("Sz");
		member.setGivenName("Shahnawaz");
		member.setSurname("Fnu");
		
		//member.setSiteMaster(getSiteMaster());
		
		SiteMaster siteMaster = siteMasterDAO.findById(11l) ;
		member.setSiteMaster(siteMaster);
		
		//member.setChannel(getChannel());
		
		Channel channel = channelDAO.findById(18l) ; 
		
		member.setChannel(channel);
		
		member.setDateOfBirth(new Date());
		member.setCreateBy("Shah");
		member.setEmailaddress("test7@yahoo.com");
		member.setUpdateBy("Shah");
		memberDAO.add(member);
		// ShackThreadLocal.getEntityManager().getTransaction().commit();

	}

	@Test
	@ShackRTX
	public void findMaterMemberByIdDAO() throws Exception {
		MemberMaster memberMaster = memberDAO.findById(3l);
		System.out.println(memberMaster);

	}

	private SiteMaster getSiteMaster() {
		SiteMaster sm = new SiteMaster();
		sm.setAddressLine1("address 1 ");
		sm.setAddressLine2("address 2");
		sm.setCityName("LAKHi");
		sm.setStateProv("NJ");
		sm.setCountry("US");
		sm.setPostalCode("07034");
		sm.setCreateBy("Shah");
		sm.setUpdateBy("shah");
		return sm;
	}

	private Channel getChannel() {
		Channel channel = new Channel();
		channel.setChannelID(10095l);
		channel.setCreateBy("shah");
		channel.setUpdateBy("Shah");
		return channel;
	}

}
