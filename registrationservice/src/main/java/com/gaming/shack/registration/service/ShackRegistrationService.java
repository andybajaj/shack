/*
 * 
 */
package com.gaming.shack.registration.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaming.shack.core.annotation.ShackRTX;
import com.gaming.shack.core.constants.ShackResourceConstants;
import com.gaming.shack.core.exception.ShackDAOException;
import com.gaming.shack.core.exception.ShackServiceException;
import com.gaming.shack.core.exception.ShackValidationException;
import com.gaming.shack.data.entity.registration.Channel;
import com.gaming.shack.data.entity.registration.MemberMaster;
import com.gaming.shack.data.entity.registration.MembershipTypeX;
import com.gaming.shack.data.entity.registration.SiteMaster;
import com.gaming.shack.data.enums.MemberType;
import com.gaming.shack.data.model.BasicMemberProfileDTO;
import com.gaming.shack.data.model.MemberDTO;
import com.gaming.shack.data.model.MemberProfileDTO;
import com.gaming.shack.data.model.UserDTO;
import com.gaming.shack.registration.dao.IChannelDAO;
import com.gaming.shack.registration.dao.IMemberMasterDAO;
import com.gaming.shack.registration.dao.IShackResgistrationDao;
import com.gaming.shack.registration.dao.ISiteMasterDAO;
import com.gaming.shack.registration.util.RegistrationHelper;
import com.gaming.shack.registration.util.RegistrationValidationHelper;

/**
 * The Class ShackRegistrationService.
 */
@Service
public class ShackRegistrationService implements IShackRegistrationService {

	private static final Logger LOGGER = LogManager.getLogger(ShackRegistrationService.class);

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
	private RegistrationValidationHelper validationhelper;

	@Autowired
	RegistrationHelper registrationHelper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gaming.shack.registration.service.IShackRegistrationService#
	 * findAllUsers()
	 */
	@Override
	public List<UserDTO> findAllUsers() throws ShackServiceException {
		try {
			return shackResgistrationDao.findAllUser();
		} catch (ShackDAOException e) {
			throw new ShackServiceException("101", "exception in find all users");
		}
	}

	@Override
	@ShackRTX
	public MemberDTO addMemberMaster(MemberDTO member) throws ShackValidationException, ShackServiceException {
		try {
			/**
			 * The advanced validations will be added here
			 */
			validationhelper.validateMemberProfile(member);

			SiteMaster siteMaster = siteMasterDAO.findById(member.getMemberProfile().getPreferredSite());
			Channel channel = channelDAO.findChannelById(member.getMemberProfile().getChannelId());

			validationhelper.validateSiteAndChannel(siteMaster, channel);
			validateParentMember(member.getMemberProfile());
			
			/**
			 * Validate the channels and site before proceeding
			 */
			MemberMaster memberMaster = registrationHelper.createMemberMaster(member);

			memberMaster.setSiteMaster(siteMaster);
			memberMaster.setChannel(channel);

			memberDAO.add(memberMaster);

			return member;

		} catch (ShackValidationException sve) {
			LOGGER.error("Validation error occured in addMemberMaster", sve);
			throw sve;
		} catch (ShackServiceException sse) {
			LOGGER.error("Error occured in addMemberMaster", sse);
		} catch (Exception e) {
			LOGGER.error("Error occured in addMemberMaster", e);
			throw new ShackServiceException(ShackResourceConstants.ERROR_CODE_ADD_MEMBER,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_MSG, e);
		}

		return null;
	}
	
	/**
	 * 
	 * @param memberProfile
	 * @throws ShackValidationException
	 * @throws ShackDAOException
	 */
	private void validateParentMember(MemberProfileDTO memberProfile) throws ShackValidationException , ShackDAOException {		
		if(memberProfile.getParentMemberId() !=null && memberProfile.getParentMemberId() > 0) {
			MemberMaster parentMember = memberDAO.findMemberById(memberProfile.getParentMemberId()) ;
			if(parentMember == null) {
				throw new ShackValidationException(ShackResourceConstants.ERROR_CODE_INPUT_VALIDATION,
						ShackResourceConstants.ERROR_CODE_ADD_PARENT_MEMBEPER_NOT_IN_SYSTEM);
			}
		}		
	}

	@Override
	@ShackRTX
	public BasicMemberProfileDTO readMemberBasicProfile(Long memberId) throws ShackServiceException {
		
		try {
			MemberMaster memberMaster=memberDAO.readBasicProfile(memberId);
			BasicMemberProfileDTO memberProfileDTO = new BasicMemberProfileDTO();
			memberProfileDTO.setMemberId(memberId);
			memberProfileDTO.setFirstName(memberMaster.getGivenName());
			memberProfileDTO.setLastName(memberMaster.getSurname());
			memberProfileDTO.setMiddleName(memberMaster.getMiddleName());
			memberProfileDTO.setNameTitle(memberMaster.getNameTitle());
			memberProfileDTO.setEmailId(memberMaster.getEmailaddress());
			memberProfileDTO.setPhoneNumber(memberMaster.getTelephoneCountryCode()+memberMaster.getTelephoneNumber());
			memberProfileDTO.setLeftHanded(memberMaster.getIsLeft()==0?Boolean.FALSE:Boolean.TRUE);
			memberProfileDTO.setPreferredSite(memberMaster.getSiteMaster().getCityName()+","+memberMaster.getSiteMaster().getStateProv());
			memberProfileDTO.setMemberType(MemberType.toEnum(memberMaster.getMemberTypeID().intValue()).name());
			memberProfileDTO.setMemberSince(memberMaster.getCreateDate());
			memberProfileDTO.setParentMemberId(memberMaster.getParentMemberID());
			for(MembershipTypeX membershipTypeX :memberMaster.getMembershipTypeXs()){
				memberProfileDTO.setMembershipType(membershipTypeX.getMembershipTypeDetail().getMembershipDescription());
				memberProfileDTO.setMembershipExpiryDate(membershipTypeX.getExpiryDate());
			}
			return memberProfileDTO;
		} catch (ShackDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	

}
