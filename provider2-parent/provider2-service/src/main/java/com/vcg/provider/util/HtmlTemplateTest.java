package com.vcg.provider.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import org.springframework.stereotype.Component;
 

@Component
public class HtmlTemplateTest {
 
	static String inputStream2String(InputStream is) throws IOException{
		   
		   BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		   StringBuffer buffer = new StringBuffer();
		   String line = "";
		   
			while ((line = reader.readLine()) != null){
			     buffer.append(line);
			   }
	 
		   return buffer.toString();
		}
	
	public static void main(String[] args) {
		try {
			URL url = new URL("http://bj-feiyuantu.oss-cn-beijing.aliyuncs.com/provider/template/sheyingshixieyi.html");
			InputStream inputStream = url.openStream();
			String imageInfo = HtmlTemplateTest.inputStream2String(inputStream);
			System.out.println("read"+imageInfo);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
