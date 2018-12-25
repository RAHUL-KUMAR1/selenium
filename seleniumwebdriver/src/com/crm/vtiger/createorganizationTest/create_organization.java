package com.crm.vtiger.createorganizationTest;


import static org.testng.Assert.assertTrue;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import com.crm.vtiger.genricLib.baseClass;
import com.crm.vtiger.genricLib.fileutil;
@Test (priority=1)
public class create_organization extends baseClass {
	
	
	public static void create_organization_test() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		
	fileutil flib=new fileutil();
        String accountname         =flib.getexcelData("organization", 0, 1);	
		String biil_street         =flib.getexcelData("organization", 1, 1);
		String description         =flib.getexcelData("organization", 2, 1);
	
	driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	driver.findElement(By.xpath("//img[contains(@src,'btnL3Add.gif')]")).click();
driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(accountname);

Select s1=new Select(driver.findElement(By.xpath("//select[@name='industry']")));
s1.selectByValue("Banking");
Select s2=new Select(driver.findElement(By.xpath("//select[@name='accounttype']")));
s2.selectByValue("Customer");

Select s3=new Select(driver.findElement(By.xpath("//select[@name='rating']")));
s3.selectByValue("Acquired");

driver.findElement(By.xpath("//input[@name='notify_owner']")).click();
driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys(biil_street);

driver.findElement(By.xpath("//input[contains(@onclick,'copyAddressRight')]")).click();
driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(description);
Thread.sleep(2000);
WebElement w5=driver.findElement(By.xpath("//tbody/tr[1]/td/div/input[@title='Save [Alt+S]']"));
Actions act=new Actions(driver);
act.moveToElement(w5).perform();
act.click().perform();
boolean b1=driver.findElement(By.xpath("//span[contains(text(),'"+accountname+"')]")).isDisplayed();


Assert.assertTrue(b1);	
assertTrue(true, "sucessfully created");
}}
