package seleniumwebdriver;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

public class table {
	public static void main(String[] args) throws InterruptedException  {
		
		 String viewName="gdf";
		 String dw="yantra.com";
		 boolean flag=false;
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxBinary bin = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
		
		WebDriver driver= new FirefoxDriver(bin,profile);
		//driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
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
 
     List<WebElement> tr=driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]"));
    int rq= tr.size();
    System.out.println("length"+rq);
 String str;
 
     for(WebElement wb:tr) {
    	  str=wb.getText();
    
    	 if(str.equals(dw)) {
    		
    		 flag=true;
    		 break;
    	 }}
     if(flag==true) {
    	 System.out.println("present");}
     
    	 else {System.out.println("not present");

    	 }
  
    WebElement wr=driver.findElement(By.xpath(".//*[@id='massdelete']/table/tbody/tr[1]/td/table[1]/tbody/tr/td[1]"));
   String rt= wr.getText();
 
 rt= rt.substring ( rt.length()-1);
  System.out.println(rt);
  int a = Integer.parseInt(rt);
  System.out.println(a);
  
    
        //tr[@id='row_"+(a+9)+"']/td[2]/a/parent::td/following-sibling::td[5]/a[text()='edit']")).click();	
    	//tr[@id='row_12']/td[2]/a
    	int i;
    	for( i=8;i<=15;i++) {
    		String n= driver.findElement(By.xpath("//tr[@id='row_"+(a+i)+"']/td[2]/a")).getText();
    		String d="sd";
    		if(n.equals(d)) {
    		flag=true;
    		break;}}
    		if(flag==true) {
    			driver.findElement(By.xpath("//tr[@id='row_"+(a+i)+"']/td[2]/a/parent::td/following-sibling::td[5]/a[text()='edit']")).click();
    		}
    		else {System.out.println("not found");
    			
    		}
    		
    	
    		
    	}
	}
    	
    	
    	
    	
    	
    

