package com.crm.vtiger.genricLib;


	import java.io.FileInputStream;
	
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.util.Properties;

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.WebElement;

	public class fileutil {
	 		
			 String filepath="C:\\Users\\PREETY KUMARI\\eclipse-workspace\\seleniumwebdriver\\Data\\commondata.properties";
			 String excelpath="C:\\Users\\PREETY KUMARI\\Desktop\\worktable.xlsx";
    public Properties getpropertiesfileobject() throws IOException
			 {
				 FileInputStream fis=new FileInputStream(filepath);
				 Properties pobj=new Properties();
				 pobj.load(fis);
				return pobj;
				 
			 }
			 
	public String getexcelData(String sheetname,int rownum,int celnum) throws  InvalidFormatException, IOException
	{
		FileInputStream fis=new FileInputStream(excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		String data=sh.getRow(rownum).getCell(celnum).getStringCellValue();
		wb.close();
		
		return data;
		
	}
	public void setexceldata(String sheetname,int rownum,int colnum,String data) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fis=new FileInputStream(excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		sh.getRow(rownum).createCell(colnum).setCellValue(data);
		FileOutputStream fos=new FileOutputStream(excelpath);
		wb.write(fos);
		wb.close();
	}
	public void customWait(WebElement wb) {
		int count =0;
		while(count<20) {
			try {
				wb.isDisplayed();
			
			wb.click();
			break;}
			catch(Throwable t) {System.out.println("not loaded");}}}
			
			
	
	}
		

	 



