package com.crm.organization.ObjectRepository;



import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.crm.vtiger.genricLib.baseClass;

public class organizationinformationPage extends baseClass {
        
	public void saveVerificationPage(String accountname) throws InvalidFormatException, IOException {
		        
		//verify
		boolean b1=driver.findElement(By.xpath("//span[contains(text(),'"+accountname+"')]")).isDisplayed();
		Assert.assertTrue(b1);	
		
		Reporter.log("sucessfully created");
}}
