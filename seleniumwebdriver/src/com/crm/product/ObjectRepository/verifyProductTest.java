package com.crm.product.ObjectRepository;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.crm.vtiger.genricLib.baseClass;



public class verifyProductTest extends baseClass {
	@Test(priority=3)
	public void createProduct() throws InvalidFormatException, IOException {
		 String productName=flib.getexcelData("product", 0, 1);
//home page		 
homePageforProductPage product=PageFactory.initElements(driver, homePageforProductPage.class);
product.navigateTohomePage();
//navigate to product
navigateToProductPage pg=PageFactory.initElements(driver, navigateToProductPage.class);
pg.clickplusButton();
//create product
createProductPage cp=PageFactory.initElements(driver, createProductPage.class);
cp.ContactPage(productName);
cp.save();
//verify product information page 
ProductinformationPage pi=PageFactory.initElements(driver, ProductinformationPage.class);
pi.verifyProduct(productName);


}}
