package seleniumwebdriver;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class create_default_filter_in_invoice {
	public static void main(String[] args) throws InterruptedException  {
		
		 String viewName="abc";
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxBinary bin = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
		
		WebDriver driver= new FirefoxDriver(bin,profile);
	driver.get("http://localhost:8888/index.php");
	driver.manage().window().maximize();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
    driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("manager");
    driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//img[contains(@src,'vtiger-crm-logo')]"));
 
    Actions act=new Actions(driver);
    act.moveToElement(driver.findElement(By.xpath("//a[text()='Dashboard']/../../td[22]/a[@href='javascript:;']"))).perform();;
    
    driver.findElement(By.xpath("//a[text()='Invoice']")).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("//img[@alt='Search in Invoice...']")).click();
    driver.findElement(By.xpath("//a[text()='Create Filter']")).click();
    driver.findElement(By.xpath("//input[@name='viewName']")).sendKeys(viewName);
    //verify and select check box
    WebElement setdefault=driver.findElement(By.xpath("//input[@name='setDefault']"));
    if(setdefault.isSelected()) {System.out.println("check box is selected");}
    else {setdefault.click();}
    
    
	//verify textbox and checkbox before submitting
	WebElement textbox=driver.findElement(By.xpath("//input[@name='viewName']"));
	String textbox1=textbox.getText();
	if(textbox1.equals(viewName)) {
		System.out.println("text box created");}
	
	else{System.out.println("text box not created");}
	 WebElement setdefault1=driver.findElement(By.xpath("//input[@name='setDefault']"));
	    if(setdefault1.isSelected()) {System.out.println("check box is selected");}
	    else { System.out.println("check box not selected");}
	
	//verify save button is present or not
	WebElement saveButton=driver.findElement(By.xpath("//input[@value='Save']"));
	String savebutton1=saveButton.getText();
	System.out.println(savebutton1);
	Thread.sleep(3000);
	
	// verify that the “Save button” is displayed and enabled
    boolean saveIconPresence = driver.findElement(By.xpath("//input[@accesskey='S']")).isDisplayed();
    boolean saveIconEnabled = driver.findElement(By.xpath("//input[@accesskey='S']")).isEnabled();
 
   // click on the save button
    if (saveIconPresence==true && saveIconEnabled==true) {
     WebElement saveIcon = driver.findElement(By.xpath("//input[@accesskey='S']"));
           saveIcon.click();
           System.out.println("save button sucessfuly working");}
    else {System.out.println("save button not present");}
    Thread.sleep(3000);
    
    //verify default is created or not
   
    Select sl=new Select(driver.findElement(By.xpath("//select[@id='viewname']")));
    WebElement sr=sl.getFirstSelectedOption();
   String wd=sr.getText();
    System.out.println(wd);
    if (wd.equals(viewName)) {
    	System.out.println(viewName+"==>defalut is created sucessfuly");
    }
    else{System.out.println("default not created");}
    driver.close();
}}
