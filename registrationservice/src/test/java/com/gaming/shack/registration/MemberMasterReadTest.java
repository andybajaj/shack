
package com.gaming.shack.registration;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.gaming.shack.base.test.ShackBaseTest;
import com.gaming.shack.core.annotation.ShackRTX;
import com.gaming.shack.data.entity.registration.Channel;
import com.gaming.shack.data.entity.registration.MemberMaster;
import com.gaming.shack.data.entity.registration.MembershipTypeDetail;
import com.gaming.shack.data.entity.registration.SiteMaster;
import com.gaming.shack.registration.dao.IMemberMasterDAO;



public class MemberMasterReadTest extends ShackBaseTest{

	@Autowired
	private IMemberMasterDAO<MemberMaster, Long> memberDAO;
	@Autowired
	private IMemberMasterDAO<MembershipTypeDetail, Long> memberDetailDAO;
	
	

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
		member.setMemberID(10039L);
		member.setNameTitle("Sz");
		member.setGivenName("Yogesh");
		member.setSurname("Bajaj");
		member.setSiteMaster(getSiteMaster());
		member.setChannel(getChannel());
		member.setDateOfBirth(new Date());
		member.setCreateBy("bajaj");
		member.setEmailaddress("andybajajus7@gmail.com");
		member.setUpdateBy("yogesh");
		member.setTCTemplateID(1L);
		member.setCardBarCode(4L);
		member.setMemberTypeID(2L);
		//member.setMemberStatus("Active");
		//member.setMembershipTypeXs(new ArrayList<MembershipTypeX>());
		/*MembershipTypeX membershipTypeX = new MembershipTypeX();
		membershipTypeX.setCreateBy("yogesh");
		membershipTypeX.setCreateDate(new java.sql.Timestamp(new Date().getTime()));
		membershipTypeX.setExpiryDate(new Date());
		MembershipTypeDetail membershipTypeDetail = memberDetailDAO.findById(1L,MembershipTypeDetail.class);
		membershipTypeX.setMembershipTypeDetail(membershipTypeDetail);*/
		
		/*member.addMembershipTypeX(membershipTypeX);
		membershipTypeDetail.setMembershipTypeXs(member.getMembershipTypeXs());*/
		
		memberDAO.add(member);
		

	}
	
	@Test
	@ShackRTX
	@Rollback(false)
	public void readBasicProfile() throws Exception {
		MemberMaster memberMaster = memberDAO.readBasicProfile(10039L);
		System.out.println(memberMaster);

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
		//sm.setSiteId(6650);
		sm.setCreateBy("Shah");
		sm.setUpdateBy("shah");
		return sm;
	}
	
	

	private Channel getChannel() {
		Channel channel = new Channel();
		channel.setChannelID(5000l);
		channel.setCreateBy("shah");
		channel.setUpdateBy("Shah");
		return channel;
	}

}
