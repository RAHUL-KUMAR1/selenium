
package com.crm.vtiger.createquoteTest;


import java.io.IOException;
import java.util.Iterator;
import java.util.Set;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.vtiger.genricLib.baseClass;
import com.crm.vtiger.genricLib.fileutil;

public class create_quote extends baseClass {
	@Test
	public static void create_quote_Test () throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		
		fileutil flib=new fileutil();
	       
	        String contactName             =flib.getexcelData("quote", 0, 1);
	        String bill_street             =flib.getexcelData("quote", 1, 1);
		    String shipping                =flib.getexcelData("quote", 3, 1);
            String adjustment              =flib.getexcelData("quote", 4, 1);
			String listPrice1              =flib.getexcelData("quote", 5, 1);
			String shipping_handling_charge=flib.getexcelData("quote", 6, 1);
			String qty1                    =flib.getexcelData("quote", 7, 1);
		    String productName             =flib.getexcelData("product",0, 1);
	        String accountname             =flib.getexcelData("organization", 0, 1);
	        String firstname               =flib.getexcelData("contact", 0, 1);
			String lasttName               =flib.getexcelData("contact", 1, 1);
			
	Actions act=new Actions(driver);
    act.moveToElement(driver.findElement(By.xpath("//a[text()='Dashboard']/../../td[22]/a[@href='javascript:;']"))).perform();;
    
    driver.findElement(By.xpath("//a[text()='Quotes']")).click();
    driver.findElement(By.xpath("//img[contains(@src,'btnL3Add.gif')]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(contactName);
    Select s1=new Select(driver.findElement(By.xpath("//select[@name='carrier']")));
    s1.selectByValue("BlueDart");
    
	driver.findElement(By.xpath(".//*[@id='shipping']")).sendKeys(shipping);
	driver.findElement(By.xpath("//*[@name='bill_street']")).sendKeys(bill_street);
	
	
	driver.findElement(By.xpath("//input[contains(@onclick,'copyAddressRight')]")).click();
	
	
	//driver.findElement(By.xpath(".//*[@id='searchIcon1']")).click();
	
	
	Select s2=new Select(driver.findElement(By.xpath(".//*[@id='inventory_currency']")));
	s2.selectByVisibleText("India, Rupees (₨)");
	Alert a2=driver.switchTo().alert();
    a2.accept();
	
	driver.findElement(By.xpath(".//*[@id='qty1']")).sendKeys(qty1);
	driver.findElement(By.xpath(".//*[@id='listPrice1']")).sendKeys(listPrice1);
	WebElement w1=driver.findElement(By.xpath(".//*[@id='shipping_handling_charge']"));
			w1.clear();
	w1.sendKeys(shipping_handling_charge);
	Select s3=new Select(driver.findElement(By.xpath(".//*[@id='adjustmentType']")));
	s3.selectByVisibleText("Add");
	WebElement w2=driver.findElement(By.xpath(".//*[@id='adjustment']"));
	w2.clear();
	w2.sendKeys(adjustment);
	Thread.sleep(2000);
	//organization
	driver.findElement(By.xpath("//tbody/tr[7]/td[4]/img")).click();
		
	 Set<String>set2=driver.getWindowHandles();
	 Iterator<String>it2=set2.iterator();
	 String parentwindow2=it2.next();
	 String childwindow2=it2.next();
	 
	 driver.switchTo().window(childwindow2);
	 driver.findElement(By.xpath("//a[text()='"+accountname+"']")).click();
		Alert alt2=driver.switchTo().alert();
			alt2.accept();
		 driver.switchTo().window(parentwindow2);
		 //contact name
		 driver.findElement(By.xpath("//tbody/tr[5]/td[4]/img")).click();
			
		 Set<String>set4=driver.getWindowHandles();
		 Iterator<String>it4=set4.iterator();
		 String parentwindow4=it4.next();
		 String childwindow4=it4.next();
		 
		 driver.switchTo().window(childwindow4);
		 driver.findElement(By.xpath("//a[text()='"+firstname+" "+lasttName+"']")).click();
			Alert alt4=driver.switchTo().alert();
				alt4.accept();
			 driver.switchTo().window(parentwindow4);
	//product
		 driver.findElement(By.xpath("//img[@id='searchIcon1']")).click();
	  		
		 Set<String>set3=driver.getWindowHandles();
			 Iterator<String>it3=set3.iterator();
			 String parentwindow3=it3.next();
			 String childwindow3=it3.next();
			 
			 driver.switchTo().window(childwindow3);
			 
			 driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
				
			 driver.switchTo().window(parentwindow3);
			
	driver.findElement(By.xpath("//tbody/tr[25]/td/div/input[@accesskey='S']")).click();
	//veryfy
	boolean b1=driver.findElement(By.xpath("//span[contains(text(),'"+contactName+"')]")).isDisplayed();
	if(b1==true) {
		System.out.println("save quote sucessfuly");
	}
	else {
		System.out.println("quote not save");
	
		Assert.assertTrue(b1);
     
	
	
	
	
	}
	
	
}}