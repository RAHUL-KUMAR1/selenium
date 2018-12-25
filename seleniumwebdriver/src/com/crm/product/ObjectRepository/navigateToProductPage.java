package com.crm.product.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.vtiger.genricLib.baseClass;

public class navigateToProductPage extends baseClass {

	
	@FindBy(xpath="//img[contains(@src,'btnL3Add.gif')]")
	private WebElement plusButton;
	
	
	
	//utilization through Bussiness Liberary/methods
public void clickplusButton() {
	plusButton.click();
}
}
