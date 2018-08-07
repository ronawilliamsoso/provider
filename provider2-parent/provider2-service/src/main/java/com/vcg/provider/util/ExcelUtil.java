package com.vcg.provider.util;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Component;

@Component
public class ExcelUtil implements ReaderUtil{

	
	public static Workbook getWorkbook(InputStream in)  {
    	
        Workbook workbook = null;
		try {
			workbook = WorkbookFactory.create(in);
		} catch (Exception e) {
			e.printStackTrace();
		} 
       
        return workbook;
    }
    
    public static Sheet getSheet(Workbook workbook,Integer sheet)  {
    	
    	if(sheet==null){
    		sheet=0;
    	}
    	if(workbook!=null){
    	
    		return workbook.getSheetAt(sheet);
    	}
    		
    	return null;
    }
    
	
  
    @Override
    public List<List<String>> readData(InputStream in) throws Exception{
      
        // 获取workbook对象
        Workbook workbook = null;
        try {
            workbook = getWorkbook(in);
            Sheet sheet = getSheet(workbook, 0);
            
            if(sheet!=null){
            	 int firstRowIndex = sheet.getFirstRowNum();
                 int lastRowIndex = sheet.getLastRowNum();
            	
               /*  // 读取首行 即,表头
                 Row firstRow = sheet.getRow(firstRowIndex);
                 for (int i = firstRow.getFirstCellNum(); i <= firstRow.getLastCellNum(); i++) {
                     Cell cell = firstRow.getCell(i);
                     String cellValue = this.getCellValue(cell, true);
                     System.out.print(" " + cellValue + "\t");
                 }*/
                 
                List<List<String>> result=new ArrayList<List<String>>();
                 
                 for (int rowIndex = firstRowIndex + 1; rowIndex <= lastRowIndex; rowIndex++) {
                     Row currentRow = sheet.getRow(rowIndex);// 当前行
                     int firstColumnIndex = currentRow.getFirstCellNum(); // 首列
                     int lastColumnIndex = currentRow.getLastCellNum();// 最后一列
                     List<String> rowResult=new ArrayList<String>();
                     for (int columnIndex = firstColumnIndex; columnIndex <= lastColumnIndex; columnIndex++) {
                         Cell currentCell = currentRow.getCell(columnIndex);// 当前单元格
                         String currentCellValue = getCellValue(currentCell, true);// 当前单元格的值
                         rowResult.add(currentCellValue.trim());
                     }
                     result.add(rowResult);
                     System.out.println("");
                 }
                 
                 return result;
                 
            }
            	
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 取单元格的值
     * @param cell 单元格对象
     * @param treatAsStr 为true时，当做文本来取值 (取到的是文本，不会把“1”取成“1.0”)
     * @return
     */
	public static String getCellValue(Cell cell, boolean treatAsStr) {
        if (cell == null) {
            return "";
        }
        
        if(cell.getCellType()==HSSFCell.CELL_TYPE_NUMERIC&&HSSFDateUtil.isCellDateFormatted(cell)){
        	 double d = cell.getNumericCellValue();  
             Date date = HSSFDateUtil.getJavaDate(d); 
             SimpleDateFormat dformat=new SimpleDateFormat("yyyy-MM-dd");
             return dformat.format(date);
        }
        
        cell.setCellType(CellType.STRING);

        return cell.getStringCellValue();
    }

}
 
