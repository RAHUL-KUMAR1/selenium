package com.crm.product.ObjectRepository;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.vtiger.genricLib.baseClass;

public class homePageforProductPage extends baseClass{
	//initialization (Store all the WebElement using @findBy)

	@FindBy(xpath="//table[2]/tbody/tr/td[2]/table/tbody/tr/td[12]")
	private WebElement selectProduct;
//LOGOUT 
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement navigatetoSignOut;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement selectSignOut;


//utilization through Bussiness Liberary/methods
	public navigateToProductPage navigateTohomePage() {
		selectProduct.click();
		return new navigateToProductPage();
	}
		
		public void navigateToSignOut() {
			navigatetoSignOut.click();}
			public void selectSignOut() {
				selectSignOut.click();
				

}

}
