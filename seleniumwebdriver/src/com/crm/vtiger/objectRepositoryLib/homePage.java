package com.crm.vtiger.objectRepositoryLib;



import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

	import com.crm.vtiger.genricLib.baseClass;

	public class homePage  extends baseClass {
		//initialization (Store all the WebElement using @findBy)
		@FindBy(xpath="//table[2]/tbody/tr/td[2]/table/tbody/tr/td[8]")
		private WebElement selectcontact;
	//LOGOUT 
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement navigatetoSignOut;
		
		@FindBy(xpath="//a[text()='Sign Out']")
		private WebElement selectSignOut;
	
 
	//utilization through Bussiness Liberary/methods
		public void navigateToContactPage() {
			selectcontact.click();}
			
			public void navigateToSignOut() {
				navigatetoSignOut.click();}
				public void selectSignOut() {
					selectSignOut.click();
					
	
	}}


