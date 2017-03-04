package com.gaming.shack.data.enums;

/**
 * 
 * @author shahnawf
 *
 */
public enum ChannelType {
	FRONTDESK(200) ,
	MOBILEAPP(201) , 
	WEBSITE(202) , 
	KIOSK(203) ;
	
	private int channelId;
	
	/**
	 * 
	 * @param channelId
	 */
	ChannelType(int channelId) {
		this.channelId = channelId ;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getChanneId() {
		return this.channelId ;
	}
	
}
