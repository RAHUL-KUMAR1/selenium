package com.crm.quote.ObjectRepository;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.crm.vtiger.genricLib.baseClass;

public class createQuotePage extends baseClass {
	
	//initialization (Store all the WebElement using @findBy)

	@FindBy(name="subject")
	private WebElement subjectname;
	@FindBy(id="shipping")
	private WebElement shippingAddress;
	@FindBy(xpath="//input[contains(@onclick,'copyAddressRight')]")
	private WebElement copyRadioButton;
	@FindBy(id="qty1")
	private WebElement quantity;
	@FindBy(id="listPrice1")
	private WebElement listprice;
//organization
    @FindBy(xpath="//tbody/tr[7]/td[4]/img")
    private WebElement selectorganization;
//contact
    @FindBy(xpath="//tbody/tr[5]/td[4]/img")
    private WebElement selectcontact;
//product
    @FindBy(id="searchIcon1")
    private WebElement selectproduct;
	@FindBy(xpath="//tbody/tr[1]/td/div/input[@accesskey='S']")
	private WebElement saveButton;
    @FindBy(id="shipping_handling_charge")
    private WebElement shipping_handling;
    @FindBy(id="adjustmentType")
    private WebElement adjustment_Type;
    @FindBy(id="adjustment")
    private WebElement adjustmenttext;
    @FindBy(name="bill_street")
    private WebElement billstreet;
   
	
	
//utilization through Bussiness Liberary/methods
	public void  QuotePage(String contactName, String shipping, String qty1, String listPrice1,String bill_street  ) {
	subjectname.sendKeys(contactName);
	shippingAddress.sendKeys(shipping);
	billstreet.sendKeys(bill_street);
	copyRadioButton.click();
	quantity.sendKeys(qty1);
	listprice.sendKeys(listPrice1);
	}
	public void shippinghandling(String shipping_handling_charge) {
	shipping_handling.clear();
	shipping_handling.sendKeys(shipping_handling_charge);
	}
	public void selectadd() {
	Select s3=new Select(adjustment_Type);
	s3.selectByVisibleText("Add");	
	}
	public void selectadjustment(String adjustment ) {
    WebElement w2=adjustmenttext;
	w2.clear();
	w2.sendKeys(adjustment);
	}
	
//select organization 
		public void Organizationplusbutton() {
		selectorganization.click();
		}
	    public void selectOrganization(String accountname ) {
			  Set<String>set2=driver.getWindowHandles();
			  Iterator<String>it2=set2.iterator();
			  String parentwindow2=it2.next();
			  String childwindow2=it2.next();
			  driver.switchTo().window(childwindow2);
			  driver.findElement(By.xpath("//a[text()='"+accountname+"']")).click();
			  Alert alt2=driver.switchTo().alert();
			  alt2.accept();
			  driver.switchTo().window(parentwindow2);
		}
//select contact name
		public void contactplusbutton() {
		selectcontact.click();}
		public void selectcontact(String firstname, String lasttName)	{
		      Set<String>set4=driver.getWindowHandles();
		      Iterator<String>it4=set4.iterator();
		      String parentwindow4=it4.next();
		      String childwindow4=it4.next();
		      driver.switchTo().window(childwindow4);
		      driver.findElement(By.xpath("//a[text()='"+firstname+" "+lasttName+"']")).click();
			  Alert alt4=driver.switchTo().alert();
			  alt4.accept();
			  driver.switchTo().window(parentwindow4);
		}
//product
		public void productplusbutton() {
		selectproduct.click();}
		public void selectproduct(String productName ) {
		     Set<String>set3=driver.getWindowHandles();
			 Iterator<String>it3=set3.iterator();
			 String parentwindow3=it3.next();
			 String childwindow3=it3.next();
			 driver.switchTo().window(childwindow3);
			 driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
			 driver.switchTo().window(parentwindow3);}
		
//save	
	public void save() {
	saveButton.click();
	}


	

}
