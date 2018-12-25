package com.crm.organization.ObjectRepository;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.crm.vtiger.genricLib.baseClass;


public class verifyOrganizationTest extends baseClass {

	@Test(priority=1)
	public void createorganization() throws InvalidFormatException, IOException
	{
	//read test script data
		 String accountname         =flib.getexcelData("organization", 0, 1);	
		//home page
		homePageforOganization hp=PageFactory.initElements(driver, homePageforOganization.class);
		hp.navigateToHomePage();
		//navigate to organization
		navigateToOrganizationPage nc=PageFactory.initElements(driver,navigateToOrganizationPage.class);
		nc.navigateToCreateOrganizationPage();
		//create contact
		CreateOrganizationPage cp=PageFactory.initElements(driver, CreateOrganizationPage.class);
		cp.ContactPage(accountname);
		cp.clickonSavebutton();
		//very
		organizationinformationPage op=PageFactory.initElements(driver, organizationinformationPage.class);
		op.saveVerificationPage(accountname);
	}

}
