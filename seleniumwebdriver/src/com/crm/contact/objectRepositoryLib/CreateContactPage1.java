package com.crm.contact.objectRepositoryLib;


	

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;

	import com.crm.vtiger.genricLib.baseClass;

	public class CreateContactPage1  extends baseClass {
		//initialization (Store all the WebElement using @findBy)
		@FindBy(name="lastname")
		private WebElement lastname;
		
		@FindBy(xpath="//tbody/tr[1]/td/div/input[@accesskey='S']")
		private WebElement saveButton;
		@FindBy(xpath="//input[@name='account_id']/following-sibling::img[@alt='Select']")
		private WebElement organizationlookupImage;
		
		
	
	//utilization through Bussiness Liberary/methods
		public void selectOrganizationImage() {
			organizationlookupImage.click();
		}
		public void windowhandleforOrganization(String accountname) {
			Set<String>set5=driver.getWindowHandles();
				 Iterator<String>it3=set5.iterator();
				 String parent=it3.next();
				 String child=it3.next();
				 
				 driver.switchTo().window(child);
				 driver.findElement(By.xpath("//a[text()='"+accountname+"']")).click();
				 driver.switchTo().window(parent);
		}

	    public void  ContactPage(String lastName) {
	    lastname.sendKeys(lastName);}
	    public void savebutton() {
	    saveButton.click();
	    }
	
}
