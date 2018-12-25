package com.crm.product.ObjectRepository;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.Reporter;

import com.crm.vtiger.genricLib.baseClass;

public class ProductinformationPage extends baseClass {
	
	public void verifyProduct(String productName) {
	
	boolean b1=driver.findElement(By.xpath("//span[contains(text(),'"+productName+"')]")).isDisplayed();
	Assert.assertTrue(b1);
	
	

}
}