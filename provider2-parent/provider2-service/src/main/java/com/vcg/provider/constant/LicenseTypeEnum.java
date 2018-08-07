package com.vcg.provider.constant;
/**
 * 授权类型 1RM 2RF 3RR
 * @author dell
 *
 */
public enum LicenseTypeEnum {
	RF("RF",1),RM("RM",2)/*,RR("RR",3)*/;
	
	private Integer value;
	private String name;
	
	LicenseTypeEnum(String name,Integer value){
		this.name = name;
		this.value = value;
	}

	public static Integer getValueByName(String name){
		if(name != null && name.trim().length()>0){
			if("RF".equals(name)){
				return RF.value;
			}else if("RM".equals(name)){
				return RM.value;
			}/*else if("RR".equals(name)){
				return RR.value;
			}*/
		}
		return null;
	}
	
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
