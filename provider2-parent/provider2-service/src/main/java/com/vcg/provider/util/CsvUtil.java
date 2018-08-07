package com.vcg.provider.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;



public class CsvUtil implements ReaderUtil{	

	public static final String DEFAULT_CSV_SEPERATOR =",";
	
	/**
     * 导入
     * 
     * @param file csv文件(路径+文件)
     * @return
	 * @throws FileNotFoundException 
     */
    public List<List<String>> readData(InputStream input) throws Exception{
    	InputStreamReader reader = new InputStreamReader(input,"utf-8");
    	
        List<List<String>> dataList=new ArrayList<List<String>>();
        
        CSVReader csvReader =null;
        try { 
        	csvReader =  new CSVReader(reader);
			/*String [] header = csvReader.readNext();   //用readnext读取之后就不存在于stream中了
	        for (String s : header) {
	            System.out.print(s + ",");
	        }
	        System.out.println("");*/

	        List<String[]> list = csvReader.readAll(); //此时读取的已经是第二行了
	        if(list != null && list.size()>0){
	        	for(String[] strArr:list){
	        		List<String> rowDataList = Arrays.asList(strArr);
	        		dataList.add(rowDataList);
	        	}
	        }
	        
        }catch (Exception e) {
        	e.printStackTrace();
        }finally{
            if(csvReader!=null){
                try {
                	csvReader.close();
                	csvReader=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
 
        return dataList;
    }
    
    
    public static void main(String[] args) throws Exception{
    	CsvUtil util = new CsvUtil();
		String filePath ="d:\\eps-2356.csv";
		File file = new File(filePath);
		if(file != null && file.isFile()){
			FileInputStream input = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(input);
			
			
//			LineReader lineReader = new LineReader();
			
			CSVReader csvReader = new CSVReader(reader);
			String [] header = csvReader.readNext();   //用readnext读取之后就不存在于stream中了
	        for (String s : header) {
	            System.out.print(s + ",");
	        }
	        System.out.println("");

	        List<String[]> list = csvReader.readAll(); //此时读取的已经是第二行了
	        System.out.println(list.get(0)[0]);
	        
	        String[] strArr = list.get(0);
	        System.out.println("strArr.length: "+strArr.length);
	        for(String str:strArr){
	        	System.out.println(str+" ");
	        }
//			List<List<String>> dataList = util.readData(input);
//			if(dataList != null && dataList.size()>0){
//				for(List<String> list :dataList){
//					if(list != null && list.size()>0){
//						for(String str:list){
//							System.out.print(str+",");
//						}
//					}
//					System.out.println("");
//				}
//			}
		}
		
	}
}
