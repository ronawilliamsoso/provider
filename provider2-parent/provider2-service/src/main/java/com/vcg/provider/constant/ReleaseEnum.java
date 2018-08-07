package com.vcg.provider.constant;

public enum  ReleaseEnum {

	Y("Y",0),
	N("N",1);
	
	private String name;
	private int value;
	
	ReleaseEnum(String name,int value){
		this.name = name;
		this.value = value;
	}
	
	public static Integer getReleaseEnumByName(String name){
		if(Y.name.equals(name)){
			return Y.value;
		}else if(N.name.equals(name)){
			return N.value;
		}
		return null;
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}


}
