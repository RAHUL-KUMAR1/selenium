package com.crm.product.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.vtiger.genricLib.baseClass;

public class createProductPage extends baseClass {
	
	//initialization (Store all the WebElement using @findBy)
			@FindBy(name="productname")
			private WebElement productname;
			@FindBy(xpath="//tbody/tr[1]/td/div/input[@accesskey='S']")
			private WebElement saveButton;
			
			//utilization through Bussiness Liberary/methods
			public void  ContactPage(String productName) {
			productname.sendKeys(productName);}
			public void save() {
			saveButton.click();
			}


}
