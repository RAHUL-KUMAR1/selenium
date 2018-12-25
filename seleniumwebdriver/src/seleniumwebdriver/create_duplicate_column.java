package seleniumwebdriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class create_duplicate_column {
	public static void main(String[] args) throws InterruptedException  {
	
		 String ViewName="abc";
		 String errormsg="Columns cannot be duplicated";
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxBinary bin = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
		
		WebDriver driver= new FirefoxDriver(bin,profile);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	driver.get("http://localhost:8888/index.php");
	driver.manage().window().maximize();
	
	
	//veryfying login title
	String title1=driver.getTitle();
	System.out.println(title1);
	
	String actualtitle="vtiger CRM 5 - Commercial Open Source CRM";
	if(title1.equals(actualtitle)) {System.out.println("title is pass==>");}
	else {System.out.println("title is fail==>");}
	
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
    driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("manager");
    driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
  
    
    //verifying adminstrative page
    String title2=driver.getTitle();
	System.out.println(title2);
	String actualtitle3="Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
	if(title2.equals(actualtitle3)) {System.out.println("title is pass==>");}
	else {System.out.println("title is fail==>");}
	driver.findElement(By.xpath("//img[contains(@src,'vtiger-crm-logo')]"));
    Actions act=new Actions(driver);
    act.moveToElement(driver.findElement(By.xpath("//a[text()='Dashboard']/../../td[22]/a[@href='javascript:;']"))).perform();;
    driver.findElement(By.xpath("//a[text()='Invoice']")).click();
   
   
    //verifying invoice page
    String title3=driver.getTitle();
	System.out.println(title3);
	String actualtitle4="Administrator - Invoice - vtiger CRM 5 - Commercial Open Source CRM";
	if(title3.equals(actualtitle4)) {System.out.println("title is pass==>");}
	else {System.out.println("title is fail==>");}
	
   
    driver.findElement(By.xpath("//img[@alt='Search in Invoice...']")).click();
    driver.findElement(By.xpath("//a[text()='Create Filter']")).click();
    driver.findElement(By.xpath("//input[@name='viewName']")).sendKeys(ViewName);
    Select sl=new Select(driver.findElement(By.xpath("//select[@id='column1']")));
   sl.selectByVisibleText("Sales Order");
    Select s2=new Select(driver.findElement(By.xpath("//select[@id='column2']")));
    s2.selectByVisibleText("Sales Order");
    Thread.sleep(1000);
  String str1=driver.switchTo().alert().getText();
  Alert alert=driver.switchTo().alert();
 alert.accept();
  //verifying through alert massage column is not created duplicate
  
	 if(str1.equals(errormsg)) { System.out.println(str1+"<==This Error massage verify that column can not create duplicate");;}
	 else {System.out.println("duplicate is created");}
	 
	
 
driver.quit();
    

}}
