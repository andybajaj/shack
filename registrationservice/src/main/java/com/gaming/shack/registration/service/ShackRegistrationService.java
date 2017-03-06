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
import com.gaming.shack.data.entity.registration.OptIn;
import com.gaming.shack.data.entity.registration.SiteMaster;
import com.gaming.shack.data.enums.OperationType;
import com.gaming.shack.data.model.MemberDTO;
import com.gaming.shack.data.model.MemberProfileDTO;
import com.gaming.shack.data.model.MemberSuccess;
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
	private RegistrationHelper registrationHelper;

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
			throw new ShackServiceException("101", "exception in find all users", e);
		}
	}

	@Override
	@ShackRTX
	public MemberSuccess addMemberMaster(MemberDTO member) throws ShackValidationException, ShackServiceException {
		try {

			/**
			 * validate member profile
			 */

			validateMemberProfile(member);

			MemberMaster memberMaster = createMemberEntity(member);

			memberDAO.add(memberMaster);

			return new MemberSuccess(memberMaster.getMmid());

		} catch (ShackValidationException sve) {
			LOGGER.error("Validation error occured in addMemberMaster", sve);
			throw sve;
		} catch (Exception e) {
			LOGGER.error("Error occured in addMemberMaster", e);
			throw new ShackServiceException(ShackResourceConstants.ERROR_CODE_ADD_MEMBER,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_MSG, e);
		}
	}

	@Override
	@ShackRTX
	public MemberSuccess updateMemberMaster(MemberDTO member) throws ShackValidationException, ShackServiceException {
		try {

			validateMemberProfile(member);

			MemberMaster existingEntity = validateMember(member.getMemberProfile());
			
			MemberMaster newEntity = createMemberEntity(member);
			
			updateMember(existingEntity, member, newEntity);
			
			return new MemberSuccess(newEntity.getMmid());

		} catch (ShackValidationException sve) {
			LOGGER.error("validation error occured in updateMemberMaster", sve);
			throw sve;
		} catch (Exception e) {
			LOGGER.error("Error occured in updateMemberMaster", e);
			throw new ShackServiceException(ShackResourceConstants.ERROR_CODE_ADD_MEMBER,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBER_MSG, e);
		}
	}

	/**
	 * 
	 * @param member
	 * @return
	 * @throws ShackValidationException
	 * @throws ShackDAOException
	 * @throws ShackServiceException
	 */
	public MemberMaster createMemberEntity(MemberDTO member)
			throws ShackValidationException, ShackDAOException, ShackServiceException {
		/**
		 * First validate the channels and site before proceeding
		 */
		SiteMaster siteMaster = siteMasterDAO.findById(member.getMemberProfile().getPreferredSite());
		Channel channel = channelDAO.findChannelById(member.getMemberProfile().getChannelId());

		validationhelper.validateSiteAndChannel(siteMaster, channel);

		MemberMaster memberMaster = registrationHelper.createMemberMaster(member);

		memberMaster.setSiteMaster(siteMaster);
		memberMaster.setChannel(channel);

		return memberMaster;
	}

	/**
	 * 
	 * @param member
	 * @throws ShackValidationException
	 * @throws ShackDAOException
	 */
	private void validateMemberProfile(MemberDTO member) throws ShackValidationException, ShackDAOException {

		/**
		 * validate the member profile
		 */
		validationhelper.validateMemberProfile(member);

		/**
		 * validate the parent member profile
		 */
		validateParentMember(member.getMemberProfile());
	}

	/**
	 * 
	 * @param memberProfile
	 * @throws ShackValidationException
	 * @throws ShackDAOException
	 */
	private void validateParentMember(MemberProfileDTO memberProfile)
			throws ShackValidationException, ShackDAOException {
		if (memberProfile.getParentMemberId() != null && memberProfile.getParentMemberId() > 0) {
			MemberMaster parentMember = memberDAO.findMemberById(memberProfile.getParentMemberId());
			if (parentMember == null) {
				throw new ShackValidationException(ShackResourceConstants.ERROR_CODE_INPUT_VALIDATION,
						ShackResourceConstants.ERROR_CODE_ADD_PARENT_MEMBEPER_NOT_IN_SYSTEM);
			}
		}
	}

	/**
	 * 
	 * @param memberProfile
	 * @throws ShackValidationException
	 * @throws ShackDAOException
	 */
	private MemberMaster validateMember(MemberProfileDTO memberProfile)
			throws ShackValidationException, ShackDAOException {

		if (memberProfile.getMemberId() == null || memberProfile.getMemberId() <= 0) {

			throw new ShackValidationException(ShackResourceConstants.ERROR_CODE_INPUT_VALIDATION,
					ShackResourceConstants.ERROR_CODE_UPDATE_MEMBERID);
		}

		MemberMaster selectedMember = memberDAO.findMemberById(memberProfile.getMemberId());

		if (selectedMember == null) {
			throw new ShackValidationException(ShackResourceConstants.ERROR_CODE_INPUT_VALIDATION,
					ShackResourceConstants.ERROR_CODE_ADD_MEMBEPER_NOT_IN_SYSTEM);
		}

		return selectedMember;
	}
	
	/**
	 * 
	 * @param memberMaster
	 * @param member
	 */
	private void updateMember(MemberMaster existingEntity , MemberDTO member , MemberMaster newEntity) throws ShackDAOException {
		
		newEntity.setMmid(existingEntity.getMmid());
		
		/**
		 * 1 - if option selected tag is not present, meaning no change
		 * to the existing data. No need to perform any DB operation for the option selected
		 */
		
		if (member.getMemberDetails() !=null && member.getMemberDetails().getOptInSelected() !=null) {
			/**
			 * 2 - If the option selected tag is present. Need to update the existing data.
			 */
												
			LOGGER.info("option seletced tag is present");
			
			if (member.getMemberDetails().getOptInSelected().isEmpty()) {
				memberDAO.deleteOptinsByMMId(newEntity.getMmid()) ;
			} else {
				List<OptIn> existingOptinsList = existingEntity.getOptIns() ;
				
				if (existingOptinsList !=null && !existingOptinsList.isEmpty()) {
					
					if (newEntity.getOptIns().equals(existingEntity.getOptIns())) {
						
						newEntity.setOptIns(null);
					} else {
						//List<OptIn> mergedOptinsList = getMergedOptinsList(newEntity.getOptIns() , existingEntity.getOptIns());
					}
				}
			}
		}
		
		memberDAO.update(newEntity) ;
	}
	
	/**
	 * 
	 * @param newOptIns
	 * @param existingOptIns2
	 * @return
	 */
	/*private List<OptIn> getMergedOptinsList(List<OptIn> newOptIns, List<OptIn> existingOptIns) {
		List<OptIn>
		for (OptIn existingOptin : existingOptIns) {
			
		}
	}*/
}
