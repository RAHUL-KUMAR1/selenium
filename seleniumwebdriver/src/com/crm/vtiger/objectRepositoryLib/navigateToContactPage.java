package com.crm.vtiger.objectRepositoryLib;


	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;

	import com.crm.vtiger.genricLib.baseClass;

	public class navigateToContactPage  extends baseClass {
		@FindBy(xpath="//img[contains(@src,'btnL3Add.gif')]")
		private WebElement plusButton;
		
		//utilization through getters
		
		public WebElement getplusbutton() {
			return plusButton;}
		//utilization through Bussiness Liberary/methods
	public void navigateToCreateContactPage() {
		plusButton.click();
	}}