package com.vcg.provider.constant;

/**
 * 1摄影图片2 插画 3漫画 4图表 5矢量图
 * @author dell
 *
 */
public enum GraphicalStyleEnum {
	
	Photography(1), illustration(2),Cartoon(3), Vetorgram(5);
	
	private int value;
	
	GraphicalStyleEnum(int value){
		this.value=value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}
