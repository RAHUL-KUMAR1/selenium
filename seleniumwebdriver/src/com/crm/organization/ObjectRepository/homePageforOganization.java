package com.crm.organization.ObjectRepository;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.vtiger.genricLib.baseClass;

public class homePageforOganization extends baseClass {
	
	
	
	//initialization (Store all the WebElement using @findBy)

	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement selectOrganization;
//LOGOUT 
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement navigatetoSignOut;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement selectSignOut;


//utilization through Bussiness Liberary/methods
	public navigateToOrganizationPage navigateToHomePage() {
		selectOrganization.click();
		return new navigateToOrganizationPage();}
		
		public void navigateToSignOut() {
			navigatetoSignOut.click();
			selectSignOut.click();}
			

			}
