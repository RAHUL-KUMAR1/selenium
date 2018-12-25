package com.crm.vtiger.EndToEndTest;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.vtiger.genricLib.baseClass;
import com.crm.vtiger.genricLib.fileutil;


	public class endToEndTest extends baseClass {
		@Test (priority=1)
		public static void create_organization_test() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
			
		    fileutil flib=new fileutil();
	        String accountname         =flib.getexcelData("organization", 0, 1);	
			String biil_street         =flib.getexcelData("organization", 1, 1);
			String description         =flib.getexcelData("organization", 2, 1);
            String save                =flib.getexcelData("organization", 3, 1);
            
		    String firstname     =flib.getexcelData("contact", 0, 1);
			String lasttName     =flib.getexcelData("contact", 1, 1);
            String savecontact   =flib.getexcelData("contact", 2, 1);
            
            String productName             =flib.getexcelData("product", 0, 1);
            String saveproduct             =flib.getexcelData("product", 1, 1);
            
            String contactName             =flib.getexcelData("quote", 0, 1);
            String bill_street             =flib.getexcelData("quote", 1, 1);
            String shipping                =flib.getexcelData("quote", 3, 1);
            String adjustment              =flib.getexcelData("quote", 4, 1);
            String listPrice1              =flib.getexcelData("quote", 5, 1);
            String shipping_handling_charge=flib.getexcelData("quote", 6, 1);
            String qty1                    =flib.getexcelData("quote", 7, 1);
            String savequote               =flib.getexcelData("quote", 10, 1);
       
           
			
		//creating Organization
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[contains(@src,'btnL3Add.gif')]")).click();
	    driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(accountname);

	Select s1=new Select(driver.findElement(By.xpath("//select[@name='industry']")));
	s1.selectByValue("Banking");
	Select s2=new Select(driver.findElement(By.xpath("//select[@name='accounttype']")));
	s2.selectByValue("Customer");

	Select s3=new Select(driver.findElement(By.xpath("//select[@name='rating']")));
	s3.selectByValue("Acquired");

	driver.findElement(By.xpath("//input[@name='notify_owner']")).click();
	driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys(biil_street);

	driver.findElement(By.xpath("//input[contains(@onclick,'copyAddressRight')]")).click();
	driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(description);
	Thread.sleep(2000);
	WebElement w5=driver.findElement(By.xpath("//tbody/tr[1]/td/div/input[@title='Save [Alt+S]']"));
	Actions act=new Actions(driver);
	act.moveToElement(w5).perform();
	act.click().perform();
	//veryfy
	boolean b1=driver.findElement(By.xpath("//span[contains(text(),'"+accountname+"')]")).isDisplayed();
Assert.assertTrue(b1);
Reporter.log(save);
//create contact

	
	
Thread.sleep(2000);
driver.findElement(By.xpath("//tbody/tr/td[8]//a[text()='Contacts']")).click();
driver.findElement(By.xpath("//img[contains(@src,'btnL3Add.gif')]")).click();
Select se=new Select(driver.findElement(By.xpath("//select[@name='salutationtype']")));
se.selectByValue("Mr.");
driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lasttName);
Select s4=new Select(driver.findElement(By.xpath("//select[@name='leadsource']")));
s4.selectByValue("Employee");
driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img[@alt='Select']")).click();
Set<String>set5=driver.getWindowHandles();
	 Iterator<String>it3=set5.iterator();
	 String parent=it3.next();
	 String child=it3.next();
	 
	 driver.switchTo().window(child);
	 
	 driver.findElement(By.xpath("//a[text()='"+accountname+"']")).click();
	 
	
	 driver.switchTo().window(parent);
	
// click on the save button
	Thread.sleep(1000);
WebElement w6=driver.findElement(By.xpath("//tbody/tr[1]/td/div/input[@accesskey='S']"));
w6.click();
//veryfy
boolean b2=driver.findElement(By.xpath("//span[contains(text(),'"+firstname+"')]")).isDisplayed();

Assert.assertTrue(b2);
Reporter.log(savecontact);
//creating product

driver.findElement(By.xpath("//table[2]/tbody/tr/td[2]/table/tbody/tr/td[12]")).click();
driver.findElement(By.xpath("//img[contains(@src,'btnL3Add.gif')]")).click();
driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productName);
boolean b4=driver.findElement(By.xpath("//input[@name='discontinued']")).isSelected();
if(b4==false) {driver.findElement(By.xpath("//input[@name='discontinued']")).click();}
driver.findElement(By.xpath("//img[@id='jscal_trigger_sales_start_date']")).click();
Select s5=new Select(driver.findElement(By.xpath("//select[@name='productcategory']")));
s5.selectByVisibleText("CRM Applications");
Select s6=new Select(driver.findElement(By.xpath("//select[@name='glacct']")));
s6.selectByVisibleText("304-Sales-Software-Support");
driver.findElement(By.xpath("//tbody/tr[1]/td/div/input[@title='Save [Alt+S]']")).click();
//verify 
boolean b7=driver.findElement(By.xpath("//span[contains(text(),'"+productName+"')]")).isDisplayed();

Assert.assertTrue(b7);
Reporter.log(saveproduct);
//create quote



Actions actq=new Actions(driver);
actq.moveToElement(driver.findElement(By.xpath("//a[text()='Dashboard']/../../td[22]/a[@href='javascript:;']"))).perform();;

driver.findElement(By.xpath("//a[text()='Quotes']")).click();
driver.findElement(By.xpath("//img[contains(@src,'btnL3Add.gif')]")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(contactName);
Select sel=new Select(driver.findElement(By.xpath("//select[@name='carrier']")));
sel.selectByValue("BlueDart");

driver.findElement(By.xpath(".//*[@id='shipping']")).sendKeys(shipping);
driver.findElement(By.xpath("//*[@name='bill_street']")).sendKeys(bill_street);


driver.findElement(By.xpath("//input[contains(@onclick,'copyAddressRight')]")).click();


//driver.findElement(By.xpath(".//*[@id='searchIcon1']")).click();;


Select sel1=new Select(driver.findElement(By.xpath(".//*[@id='inventory_currency']")));
sel1.selectByVisibleText("India, Rupees (₨)");
Alert a2=driver.switchTo().alert();
a2.accept();

driver.findElement(By.xpath(".//*[@id='qty1']")).sendKeys(qty1);
driver.findElement(By.xpath(".//*[@id='listPrice1']")).sendKeys(listPrice1);
WebElement w1=driver.findElement(By.xpath(".//*[@id='shipping_handling_charge']"));
w1.clear();
w1.sendKeys(shipping_handling_charge);
Select sel2=new Select(driver.findElement(By.xpath(".//*[@id='adjustmentType']")));
sel2.selectByVisibleText("Add");
WebElement w2=driver.findElement(By.xpath(".//*[@id='adjustment']"));
w2.clear();
w2.sendKeys(adjustment);
Thread.sleep(2000);
//organization
driver.findElement(By.xpath("//tbody/tr[7]/td[4]/img")).click();

Set<String>set2=driver.getWindowHandles();
Iterator<String>it2=set2.iterator();
String parentwindow2=it2.next();
String childwindow2=it2.next();

driver.switchTo().window(childwindow2);
driver.findElement(By.xpath("//a[text()='"+accountname+"']")).click();
Alert alt2=driver.switchTo().alert();
alt2.accept();
driver.switchTo().window(parentwindow2);
//contact name
driver.findElement(By.xpath("//tbody/tr[5]/td[4]/img")).click();

Set<String>set4=driver.getWindowHandles();
Iterator<String>it4=set4.iterator();
String parentwindow4=it4.next();
String childwindow4=it4.next();

driver.switchTo().window(childwindow4);
driver.findElement(By.xpath("//a[text()='"+firstname+" "+lasttName+"']")).click();
Alert alt4=driver.switchTo().alert();
	alt4.accept();
 driver.switchTo().window(parentwindow4);
//product
driver.findElement(By.xpath("//img[@id='searchIcon1']")).click();
	
Set<String>set3=driver.getWindowHandles();
 Iterator<String>it5=set3.iterator();
 String parentwindow3=it5.next();
 String childwindow3=it5.next();
 
 driver.switchTo().window(childwindow3);
 
 driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
	
 driver.switchTo().window(parentwindow3);

driver.findElement(By.xpath("//tbody/tr[25]/td/div/input[@accesskey='S']")).click();
//veryfy
boolean b8=driver.findElement(By.xpath("//span[contains(text(),'"+contactName+"')]")).isDisplayed();
Assert.assertTrue(b8); 
Reporter.log(savequote);


		

	}}
	
	
	

