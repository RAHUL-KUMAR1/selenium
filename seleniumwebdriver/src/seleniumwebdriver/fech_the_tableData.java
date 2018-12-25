package seleniumwebdriver;

import java.io.File;
import java.sql.Driver;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class fech_the_tableData {
	static String newcustomer="ICICI61";
static boolean flag=false;
 
static String customer="ICICI";

	public static void main(String[] args) throws InterruptedException {
		
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxBinary bin = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
		
		WebDriver driver= new FirefoxDriver(bin,profile);
	driver.get("http://127.0.0.1/login.do");
	driver.manage().window().maximize();
	Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@name='username']")).sendKeys("admin");
    driver.findElement(By.xpath("//*[@name='pwd']")).sendKeys("manager");
    driver.findElement(By.xpath("//*[@id='loginButton']")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//*[.='Tasks']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[text()='Projects & Customers']")).click();
	Thread.sleep(3000);
	Select se=new Select(driver.findElement(By.xpath("//select[@name='selectedCustomer']")));
	List <WebElement> eb=se.getOptions();
      System.out.println(eb.size());
      String str=new String();
      for(int i=0;i<eb.size();i++) {
    	  str=eb.get(i).getText();
    	 
    	  if(str.equals(customer)) { 
    		  se.selectByVisibleText(str);
    		  flag=true;
    		  System.out.println(customer+"===>already present");
    		  break;}}
            
      driver.findElement(By.xpath("//input[@value='Create New Customer']")).click();
      try {  int i=0;
    			while(i< 20) {
    				 Random num=new Random();
        			 String cusname=customer+num.nextInt(15);
        			
        			 driver.findElement(By.xpath("//*[@name='name']")).clear();Thread.sleep(1000);
    				driver.findElement(By.xpath("//*[@name='name']")).sendKeys(cusname);
        	    	driver.findElement(By.xpath("//*[@value='Create Customer']")).click();
        	    	Thread.sleep(3000);
        	   
    				WebElement actError= driver.findElement(By.xpath("//span[text()='Customer Name:']")); i++;}
        	       }
        	    catch(Exception ex) {
        	    
        	    	WebElement actError1= driver.findElement(By.xpath(".//*[@id='SuccessMessages']/tbody/tr/td/span"));
        	    	
        	       }
        	   
      driver.findElement(By.xpath(".//*[@id='logoutLink']")).click();
        Thread.sleep(3000);
       driver.quit();
        			
    	
  		    	}} 
    
    	  
    	    
    	    
    	  
      
      
      
      
     
	



