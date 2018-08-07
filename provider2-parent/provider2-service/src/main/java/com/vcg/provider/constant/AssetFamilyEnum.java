package com.vcg.provider.constant;

public enum AssetFamilyEnum {
 
	EDIT("编辑",1),CRATIVE("创意",2),MIXED("编辑&创意",3),GONGGUAN("公关稿",4);
	
	private Integer value;
	private String name;
	
	AssetFamilyEnum(String name,Integer value){
		this.name = name;
		this.value = value;
	}
 
	public static String getNameByValue(Integer value){
		if(value != null){
			if(value== EDIT.value){
				return EDIT.name;
			}else if(value== CRATIVE.value){
				return CRATIVE.name;
			}else if(value== MIXED.value){
				return MIXED.name;
			}else if(value== GONGGUAN.value){
				return GONGGUAN.name;
			}
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
