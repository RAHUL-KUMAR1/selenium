package com.crm.vtiger.createEndtoEndTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.vtiger.genricLib.baseClass;
import com.crm.vtiger.genricLib.fileutil;

public class end1 extends baseClass {
    @Test
	public static void main() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
	
	fileutil flib=new fileutil();


	
	String organisationName =flib.getexcelData("Sheet2", 10, 1);
	String productName      =flib.getexcelData("Sheet2", 1, 1);
	String lastName         =flib.getexcelData("Sheet2", 2, 1);
	String subjectName      =flib.getexcelData("Sheet2", 3, 1);
    String qty1             =flib.getexcelData("Sheet2", 6, 1);
	String bill_street      =flib.getexcelData("Sheet2", 7, 1);
	String bill_pobox       =flib.getexcelData("Sheet2", 8, 1);
	String bill_city        =flib.getexcelData("Sheet2", 9, 1);
	String bill_state       =flib.getexcelData("Sheet2", 10, 1);
	String bill_code        =flib.getexcelData("Sheet2", 11, 1);
	String bill_country     =flib.getexcelData("Sheet2", 12, 1);
	String listPrice1       =flib.getexcelData("Sheet2", 13, 1);
	String shipping_handling_charge=flib.getexcelData("Sheet2", 14, 1);
	String adjustment       =flib.getexcelData("Sheet2", 15, 1);
		
  /*click on organisation*/
		
	 driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	 
  /* click new organisation  button*/
	 driver.findElement(By.xpath(" //img[@title='Create Organization...']")).click();
	 
  /*create new organisation*/
	 driver.findElement(By.name("accountname")).sendKeys(organisationName);
	   
  /*save*/
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    Thread.sleep(3000);
	  
  /*click on product*/
	 driver.findElement(By.xpath("//a[@href=\"index.php?module=Products&action=index\"]")).click();
		
  /* click new product  button*/
	 driver.findElement(By.xpath("//img[@title='Create Product...']")).click();	
		 
  /*create new product*/
	 driver.findElement(By.name("productname")).sendKeys(productName);
		 	   
  /*save*/
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			    Thread.sleep(3000);
			    /*click on contact*/
	
	 /* click new contact  button*/
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
							 
			   /*create new contact*/
	 driver.findElement(By.name("lastname")).sendKeys(lastName);
	 driver.findElement(By.xpath("//tbody/tr[5]/td[2]/img")).click();
			 			

			 			 Set<String>set=driver.getWindowHandles();
			 			 Iterator<String>it=set.iterator();
			 			 String parentwindow=it.next();
			 			 String childwindow=it.next();
			 			 
	 driver.switchTo().window(childwindow);
	 driver.findElement(By.xpath("//a[text()='"+organisationName+"']")).click();
	 driver.switchTo().window(parentwindow);
	  /*save*/
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 /* Dropdown menu*/
	 WebElement wb1=driver.findElement(By.xpath("//a[text()='More']/.."));
	 /*step.2 create an object to action class*/
	 Actions act=new Actions(driver);
	/*step.3 Take mouse cursor on the dropdown menu*/
	act.moveToElement(wb1).perform();
	/*step.4 click on sub menu*/
	 driver.findElement(By.xpath("//a[text()='Quotes']")).click();
	/* click new contact  button*/
	driver.findElement(By.xpath("//img[@title='Create Quote...']")).click();
	 /*create new contact*/
	driver.findElement(By.name("subject")).sendKeys(subjectName);
    /* organisation lookup image*/ 
	driver.findElement(By.xpath("//tbody/tr[7]/td[4]/img")).click();
					 			 
					 			 
					 			 Set<String>set1=driver.getWindowHandles();
					 			 
					 			 Iterator<String>it1=set1.iterator();
					 			 String parentwindow1=it1.next();
					 			 String childwindow1=it1.next();
					 			 
					 			 driver.switchTo().window(childwindow1);
					 			 
					 			 driver.findElement(By.xpath("//a[text()='"+organisationName+"']")).click();
					 			
					 			
					 			Alert alt=driver.switchTo().alert();
					 			alt.accept();
					 			 
					 			 driver.switchTo().window(parentwindow1);
					 			
				  /* billing adress*/	 
								 driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys(bill_street);
								 driver.findElement(By.xpath("//input[@name='bill_pobox']")).sendKeys(bill_pobox);
								 driver.findElement(By.xpath("//input[@name='bill_city']")).sendKeys(bill_city);
								 driver.findElement(By.xpath("//input[@name='bill_state']")).sendKeys(bill_state);
								 driver.findElement(By.xpath("//input[@name='bill_code']")).sendKeys(bill_code);
								 driver.findElement(By.xpath("//input[@name='bill_country']")).sendKeys(bill_country);
					 			  
								 
				 /* copy billing adress*/	 
								 driver.findElement(By.xpath("//tbody/tr[10]/td[3]/input")).click();
							  
				 /*add  product*/
								 driver.findElement(By.xpath("//img[@id='searchIcon1']")).click();
									  		
								 Set<String>set2=driver.getWindowHandles();
					 			 Iterator<String>it2=set2.iterator();
					 			 String parentwindow2=it2.next();
					 			 String childwindow2=it2.next();
					 			 
					 			 driver.switchTo().window(childwindow2);
					 			 
					 			 driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
					  			 driver.switchTo().window(parentwindow2);
					  		
				 /* add product*/
								 driver.findElement(By.xpath("//input[@id='qty1']")).sendKeys(qty1);	  
					   		 
				 /*add  contact*/
								 driver.findElement(By.xpath("//tbody/tr[5]/td[4]/img")).click();
								 
								 Set<String>set3=driver.getWindowHandles();
					 			 Iterator<String>it3=set3.iterator();
					 			 String parentwindow3=it3.next();
					 			 String childwindow3=it3.next();
					 			 
					 			 driver.switchTo().window(childwindow3);
					 			 
					 			 driver.findElement(By.xpath("//a[text()=' "+lastName+"']")).click();
					 			 
					 			Alert alt1=driver.switchTo().alert();
					 			alt1.accept();
					 			
					  			 driver.switchTo().window(parentwindow3);
					  			 	
			   /*save*/
							     
							     driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys(bill_state);
							     	 driver.findElement(By.xpath("//input[@onclick='return copyAddressRight(EditView)']")).click();
							     	Select s2=new Select(driver.findElement(By.xpath(".//*[@id='inventory_currency']")));
							    	s2.selectByVisibleText("India, Rupees (₨)");
							    	Alert a2=driver.switchTo().alert();
							        a2.accept();
							    	
							    	driver.findElement(By.xpath(".//*[@id='qty1']")).sendKeys(qty1);
							    	driver.findElement(By.xpath(".//*[@id='listPrice1']")).sendKeys(listPrice1);
							    	WebElement w2=driver.findElement(By.xpath(".//*[@id='shipping_handling_charge']"));
							    			w2.clear();
							    	w2.sendKeys(shipping_handling_charge);
							    	Select s3=new Select(driver.findElement(By.xpath(".//*[@id='adjustmentType']")));
							    	s3.selectByVisibleText("Add");
							    	WebElement w3=driver.findElement(By.xpath(".//*[@id='adjustment']"));
							    	w3.clear();
							    	w3.sendKeys(adjustment);
							    	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
							     /*validation*/	
							     WebElement ee=driver.findElement(By.xpath("//span[contains(text(),'Quote Information')]"));
						          ee.getText();
						         String exresult=ee.getText();
						         String actresult="iron6 - Editing Quote Information";
						         if(exresult.contains(actresult))
						         {
						         	System.out.println(ee.getText() + " created sucessfully");
						         }
						         else
						         {
						         	System.out.println("quote not created");
						         }  
			   /*logout*/
							        driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
							        driver.findElement(By.xpath("//tbody/tr[2]/td/a[text()='Sign Out']")).click();
							         
							        driver.close();
								 
		
		
	}

}
