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
			System.out.println("inside null");
			return null;
		}
		
		for(MemberStatusEnum status: MemberStatusEnum.values()){
			System.out.println("status"+status);
			System.out.println("statusStr"+statusStr);
			if(status!=null && status.valueOf().equalsIgnoreCase(statusStr)){
			
				System.out.println("statusStr"+statusStr);
				return status;
			}
		}
		
		return null;
	}
}
