package com.vcg.common;
public class Status {
	
	/*合同状态*/
	/**未生效合同*/
	public static final int CONTRACT_STATUS_INVALID=0;
	/**生效合同*/
	public static final int CONTRACT_STATUS_VALID=1;
	
	public static final int ERROR=201;
	
	/*合同类型*/
	/**标准合同*/
	public static final int CONTRACT_TYPE_BIAOZHUN=1;
	/**买断合同*/
	public static final int CONTRACT_TYPE_MAIDUAN=2;
	/**解约合同*/
	public static final int CONTRACT_TYPE_JIEYUE=3;
	/**外购合同*/
	public static final int CONTRACT_TYPE_WAIGOU=4;
	/**解约合同*/
	public static final int CONTRACT_TYPE_XUYUE=5;
	
	/*合同审核状态*/
	/**合同未上传*/
	public static final int AUDITING_STATUS_NOUPLOAD=1;
	/**合同已上传*/
	public static final int AUDITING_STATUS_UPLOADED=2;
	/**合同被驳回*/
	public static final int AUDITING_STATUS_REJECT=3;
	/**合同已重新上传*/
	public static final int AUDITING_STATUS_REUPLOAD=4;
	/**合同审核通过*/
	public static final int AUDITING_STATUS_PASS=5;
	
	/*货币类型*/
	/**货币类型为CNY*/
	public static final int CURRENCY_CNY=1;
	/**货币类型为USD*/
	public static final int CURRENCY_USD=2;
	/**货币类型为EUR*/
	public static final int CURRENCY_EUR=3;
	/**货币类型为GBP*/
	public static final int CURRENCY_GBP=4;
	
	/*供应商类型*/
	/**机构供应商*/
	public static final int PROVIDER_TYPE_ORGANIZATION=1;
	/**个人供应商*/
	public static final int PROVIDER_TYPE_PERSONAL=2;
	
	/*资源类型（媒资类型）*/
	/**编辑类*/
	public static final int ASSET_FAMILY_EDIT=1;
	/**创意类*/
	public static final int ASSET_FAMILY_CREATIVE=2;
	/**编辑类&创意类*/
	public static final int ASSET_FAMILY_MIXED=3;
	
	/*媒资分类*/
	/**图片*/
	public static final int ASSET_TYPE_PICTURE=1;
	/**视频*/
	public static final int ASSET_TYPE_VIDEO=2;
	/**音频*/
	public static final int ASSET_TYPE_AUDIO=3;
	
	
	
	/*从业类型*/
	/**媒体*/
	public static final int JOB_TYPE_MEDIA=1;
	/**非媒体*/
	public static final int JOB_TYPE_NOTMEDIA=2;
	
	/*供稿人状态*/
	/**资料未审核*/
	public static final int PROVIDER_STATUS_NOAUDITING=1;
	/**资料审核通过，合同待签状态*/
	public static final int PROVIDER_STATUS_NOCONTRACT=2;
	/**审核通过*/
	public static final int PROVIDER_STATUS_PASS=3;
	/**资料审核不通过*/
	public static final int PROVIDER_STATUS_NOPASS=4;
	/**账号已冻结*/
	public static final int PROVIDER_STATUS_FREEZE=5;
	/**账号已关闭*/
	public static final int PROVIDER_STATUS_CLOSED=4;
 
	
	/*国内外*/
	/**国内供应商*/
	public static final int IS_NATIVE_YES=1;
	/**国外供应商*/
	public static final int IS_NATIVE_NO=2;
	
	/*品牌状态*/
	/**品牌处于开通状态*/
	public static final int COLLECTION_STATUS_OPEN=1;
	/**品牌处于关闭状态*/
	public static final int COLLECTION_STATUS_CLOSE=0;
	
	/*是否删除*/
	/**记录处于被删除标记状态*/
	public static final int IS_DELETE_YES = 0;
	/**记录处于有效正常状态*/
	public static final int IS_DELETE_NO = 1;
}
