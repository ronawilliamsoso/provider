package com.vcg.provider.util;

 
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.vcg.provider.constant.AssetFamilyEnum;
import com.vcg.util.feignClient.UtilClient;
 

 


@Component
public class MessageUtil {
	
	@Value("${token.smsToken}") 
	private String smsToken="39bbc5b2f4714aac949d9d9f7300f2763";
	
	@Autowired
	private UtilClient utilClient;
 
	
	private String  zigePassSMS = "已开通您的VCG编辑类（创意类）上传权限，请尽快登陆500px.me完成线上合同签订";
	private String  zigePassMail = "尊敬的供稿人，经审核您的作品质量符合我们的要求，现已开通您的VCG编辑类（创意类）上传权限，请尽快登陆500px.me完成线上合同签订。";
	
	
	private String getNewPortalAccountEmail(String account, String password){
		 
		return "欢迎使用视觉中国供应商服务系统，您的账号和初始密码为:"+account+"/"+password+"。请及时登录系统修改密码";
		
	}
	
	private String getZigePassSMS(Integer assetFaimly){
		String type= AssetFamilyEnum.getNameByValue(assetFaimly);
		return "已开通您的"+type+"类上传权限，请尽快登陆500px.me完成线上合同签订";
		
	}
	private String getZigePassMail(Integer assetFaimly){
		String type= AssetFamilyEnum.getNameByValue(assetFaimly);
		return "尊敬的供稿人，经审核您的作品质量符合我们的要求，现已开通您的VCG"+type+"类上传权限，请尽快登陆500px.me完成线上合同签订。";
	}
	
	private String getconfirmMonthlyReport(Integer isNative,String datesre){
		String message = "";
		String month="";
		Date date=new Date(datesre);  
		
		if(isNative==1){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月");  
			month = sdf.format(date);  
			message = "尊敬的合作伙伴，您的"+month+"销售报表已经发布，请您尽快登陆VCG内容合作管理门户（provider.vcg.com）查看和上传对应电子发票。";
		}else{
			SimpleDateFormat sdf=new SimpleDateFormat("MMM yyyy");  
			month = sdf.format(date);  
			message ="Dear partner,Your "+ month +" sales reports have been published, please as soon as possible visit VCG collaboration content management portal (provider.vcg.com) to viewand upload the corresponding invoice.";
		}
		 
		return message;
	}
	
	
	private String getBillPaidMail(String countnumber,Integer isBank,String shareTotal){
		String message = "";
  
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月");  
			//"您在VCG本月的稿费为***，已发放到您尾号是***的卡号上，请查询";
			if(isBank==1){
				message = "您在VCG本月的稿费为"+shareTotal+"，已发放到您尾号是"+ countnumber.substring(countnumber.length()-4,countnumber.length() ) +"的卡号上，请查询";
			}else{
				message = "您在VCG本月的稿费为"+shareTotal+"，已发放到您支付宝账号，请查询";
			}
			
	 
		return message;
	}
	
	private String getBillPaidSms(String countnumber,Integer isBank,String shareTotal){
		String message = "";
	 
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月");  
			//"您在VCG本月的稿费为***，已发放到您尾号是***的卡号上，请查询";
			if(isBank==1){
				message = "您在VCG本月的稿费为"+shareTotal+"，已发放到您尾号是"+ countnumber.substring(countnumber.length()-4,countnumber.length() ) +"的卡号上，请查询";
			}else{
				message = "您在VCG本月的稿费为"+shareTotal+"，已发放到您支付宝账号上，请查询";
			}
	 
		return message;
	}
	
	
	private String ontractPassSMS="您的合同已通过审核并于即日起开始生效，可登陆500px.me上传图片";
	private String  contractPassMail="您的合同已通过审核并开始生效，您可登陆500px.me上传图片，并随时查看下载记录";
	private String zigeFailSMS="抱歉，您本次在VCG申请摄影师未能通过审核，您可以查看邮件或登录500px.me查询未通过原因";
	private String zigeFailMail="尊敬的申请人，抱歉，您本次在VCG申请摄影师未能通过审核，初步感觉您的摄影及后期水平较视觉中国创意的标准略有差距。   建议您多多参考我们网站的已有类似内容，以及我们的微博以及博客的内容，了解商业图片库的特点和需求，拍摄和积累更加符合图片库需求的内容，这样才能给您带来更加良好的收益。";
	 
	
	
	//资格审核通过短信
	public void zigePassSMS(String mobile,Integer assetFaimly) throws IOException {
		String content = getZigePassSMS(assetFaimly);
		Object map =  utilClient.sendNoticeSms(mobile, content, "86", smsToken);
		System.err.println("给"+mobile+"发送了短信");
	}
	
	//资格审核通过邮件
	public void zigePassMail(String email, Integer assetFaimly) throws IOException {
		String content = getZigePassMail(assetFaimly);
		String subject = "【视觉中国】资格审核通过通知";
		Object map =  utilClient.sendNoticeMail(email, content, subject,2, smsToken);
		System.err.println("给"+email+"发送了邮件");
	}
	
	//资格审核不通过短信
	public void zigeFailSMS(String mobile) throws IOException {
		String content = zigeFailSMS;
		Object map =  utilClient.sendNoticeSms(mobile, content, "86", smsToken);
		System.err.println("给"+mobile+"发送了短信");
	}
	
	//资格审核不通过邮件
	public void zigeFailMail(String email) throws IOException {
		String content = zigeFailMail;
		String subject = "【视觉中国】资格审核不通过通知";
		Object map =  utilClient.sendNoticeMail(email, content, subject,2, smsToken);
		System.err.println("给"+email+"发送了邮件");
	}
	
	
	//合同审核通过短信
	public void hetongPassSMS(String mobile,Integer assetFaimly) throws IOException {
		String content = ontractPassSMS;
		Object map =  utilClient.sendNoticeSms(mobile, content, "86", smsToken);
		System.err.println("给"+mobile+"发送了短信");
	}
	
	//合同审核通过邮件
	public void hetongPassMail(String email, Integer assetFaimly) throws IOException {
		String content = contractPassMail;
		String subject = "【视觉中国】合同审核通过通知";
		Object map =  utilClient.sendNoticeMail(email, content, subject,2, smsToken);
		System.err.println("给"+email+"发送了邮件");
	}
	
	
	

    //开通供应商portal账号
	public void portalAccountMail(String email,String account, String password) throws IOException {
			String content = getNewPortalAccountEmail(account,password);
			String subject = "欢迎使用视觉中国供应商服务系统";
			Object map =  utilClient.sendNoticeMail(email, content, subject,1, smsToken);
			System.err.println("给"+email+"发送了邮件");
			

	}
	
	//催促确认报表
	public void reportMonthEmail(String email,Integer isNative,String date) throws IOException {
		 
		String subject ="";
		if(isNative==1){
			subject = "【视觉中国】请及时确认本月销售报表";
		}else{
			subject = "[VisualChina]Monthly Report Publihsed";
		}
		String confirmMonthlyReport = getconfirmMonthlyReport(isNative,date);
		Object map =  utilClient.sendNoticeMail(email, confirmMonthlyReport, subject,1, smsToken);
		System.err.println("给"+email+"发送了邮件");

    }
	
	
	//已付款
	public void billPaiedMail(String email,String countnumber,Integer isBank,String shareTotal) throws IOException {
		 
		String subject = "【视觉中国】已付款";
	 
		String paiedMonthly = getBillPaidMail(countnumber,isBank,shareTotal);
		Object map =  utilClient.sendNoticeMail(email, paiedMonthly, subject,1, smsToken);
		System.err.println("给"+email+"发送了邮件");

    }
	
	
	//已付款短信
	public void billPaiedMailSms(String mobile,String countnumber,Integer isBank,String shareTotal) throws IOException {
		 
 
		String content = getBillPaidSms(countnumber,isBank,shareTotal);
		Object map =  utilClient.sendNoticeSms(mobile, content, "86", smsToken);
		System.err.println("给"+mobile+"发送了短信");

    }
	
	
	
 
	
  
     
     
 
	
	
  
}
