package com.vcg.provider.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SellDataByRange {
	
		@ApiModelProperty("出单时间开始yyyy-MM-dd")
		private String outbillDateStart;
		@ApiModelProperty("出单时间结束yyy-MM-dd")
		private String outbillDateEnd;
		
		public String getOutbillDateStart() {
			return outbillDateStart;
		}
		public void setOutbillDateStart(String outbillDateStart) {
			this.outbillDateStart = outbillDateStart;
		}
		public String getOutbillDateEnd() {
			return outbillDateEnd;
		}
		public void setOutbillDateEnd(String outbillDateEnd) {
			this.outbillDateEnd = outbillDateEnd;
		}
	    
		 

}
