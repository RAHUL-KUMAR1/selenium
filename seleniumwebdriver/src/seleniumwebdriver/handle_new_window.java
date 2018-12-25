package seleniumwebdriver;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

public class handle_new_window {
	public static void main(String[] args) throws InterruptedException  {
		
		 String viewName="abc";
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxBinary bin = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
		
		WebDriver driver= new FirefoxDriver(bin,profile);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	driver.get("http://localhost:8888/index.php");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
    driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("manager");
    driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//img[contains(@src,'vtiger-crm-logo')]"));
    Actions act=new Actions(driver);
    act.moveToElement(driver.findElement(By.xpath("//a[text()='Dashboard']/../../td[22]/a[@href='javascript:;']"))).perform();;
    
    driver.findElement(By.xpath("//a[text()='Invoice']")).click();
    driver.findElement(By.xpath("//img[contains(@src,'btnL3Add.gif')]")).click();
    driver.findElement(By.xpath("//img[contains(@onclick,'selectContact')]")).click();
    Thread.sleep(2000);
    String parentWindow = driver.getWindowHandle();
    Set<String> handles =  driver.getWindowHandles();
       for(String windowHandle  : handles)
           {
           if(!windowHandle.equals(parentWindow))
              {
              driver.switchTo().window(windowHandle);
              Thread.sleep(2000);
              driver.findElement(By.xpath("//a[@id='1']")).click();
              Alert alert=driver.switchTo().alert();
              Thread.sleep(1000);
               alert.accept();

             driver.close(); //closing child window
             driver.switchTo().window(parentWindow); //cntrl to parent window
              }
           }
    
    
    
    
    
  /*  
     driver.getWindowHandle();
   
    System.out.println("hello");
    driver.findElement(By.xpath("//a[@id='1']")).click();
    Alert alert=driver.switchTo().alert();
   
    alert.accept();*/

}}
