package com.crm.organization.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.vtiger.genricLib.baseClass;

public class CreateOrganizationPage extends baseClass {
	
	
	//initialization (Store all the WebElement using @findBy)
	@FindBy(name="accountname")
	private WebElement accountname;
	@FindBy(xpath="//tbody/tr[1]/td/div/input[@accesskey='S']")
	private WebElement saveButton;
	
	//utilization through Bussiness Liberary/methods
	public void  ContactPage(String accountName) {
		accountname.sendKeys(accountName);
	}
	public organizationinformationPage clickonSavebutton() {
	saveButton.click();
	return new organizationinformationPage();
	}



}
