package com.netBanking1.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils 
{
     public static FileInputStream fi;
     public static FileOutputStream fo;
     public static XSSFWorkbook wb;
	 public static XSSFSheet ws;
	 public static XSSFRow row;
	 public static XSSFCell cell;
	 
	 
	 public static int getRowCount(String XLFile,String XLSheet) throws IOException
	 {
		 fi=new FileInputStream(XLFile);
		 wb=new XSSFWorkbook(fi);
		 ws=wb.getSheet(XLSheet);
		int rowcount=ws.getLastRowNum();
		wb.close();
		fi.close();
		
		 return rowcount;
		 
	 }
	 
	 public static int getCellCount(String XLFile,String XLSheet) throws IOException
	 {
		 fi=new FileInputStream(XLFile);
		 wb=new XSSFWorkbook(fi);
		 ws=wb.getSheet(XLSheet);
		 row=ws.getRow(1);
		 int cellCount=row.getLastCellNum();
		 wb.close();
		 fi.close();
		 return cellCount;
	 }
	 
	 public static String getCellValue(String XLFile,String XLSheet,int rowNum,int cellNum) throws IOException
	 {
		 fi=new FileInputStream(XLFile);
		 wb=new XSSFWorkbook(fi);
		 ws=wb.getSheet(XLSheet);
		 row=ws.getRow(rowNum);
		 cell=row.getCell(cellNum);
		 
		 String data;
		 try
		 {
			 DataFormatter DF=new DataFormatter();
			 String cellValue= DF.formatCellValue(cell);
			 return cellValue;
		 }
		 catch(Exception e)
		 {
			 data="";
			 
		 }
		 wb.close();
		 fi.close();
		 return data;
	 }
	 
	 public static void setCellValue(String XLFile,String XLSheet,int rowNum,int cellNum,int cellValue) throws IOException
	 {
		 fi=new FileInputStream(XLFile);
		 wb=new XSSFWorkbook(fi);
		 ws=wb.getSheet(XLSheet); 
		 row=ws.getRow(rowNum);
		 row.getCell(cellNum).setCellValue(cellValue);
		 fo=new FileOutputStream(XLFile); 
		 wb.write(fo);
		 wb.close();
		 fo.close();
		 fi.close();
		 
	 }
}
