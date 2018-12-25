package com.crm.vtiger.objectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import seleniumwebdriver.test;

import com.crm.vtiger.genricLib.baseClass;

public class loginPage extends baseClass {
	//initialization (Store all the WebElement using @findBy)
	@FindBy(name="user_name")
	private WebElement usernameEdit;
	
	
	@FindBy(name="user_password")
	private WebElement passwordEdit;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	


//utilization through Bussiness Liberary/methods
@test
public void loginToApp(String userName,String password) {
usernameEdit.sendKeys(userName);
passwordEdit.sendKeys(password);
loginButton.click();
}}