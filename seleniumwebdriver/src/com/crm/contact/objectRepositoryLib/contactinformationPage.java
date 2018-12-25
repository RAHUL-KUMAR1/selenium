package com.crm.contact.objectRepositoryLib;



import org.junit.Assert;
import org.openqa.selenium.By;


import org.testng.Reporter;

import com.crm.vtiger.genricLib.baseClass;

public class contactinformationPage extends baseClass {
	

	public void saveVerificationPage(String lastName)  {
		
		//accountname2.isDisplayed();
		boolean b1=driver.findElement(By.xpath("//span[contains(text(),'"+lastName+"')]")).isDisplayed();
		Assert.assertTrue(b1);	
		
		Reporter.log("sucessfully contact created");
}

}
