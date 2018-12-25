package com.crm.quote.ObjectRepository;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.crm.vtiger.genricLib.baseClass;

public class homePageForOute extends baseClass {
	//initialization (Store all the WebElement using @findBy)
	
   
    @FindBy(xpath="//a[text()='Dashboard']/../../td[22]/a[@href='javascript:;']")
    private WebElement selectMore;
    @FindBy(xpath="//a[text()='Quotes']")
	private WebElement selectQuote;
//LOGOUT 
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement navigatetoSignOut;
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement selectSignOut;

 //utilization through Bussiness Liberary/methods
	
	
	public void movetoMore() {
	Actions act=new Actions(driver);
	act.moveToElement(selectMore).perform();}
	
	public void navigateToHomePage() {
	selectQuote.click();}

	public void navigateToSignOut() {
	navigatetoSignOut.click();}
	public void selectSignOut() {
	selectSignOut.click();
				

}}
