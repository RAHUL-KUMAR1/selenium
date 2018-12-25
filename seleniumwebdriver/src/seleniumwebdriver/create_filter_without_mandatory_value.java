package seleniumwebdriver;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class create_filter_without_mandatory_value {


	public static void main(String[] args) throws InterruptedException {
		String viewName="lion";
		String viewName2="qspider";
		String a="Organization Name *";
				String b="Subject *";
						String c="Billing Address *";
								String d="Assigned To *";
										String e="Shipping Address *";
												String f="Customer No";
														String g="Invoice No";
																String h="Contact Name";
																		String i="Status";
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxBinary bin = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
		
		WebDriver driver= new FirefoxDriver(bin,profile);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	driver.get("http://localhost:8888/index.php");
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
    driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("manager");
    driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
   
    driver.findElement(By.xpath("//img[contains(@src,'vtiger-crm-logo')]"));
 
    Actions act=new Actions(driver);
    act.moveToElement(driver.findElement(By.xpath("//a[text()='Dashboard']/../../td[22]/a[@href='javascript:;']"))).perform();;
    
    driver.findElement(By.xpath("//a[text()='Invoice']")).click();
  
    driver.findElement(By.xpath("//img[contains(@src,'btnL3Search.gif')]")).click();
   
    //create a new filter
    driver.findElement(By.xpath("//a[text()='Create Filter']")).click();
    
    driver.findElement(By.xpath("//input[@name='viewName']")).sendKeys(viewName);
   Select sl1=new Select(driver.findElement(By.xpath("//select[@id='column1']")));
   sl1.selectByVisibleText(a);
   
                     try {Alert a2=driver.switchTo().alert();
                          a2.accept();}
                     catch(Throwable z) {}
   Select sl2=new Select(driver.findElement(By.xpath("//select[@id='column2']")));
   sl2.selectByVisibleText(b);
      
                     try {Alert a2=driver.switchTo().alert();
                           a2.accept();}
                     catch(Throwable z) {}
 
   Select sl3=new Select(driver.findElement(By.xpath("//select[@id='column3']")));
   sl3.selectByVisibleText(c);
  
                     try {Alert a2=driver.switchTo().alert();
                         a2.accept();}
                     catch(Throwable z) {}
    	
   Select sl4=new Select(driver.findElement(By.xpath("//select[@id='column4']")));
   sl4.selectByVisibleText(d);
  
                     try {Alert a2=driver.switchTo().alert();
                         a2.accept();}
                     catch(Throwable z) {}
   	
  Select sl5=new Select(driver.findElement(By.xpath("//select[@id='column5']")));
  sl5.selectByVisibleText(e);
 
	                 try {Alert a2=driver.switchTo().alert();
	                       a2.accept();}
	                 catch(Throwable z) {}
	    	
  Select sl6=new Select(driver.findElement(By.xpath("//select[@id='column6']")));
  sl6.selectByVisibleText(f);
  
                    try {Alert a2=driver.switchTo().alert();
                         a2.accept();}
                    catch(Throwable z) {}
    	

  Select sl7=new Select(driver.findElement(By.xpath("//select[@id='column7']")));
  sl7.selectByVisibleText(g);
 
                    try {Alert a2=driver.switchTo().alert();
                         a2.accept();}
                    catch(Throwable z) {}
        	
   
  Select sl8=new Select(driver.findElement(By.xpath("//select[@id='column8']")));
  sl8.selectByVisibleText(h);
  
                  try {Alert a2=driver.switchTo().alert();
                          a2.accept();}
                  catch(Throwable z) {}
    	
 Select sl9=new Select(driver.findElement(By.xpath("//select[@id='column9']")));
 sl9.selectByVisibleText(i);

	              try {Alert a2=driver.switchTo().alert();
	                     a2.accept();}
	              catch(Throwable z) {}
	  
	
	

	    	
  
       driver.findElement(By.xpath("//input[@accesskey='S']")).click();
    
    //check filter is created or not

    Select sl=new Select(driver.findElement(By.xpath("//select[@id='viewname']")));
    WebElement sr=sl.getFirstSelectedOption();
   String wd=sr.getText();
    
    if (wd.equals(viewName)) {
    	System.out.println(viewName+"==>new filter is created sucessfuly");
    }
    else{System.out.println("filter is not created");}
    //verifying filter column
    WebElement w1=driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[1]/td[2]"));
    String s1=w1.getText();
   
    if(a.contains(s1)) {System.out.println("match created first column");}
    else {System.out.println("first column not match");}
    
    WebElement w2=driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[1]/td[3]"));
    String s2=w2.getText();
  
    if(b.contains(s2)) {System.out.println("match created second column");}
    else {System.out.println("second column not match");}
    
    WebElement w3=driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[1]/td[4]"));
    String s3=w3.getText();
  
    if(c.contains(s3)) {System.out.println("match created third column");}
    else {System.out.println("third column not match");}
    
    WebElement w4=driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[1]/td[5]"));
    String s4=w4.getText();
    if(d.contains(s4)) {System.out.println("match created forth column");}
    else {System.out.println("forth column not match");}
    
    WebElement w5=driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[1]/td[6]"));
    String s5=w5.getText();
    if(e.contains(s5)) {System.out.println("match created fifth column");}
    else {System.out.println("fifth column not match");}
    
    WebElement w6=driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[1]/td[7]"));
    String s6=w6.getText();
    if(f.contains(s6)) {System.out.println("match created sixth column");}
    else {System.out.println("sixth column not match");}
    
    WebElement w7=driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[1]/td[8]"));
    String s7=w7.getText();
    if(g.contains(s7)) {System.out.println("match created seventh column");}
    else {System.out.println("seventh column not match");}
   
    WebElement w8=driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[1]/td[9]"));
    String s8=w8.getText();
    if(h.contains(s8)) {System.out.println("match created eighth column");}
    else {System.out.println("eighth column not match");}
    
    WebElement w9=driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[1]/td[10]"));
    String s9=w9.getText();
    if(i.contains(s9)) {System.out.println("match ninth column");}
    else {System.out.println("ninth column not match");}
   
    driver.findElement(By.xpath("//a[text()='Delete']")).click();
    Alert aq=driver.switchTo().alert();
    aq.accept();
        
   driver.close();
   
    }}	   
       
    
    
    
    
	
	
	



