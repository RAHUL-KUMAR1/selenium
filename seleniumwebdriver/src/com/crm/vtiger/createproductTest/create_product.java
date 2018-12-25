package com.crm.vtiger.createproductTest;
/*
 * 
 * 
 * 
 * author rahul
 */


import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.genricLib.baseClass;
import com.crm.vtiger.genricLib.fileutil;
@Test(priority=3)
public class create_product extends baseClass {
	
public static void create_product() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {

	 fileutil flib=new fileutil();
	 String productName=flib.getexcelData("product", 0, 1);


driver.findElement(By.xpath("//table[2]/tbody/tr/td[2]/table/tbody/tr/td[12]")).click();
driver.findElement(By.xpath("//img[contains(@src,'btnL3Add.gif')]")).click();
driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productName);
boolean b2=driver.findElement(By.xpath("//input[@name='discontinued']")).isSelected();
if(b2==false) {driver.findElement(By.xpath("//input[@name='discontinued']")).click();}
driver.findElement(By.xpath("//img[@id='jscal_trigger_sales_start_date']")).click();
Select s3=new Select(driver.findElement(By.xpath("//select[@name='productcategory']")));
s3.selectByVisibleText("CRM Applications");
Select s5=new Select(driver.findElement(By.xpath("//select[@name='glacct']")));
s5.selectByVisibleText("304-Sales-Software-Support");
driver.findElement(By.xpath("//tbody/tr[1]/td/div/input[@title='Save [Alt+S]']")).click();
//verify 
boolean b1=driver.findElement(By.xpath("//span[contains(text(),'"+productName+"')]")).isDisplayed();
if(b1==true) {
	System.out.println("save product sucessfuly");
}
else {
	System.out.println("product not save");
}

Assert.assertTrue(b1);

}
}

