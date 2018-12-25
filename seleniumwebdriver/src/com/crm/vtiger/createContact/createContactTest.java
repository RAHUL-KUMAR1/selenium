package com.crm.vtiger.createContact;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.crm.vtiger.genricLib.baseClass;
import com.crm.vtiger.objectRepositoryLib.CreateContactPage;
import com.crm.vtiger.objectRepositoryLib.homePage;
import com.crm.vtiger.objectRepositoryLib.navigateToContactPage;

public class createContactTest extends baseClass {

	@Test
	public void createContact() throws InvalidFormatException, IOException
	{
	//read test script data
		String lastName     =flib.getexcelData("contact", 1, 1);
		//home page
		homePage hp=PageFactory.initElements(driver, homePage.class);
		hp.navigateToContactPage() ;
		//navigate to contact
		navigateToContactPage nc=PageFactory.initElements(driver,navigateToContactPage.class);
		nc.navigateToCreateContactPage();
		//create contact
		CreateContactPage cp=PageFactory.initElements(driver, CreateContactPage.class);
		cp.ContactPage(lastName);
		
		
	}
}
