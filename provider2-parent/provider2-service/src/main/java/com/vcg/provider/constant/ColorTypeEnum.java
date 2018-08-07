package com.vcg.provider.constant;

public enum ColorTypeEnum {

	Color_Image("Color Image",1),BLACK_WHITE("Black&White",2);
	
	private Integer value;
	private String name;
	
	ColorTypeEnum(String name,int value){
		this.name = name;
		this.value = value;
	}
	
	public static Integer getColorTypeEnumByName(String name){
		if(name.equals(Color_Image.name)){
			return Color_Image.value;
		}else if(name.equals(BLACK_WHITE.name)){
			return BLACK_WHITE.value;
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
