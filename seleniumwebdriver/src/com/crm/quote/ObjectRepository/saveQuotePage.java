package com.crm.quote.ObjectRepository;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.crm.vtiger.genricLib.baseClass;

public class saveQuotePage extends baseClass {
	
	
		public void verifycreateQuote(String contactName) {
			//veryfy
			boolean b1=driver.findElement(By.xpath("//span[contains(text(),'"+contactName+"')]")).isDisplayed();
			Assert.assertTrue(b1);
		}
	}
	
	


