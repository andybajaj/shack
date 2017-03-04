package com.gaming.shack.data.enums;

public enum MemberStatusEnum {

	PRE("P"), NEW("N"), NOTACTIVE ("NC"), ACTIVE ("A"), LOCKED ("L"), SUSPENDED ("S");
	
	private String status;
	
	private MemberStatusEnum(String status){
		this.status = status;
	}
	
	public String valueOf(){
		return this.status;
	}
	
	public static MemberStatusEnum toEnum(String statusStr){		
		
		if(statusStr == null){
			return null;
		}
		
		for(MemberStatusEnum status: MemberStatusEnum.values()){
			if(status!=null && status.valueOf().equalsIgnoreCase(statusStr)){
				return status;
			}
		}
		
		return null;
	}
}
