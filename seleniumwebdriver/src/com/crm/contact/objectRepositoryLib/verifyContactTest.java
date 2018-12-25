package com.crm.contact.objectRepositoryLib;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.crm.vtiger.genricLib.baseClass;

import com.crm.vtiger.objectRepositoryLib.homePage;
import com.crm.vtiger.objectRepositoryLib.navigateToContactPage;

public class verifyContactTest extends baseClass {

	@Test(priority=2)
	public void createContact() throws InvalidFormatException, IOException
	{
	//read test script data
		String lastName      =flib.getexcelData("contact", 1, 1);
		String accountname   =flib.getexcelData("organization", 0, 1);
		//home page
		homePage hp=PageFactory.initElements(driver, homePage.class);
		hp.navigateToContactPage() ;
		//navigate to contact
		navigateToContactPage nc=PageFactory.initElements(driver,navigateToContactPage.class);
		nc.navigateToCreateContactPage();
		//create contact
		CreateContactPage1 cp=PageFactory.initElements(driver, CreateContactPage1.class);
		cp.ContactPage(lastName);
		cp.selectOrganizationImage();
		cp.windowhandleforOrganization(accountname);
        cp.savebutton();
		//verify
		contactinformationPage ci=PageFactory.initElements(driver, contactinformationPage.class);
		ci.saveVerificationPage(lastName);
	    
	}
}