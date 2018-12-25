package com.crm.quote.ObjectRepository;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.crm.vtiger.genricLib.baseClass;
public class verifyQuotetest extends baseClass {
	@Test(priority=4)
	public void createQuote() throws InvalidFormatException, IOException {
	        String contactName             =flib.getexcelData("quote", 0, 1);
	        String bill_street             =flib.getexcelData("quote", 1, 1);
		    String shipping                =flib.getexcelData("quote", 3, 1);
            String adjustment              =flib.getexcelData("quote", 4, 1);
			String listPrice1              =flib.getexcelData("quote", 5, 1);
			String shipping_handling_charge=flib.getexcelData("quote", 6, 1);
			String qty1                    =flib.getexcelData("quote", 7, 1);
		    String productName             =flib.getexcelData("product",0, 1);
	        String accountname             =flib.getexcelData("organization", 0, 1);
	        String firstname               =flib.getexcelData("contact", 0, 1);
			String lasttName               =flib.getexcelData("contact", 1, 1);
	homePageForOute qt=PageFactory.initElements(driver, homePageForOute.class);
    qt.movetoMore();
    qt.navigateToHomePage();
    navigateToQuotePage nq=PageFactory.initElements(driver, navigateToQuotePage.class);
    nq.navigateToCreateOrganizationPage();
    createQuotePage cp=PageFactory.initElements(driver, createQuotePage.class);
    cp.QuotePage(contactName, shipping, qty1, listPrice1, bill_street);
    cp.Organizationplusbutton();
    cp.selectOrganization(accountname);
    cp.contactplusbutton();
    cp.selectcontact(firstname, lasttName);
    cp.productplusbutton();
    cp.selectproduct(productName);
    cp.shippinghandling(shipping_handling_charge);
    cp.selectadd();
    cp.selectadjustment(adjustment);
    cp.save();
    saveQuotePage sp=PageFactory.initElements(driver, saveQuotePage.class);
    sp.verifycreateQuote(contactName);
    
    
}}