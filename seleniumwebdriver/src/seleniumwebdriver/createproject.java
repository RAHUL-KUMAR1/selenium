package seleniumwebdriver;

import java.io.File;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class createproject {
	 static Random num=new Random();
	 static String cusname="ICICI"+num.nextInt(10);
	static boolean flag=false;
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
	driver.findElement(By.xpath("//input[@value='Create New Project']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//select[@name='customerId']")).click();
	Select se=new Select(driver.findElement(By.xpath("//select[@name='customerId']")));
	List <WebElement> eb=se.getOptions();
      System.out.println(eb.size());
      for(int i=0;i<eb.size();i++) {
    	  String str=eb.get(i).getText();
    	 
    	  if(str.equals(cusname)) { 
    		  se.selectByVisibleText(str);
    		  
    		  flag=true;
    		  System.out.println(cusname+"===>already present");
    		  se.selectByVisibleText(cusname);
    		  se.getFirstSelectedOption();
    		  Thread.sleep(6000);
    		  break;}}
  	
		driver.findElement(By.xpath("//select[@name='customerId']"));
		Thread.sleep(5000);
		 se.selectByVisibleText(cusname);
		 Thread.sleep(3000);
		 
 	 Random num1=new Random();
 	 String cusname2="ICICI_project"+num.nextInt(10);
 
      driver.findElement(By.xpath("//input[@name='name']")).sendKeys(cusname2);
      Thread.sleep(3000);
      driver.findElement(By.xpath("//input[@name='createProjectSubmit']")).submit();
      Thread.sleep(3000);
      WebElement actError= driver.findElement(By.xpath("//span[text()='Customer:']"));
      String str5=actError.getCssValue("color");
		String str10="rgba(206, 1, 0, 1)";
		
		 driver.findElement(By.xpath(".//*[@id='logoutLink']")).submit();
	
}}
