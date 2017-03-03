/*
 * 
 */
package com.gaming.shack.registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaming.shack.core.annotation.ShackRTX;
import com.gaming.shack.core.exception.ShackDAOException;
import com.gaming.shack.core.exception.ShackServiceException;
import com.gaming.shack.data.entity.registration.Channel;
import com.gaming.shack.data.entity.registration.MemberMaster;
import com.gaming.shack.data.entity.registration.SiteMaster;
import com.gaming.shack.data.model.MemberProfileDTO;
import com.gaming.shack.data.model.UserDTO;
import com.gaming.shack.registration.dao.IChannelDAO;
import com.gaming.shack.registration.dao.IMemberMasterDAO;
import com.gaming.shack.registration.dao.IShackResgistrationDao;
import com.gaming.shack.registration.dao.ISiteMasterDAO;
import com.gaming.shack.registration.util.RegistrationHelper;
// TODO: Auto-generated Javadoc

/**
 * The Class ShackRegistrationService.
 */
@Service
public class ShackRegistrationService implements IShackRegistrationService {
	
	/** The shack resgistration dao. */
	@Autowired
	private IShackResgistrationDao shackResgistrationDao;
	
	@Autowired
	private IMemberMasterDAO<MemberMaster, Long> memberDAO;
	
	@Autowired
	private ISiteMasterDAO<SiteMaster, Long> siteMasterDAO;
	
	@Autowired
	private IChannelDAO<Channel, Long> channelDAO;
	
	@Autowired
	RegistrationHelper registrationhelper ;

	/* (non-Javadoc)
	 * @see com.gaming.shack.registration.service.IShackRegistrationService#findAllUsers()
	 */
	@Override
	public List<UserDTO> findAllUsers() throws ShackServiceException {
		// TODO Auto-generated method stub
		try {
			return shackResgistrationDao.findAllUser();
		} catch (ShackDAOException e) {
			throw new ShackServiceException("101","exception in find all users");
		}
	}


	@Override
	@ShackRTX
	public MemberProfileDTO addMemberMaster(MemberProfileDTO memberProfile) throws ShackServiceException {
		/**
		 * The advanced validations will be added here
		 */
		SiteMaster siteMaster = siteMasterDAO.findById(memberProfile.getPreferredSite()) ;
		
		Channel channel = channelDAO.findById(memberProfile.getChannelId()) ;
		
		/**
		 * Validate the channels and site before proceeding
		 */
		MemberMaster memberMaster = registrationhelper.createMemberMaster(memberProfile) ;
		memberMaster.setSiteMaster(siteMaster);		
		memberMaster.setChannel(channel);
		
		memberDAO.add(memberMaster);
		
		return memberProfile ;
	}

}
