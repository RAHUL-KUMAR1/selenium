package com.crm.vtiger.objectRepositoryLib;


	
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;

	import com.crm.vtiger.genricLib.baseClass;

	public class CreateContactPage  extends baseClass {
		//initialization (Store all the WebElement using @findBy)
		@FindBy(name="lastname")
		private WebElement lastname;
		
		@FindBy(xpath="//tbody/tr[1]/td/div/input[@accesskey='S']")
		private WebElement saveButton;
		

	


	//utilization through Bussiness Liberary/methods
	public void  ContactPage(String lastName) {
	lastname.sendKeys(lastName);
	saveButton.click();
	}

}
