package com.crm.vtiger.createcontactTest;


import java.io.IOException;
import java.util.Iterator;

import java.util.Set;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.junit.Assert;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.vtiger.genricLib.baseClass;
import com.crm.vtiger.genricLib.fileutil;
@Test(priority=2)
public class create_contact extends baseClass {
	
	public static void create_contact_Test() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		
	

		fileutil flib=new fileutil();
        String firstname     =flib.getexcelData("contact", 0, 1);
		String lasttName     =flib.getexcelData("contact", 1, 1);
		String accountname   =flib.getexcelData("organization", 0, 1);
		
		
	
	driver.findElement(By.xpath("//table[2]/tbody/tr/td[2]/table/tbody/tr/td[8]")).click();
	driver.findElement(By.xpath("//img[contains(@src,'btnL3Add.gif')]")).click();
	Select se=new Select(driver.findElement(By.xpath("//select[@name='salutationtype']")));
	se.selectByValue("Mr.");
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lasttName);
	Select s2=new Select(driver.findElement(By.xpath("//select[@name='leadsource']")));
	s2.selectByValue("Employee");
	driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img[@alt='Select']")).click();
	Set<String>set5=driver.getWindowHandles();
		 Iterator<String>it3=set5.iterator();
		 String parent=it3.next();
		 String child=it3.next();
		 
		 driver.switchTo().window(child);
		 
		 driver.findElement(By.xpath("//a[text()='"+accountname+"']")).click();
		 
		
		 driver.switchTo().window(parent);
		
   // click on the save button
		Thread.sleep(1000);
	WebElement w5=driver.findElement(By.xpath("//tbody/tr[1]/td/div/input[@accesskey='S']"));
	w5.click();
	//veryfy
	boolean b1=driver.findElement(By.xpath("//span[contains(text(),'"+firstname+"')]")).isDisplayed();
	if(b1==true) {
		System.out.println("save contact sucessfuly");
	}
	else {
		System.out.println("contact not save");
	}
  
	Assert.assertTrue(b1);
	
}}
