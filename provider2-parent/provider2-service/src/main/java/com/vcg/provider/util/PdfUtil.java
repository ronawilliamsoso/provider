package com.vcg.provider.util;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.kinggrid.pdf.KGPdfHummer;
import com.kinggrid.pdf.executes.PdfSignature4KG;
import com.vcg.oss.util.ProviderOSSClientUtil;
import com.vcg.provider.smallService.HtmlToPdfInterceptor;


@Component
public class PdfUtil {
	
	/*wkhtmltopdf在系统中的路径*/
	@Value("${custom.htmlExeUrl}")
	private String htmlExeUrl;
	
	/*pdf生成路径*/
	@Value("${custom.pdfout}")
	private String pdfout;
	
	
	/*pdf生成路径*/
	@Value("${custom.sigout}")
	private String sigout;
	
	@Value("${custom.signaturepfx}")
	private String signaturepfx;
	

	@Value("${custom.signaturetemp}")
	private String signaturetemp;
	
	
	@Value("${custom.signatureunitrustkey}")
	private String signatureunitrustkey;
	
	@Value("${oss.isInternal}")
	private Integer isInternal;
	
	@Autowired
	private ProviderOSSClientUtil providerOSSClientUtil;
	
	
 


 

	/** 
     * html转pdf 
     * @param srcPath html路径，可以是硬盘上的路径，也可以是网络路径 
     * @param destPath pdf保存路径 
     * @return 转换成功返回true 
     */  
    public boolean htmlToPdf(String srcPath, String destPath){  
        File file = new File(destPath);  
        File parent = file.getParentFile();  
        /*如果pdf保存路径不存在，则创建路径*/  
        if(!parent.exists()){  
            parent.mkdirs();  
        }  
          
        StringBuilder cmd = new StringBuilder();  
        cmd.append(this.htmlExeUrl);  
        cmd.append(" ");  
        cmd.append(srcPath);  
        cmd.append(" ");  
        cmd.append(destPath);  
          
        boolean result = true;  
        try{  
            Process proc = Runtime.getRuntime().exec(cmd.toString());  
            HtmlToPdfInterceptor error = new HtmlToPdfInterceptor(proc.getErrorStream());  
            HtmlToPdfInterceptor output = new HtmlToPdfInterceptor(proc.getInputStream());  
            error.start();  
            output.start();  
            proc.waitFor();  
        }catch(Exception e){  
            result = false;  
            e.printStackTrace();  
        }  
          
        return result;  
    }  
    
	/** 
     * pdf 生成PDF,数字签名,然后上传oss
     * @param 数字签名文件地址
     * @param pdf保存路径 
     * @return  
     */ 
	public String createAndSendPdfToOss( String htmlUrl) throws FileNotFoundException{
		
		//获取正确的名字
		String pdfName="";
		File file =null;
		String returnstr ="";
		try {
			//获取正确的名字
			
			String randomstring=UUIDUtil.generateUUID().substring(22);
			SimpleDateFormat sdf =   new SimpleDateFormat( "yyyyMMddHHmmss" );
			String extention = "pdf";
		    String timestemp = sdf.format(new Date());
		    pdfName=timestemp+"-"+randomstring+"."+extention;
			
			 
			//生成pdf文件到特定的目录,文件名为timestemp.pdf
			this.htmlToPdf(htmlUrl, this.getPdfOut() + pdfName);
			
			this.iSignature( pdfName);
 
			file = new File( this.getSigout() + pdfName);   
			 long fr= file.length();
			 if(fr==0){
				 return returnstr; 
			 }
		     InputStream inputStream = new FileInputStream(file); 

		     //上传oss
		     String imgObjectId = "provider/"+pdfName;
		     ProviderOSSClientUtil.putProviderObject(isInternal, imgObjectId, inputStream);
		     return   imgObjectId ;
		     
		} catch (Exception e) {
			e.printStackTrace();
			return returnstr;
		}finally {
			
 
//			//删除打了时间戳文件的pdf
			file = new File( this.getSigout() + pdfName);  
		    if (file.isFile() && file.exists()) {  
		        file.delete();  
		    } 
		    //删除生成的pdf文件
		    file = new File( this.getPdfOut() + pdfName);  
		    if (file.isFile() && file.exists()) {  
		        file.delete();  
		    }  
		}
 
	}
    
    
	/** 
     * 给pdf数字签名
     * @param pdfName 目标文件地址
     * @return  
     */ 
	public   void iSignature(String pdfName) {
	KGPdfHummer hummer = null;
	FileInputStream cert = null;
	FileOutputStream  fileOutputStream = null;
	try {
		//加载数字证书（pfx文件）
		cert = new FileInputStream(this.getSignaturepfx());
		//设置输出路径
		fileOutputStream = new FileOutputStream(this.getSigout()+pdfName);
		File tmpDic = new File(this.getSignaturetemp());
		//设置需要签名的PDF文件路径
		String srcFilePathString =  this.getPdfOut()+pdfName;
		//初始化签名类
		hummer = KGPdfHummer.createSignature(srcFilePathString, null, true, fileOutputStream,tmpDic,true);
		//加载数字证书密码
		hummer.setCertificate(cert, "123456", "123456");
		//加载时间戳服务地址、用户名、密码
		
		//这条语句不能走配置文件,奇怪啊!
//		hummer.setTSAClient(this.getSignatureserver(), this.getSignatureservername(),this.getSignatureserverpsd());
		hummer.setTSAClient("http://test1.tsa.cn/tsa", "tsademo", "tsademo");
		//加载电子图章 *.key文件  ，正式版本的电子签章软件需设置为1 
		PdfSignature4KG pdfSignature4KG = new PdfSignature4KG(this.getSignatureunitrustkey(),0,"123456");
		//获取总页数
		int num=hummer.getNumberOfPages();
		//设置签名所在页数（设置签名在最后一页）
		pdfSignature4KG.setPagen(num);
		//设置签名 0表示所有页
		//pdfSignature4KG.setPagen(0);
		//设置签章的固定位置
		pdfSignature4KG.setXY(200,200);
		//执行签名方法
		hummer.setPdfSignature(pdfSignature4KG);	
		hummer.doSignature();
	} catch (Exception e) {
		e.printStackTrace();
	}  finally {
		 
		close(cert);
		close(fileOutputStream);
		if(hummer != null) hummer.close();
	}
	}
	
	/** 
     * 供应商系统的生成文件名字 
     * @param originalFilename 原文件名
     * @param fileType  1:标准合同pdf 2:买断合同PDF 3:解约合同PDF 4:外购合同pdf 5:续约合同PDF 6:身份证图 7:营业执照图 8:税务登记图 9:其他
     * @return  文件地址
     */
	public   String createOssFilePath(String originalFilename,Integer fileType) {
		//
		String fileName = createOssFileName(originalFilename,fileType);
	   String imgObjectId="provider/"+fileName;
	   return imgObjectId;
	    
	}
	
	/** 
     * 供应商系统的生成文件名字 
     * @param originalFilename 原文件名
     * @param  
     * @return  文件地址
     */
	public   String createOssFilePath(String originalFilename,Integer fileType,Integer providerId) {
		//
		String fileName = createOssFileName(originalFilename,fileType);
	   String imgObjectId="provider/"+providerId +"/"+ fileName;
	   return imgObjectId;
	    
	}
	
	public   String create176OssFilePath(String originalFilename,Integer fileType,Integer providerId) {
		//
		String fileName = createOssFileName(originalFilename,16);
	   String imgObjectId="provider/all176/"+providerId + fileName;
	   return imgObjectId;
	    
	}
	
	/** 
     * 供应商系统的生成文件名字 
     * @param originalFilename 原文件名
     * @param fileType  1:标准合同pdf 2:买断合同PDF 3:解约合同PDF 4:外购合同pdf 5:续约合同PDF 6:身份证图 7:营业执照图 8:税务登记图 9:其他
     * @return  文件地址
     */
	public   String createOssFileName(String originalFilename,Integer fileType) {
		//
		
		String randomstring=UUIDUtil.generateUUID().substring(22);
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyyMMddHHmmss" );
		String extention = originalFilename.substring(originalFilename.indexOf('.'));
		if(fileType==14||fileType==15||fileType==18||fileType==16){//创意类上传,图片扩展名统一为 .jpg
			extention=".jpg";
		}
	    String timestemp = sdf.format(new Date());
	    String mark="";
	     //1:标准合同pdf 2:买断合同PDF 3:解约合同PDF 4:外购合同pdf 5:续约合同PDF 6:身份证图 7:营业执照图 8:税务登记图 9:发票图 10:其他  16:创意类缩略图

	    if(fileType==1){
	    	mark="biaozhun";
	    }else if(fileType==2){
	    	mark="maiduan";
	    }else if(fileType==3){
	    	mark="jieyue";
	    }else if(fileType==4){
	    	mark="waigou";
	    }else if(fileType==5){
	    	mark="xuyue";
	    }else if(fileType==6){
	    	mark="id";
	    }else if(fileType==7){
	    	mark="license";
	    }else if(fileType==8){
	    	mark="tax";
	    }else if(fileType==9){
	    	mark="report";
	    }else if(fileType==10){
	    	mark="receipt";
	    }else if(fileType==11){
	    	mark="others";
	    }else if(fileType==12){
	    	mark="meta";
	    }else if(fileType==13){
	    	mark="release";
	    }else if(fileType==14){
	    	mark="creativePic";
	    }else if(fileType==99){
	    	mark="preview";
	    }else if(fileType==15){
	    	mark="illustration";
	    }else if(fileType==16){
	    	mark="/creativePic/176";
	    }else if(fileType==18){
	    	mark="drawing";
	    } 
	   String imgObjectId=mark+"/"+timestemp+"-"+randomstring+extention;
	   return imgObjectId;
	    
	}
	
 
	public String getFullFilePath(String filePath) {
		//provider/recepts/20161104140205-recept-400802c97f.jpg
		if (filePath == null) {
            return "";   
        }
		try {
			String fullFilePath = providerOSSClientUtil.getProviderObject(isInternal, filePath);
			return fullFilePath;
		}  catch (Exception e) {
			e.printStackTrace();
			return "";
		}  
		

	}
	
	
	
	public  void close(Closeable stream){
		try {
			if(stream != null) stream.close();
		} catch (IOException e) {
		}
	} 
    

    public String getPdfOut(){
    	return this.pdfout;
    }

	public String getSigout() {
		return sigout;
	}
 
	public String getSignaturepfx() {
		return signaturepfx;
	}
 
	public String getSignaturetemp() {
		return signaturetemp;
	}
 
	
	public String getSignatureunitrustkey() {
		return signatureunitrustkey;
	}
}
