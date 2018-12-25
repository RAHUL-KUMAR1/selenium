package com.crm.organization.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.vtiger.genricLib.baseClass;

public class navigateToOrganizationPage extends baseClass {
	
	@FindBy(xpath="//img[contains(@src,'btnL3Add.gif')]")
	private WebElement plusButton;
	

	
	//utilization through Bussiness Liberary/methods
     public CreateOrganizationPage navigateToCreateOrganizationPage() {
	 plusButton.click();
	 return new CreateOrganizationPage();
}
}



