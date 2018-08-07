package com.vcg.provider.constant;

public enum MediaTypeEnum {

	//1摄影图片2 插画 3漫画 4图表 5矢量图
	PHOTO("Photography",1),ILLUS("Illustration",2),VECTOR("Vector",5);
	
	private Integer value;
	private String name;
	
	MediaTypeEnum(String name,Integer value){
		this.name = name;
		this.value = value;
	}

	public static Integer getValueByName(String name){
		if(name != null && name.trim().length()>0){
			if("Photography".equals(name)){
				return PHOTO.value;
			}else if("Illustration".equals(name)){
				return ILLUS.value;
			}else if("Vector".equals(name)){
				return VECTOR.value;
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
