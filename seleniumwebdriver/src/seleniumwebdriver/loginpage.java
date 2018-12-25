package seleniumwebdriver;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class loginpage {
	public static void main(String[] args) throws InterruptedException {
		
		String OrganizationName="qspider";
		String website="www.qspider.com";
		String email2="yantra@gmail.com";
		String ticket="Qtp";
		String employees="500";
		String industry ="Education";
		String accounttype="Competitor";
		String phone="1234567890";
		String fax="3216549870";
		String otherphone="6541239870";
		String otheremail="qspider@gmail.com";
		String self="self";
		String rating="Acquired";
		String billaddress="bangalore";
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxBinary bin = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
		
		WebDriver driver= new FirefoxDriver(bin,profile);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	driver.get("http://localhost:8888/index.php");
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
    driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("manager");
    driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
    
    driver.findElement(By.xpath("//a[text()='Organizations']")).click();
    driver.findElement(By.xpath("//img[contains(@src,'btnL3Add.gif')]")).click();
    driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(OrganizationName);
    driver.findElement(By.xpath("//input[@name='website']")).sendKeys(website);
    driver.findElement(By.xpath("//input[@name='tickersymbol']")).sendKeys(ticket);
   /* driver.findElement(By.xpath("//img[contains(@alt,'Select')]")).click();
   //handle new window
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
             driver.switchTo().defaultContent(); //cntrl to parent window
              }
           }
       Thread.sleep(1000);*/
    driver.findElement(By.xpath("//input[@id='employees']")).sendKeys(employees);
    driver.findElement(By.xpath("//input[@id='email2']")).sendKeys(email2);
  // Select s1=new Select( driver.findElement(By.xpath("//select[@name='industry']")));
  // s1.selectByVisibleText(industry);
  // Select s2=new Select(driver.findElement(By.xpath("Select s1=new Select")));
 //  s2.deselectByVisibleText(accounttype);
   // checkbox
   boolean b1=driver.findElement(By.xpath("//input[@name='emailoptout']")).isSelected();
   if(b1==false) {driver.findElement(By.xpath("//input[@name='emailoptout']")).click();}
   driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phone);
   driver.findElement(By.xpath("//input[@id='fax']")).sendKeys(fax);
   driver.findElement(By.xpath("//input[@id='otherphone']")).sendKeys(otherphone);
   driver.findElement(By.xpath("//input[@id='email1']")).sendKeys(otheremail);
   driver.findElement(By.xpath("//input[@id='ownership']")).sendKeys(self);
   Select s3=new Select(driver.findElement(By.xpath("//select[@name='rating']")));
   s3.selectByVisibleText(rating);
   boolean b2=driver.findElement(By.xpath("//input[@name='notify_owner']")).isSelected();
   if(b2==false) {driver.findElement(By.xpath("//input[@name='notify_owner']")).click();
   driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys(billaddress);
   
   boolean b3=driver.findElement(By.xpath("//input[@onclick='return copyAddressRight(EditView)']")).isSelected();
   if(b3==false) {driver.findElement(By.xpath("//input[@onclick='return copyAddressRight(EditView)']")).click();
// verify that the “Save button” is displayed and enabled
   boolean saveIconPresence = driver.findElement(By.xpath("//input[@accesskey='S']")).isDisplayed();
   boolean saveIconEnabled = driver.findElement(By.xpath("//input[@accesskey='S']")).isEnabled();

  // click on the save button
   if (saveIconPresence==true && saveIconEnabled==true) {
    WebElement saveIcon = driver.findElement(By.xpath("//input[@accesskey='S']"));
          saveIcon.click();
          
          
          
          
          WebElement deleteIcon = driver.findElement(By.xpath("//input[@accesskey='D']"));
          deleteIcon.click() ;
          Alert a1=driver.switchTo().alert();
          a1.accept();
          driver.close();     
          
   }
   
   
   
   }}}}
   
   
	


