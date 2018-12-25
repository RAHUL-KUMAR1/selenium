package seleniumwebdriver;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class delete_the_invoice_filter {
	

		public static void main(String[] args) throws InterruptedException  {
			String viewName="tiger";
			boolean flag=false;
		 
			FirefoxProfile profile = new FirefoxProfile();
			FirefoxBinary bin = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
			
			WebDriver driver= new FirefoxDriver(bin,profile);
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/index.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	    driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("manager");
	    driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
	   
	    driver.findElement(By.xpath("//img[contains(@src,'vtiger-crm-logo')]"));
	 
	    Actions act=new Actions(driver);
	    act.moveToElement(driver.findElement(By.xpath("//a[text()='Dashboard']/../../td[22]/a[@href='javascript:;']"))).perform();;
	    
	    driver.findElement(By.xpath("//a[text()='Invoice']")).click();
	
	    driver.findElement(By.xpath("//img[@alt='Search in Invoice...']")).click();
	    driver.findElement(By.xpath("//a[text()='Create Filter']")).click();
	    //create a new filter
	    driver.findElement(By.xpath("//input[@name='viewName']")).sendKeys("tiger");
	    driver.findElement(By.xpath("//input[@accesskey='S']")).click();
	    
	    //check filter is created or not

	    Select sl=new Select(driver.findElement(By.xpath("//select[@id='viewname']")));
	    WebElement sr=sl.getFirstSelectedOption();
	   String wd=sr.getText();
	    System.out.println(wd+"==>is present in list");
	    //verifying filter is present in list
	    if (wd.equals(viewName)) {
	    	System.out.println(viewName+"==>new filter is created sucessfuly");
	    }
	    else{System.out.println("filter is not created");}
	    
	    
	    
	    //deleting the created filter
	    Select sl1=new Select(driver.findElement(By.xpath("//select[@id='viewname']")));
	    sl1.selectByVisibleText(viewName);
	    
	    driver.findElement(By.xpath("//a[text()='Delete']")).click();
	   //handling the alert
	    Alert alert = driver.switchTo().alert();
	    Thread.sleep(1000);
	    String alert1=alert.getText();
	    System.out.println(alert1+"<===confermation massage");
       alert.accept();
       //verifying the filter should be deleted 
       Select select = new Select(driver.findElement(By.xpath("//select[@id='viewname']")));  

       List<WebElement> options = select.getOptions();
      
        for (int i=0; i<options.size(); i++){
        	 String we=options.get(i).getText();
            if (we.equals(viewName))
            flag=true;
             break ;
            } 
        if(flag==true) {System.out.println("filter is created");}
        else {System.out.println("filter is deleted sucessfuly");}
        driver.close();}
		
}
