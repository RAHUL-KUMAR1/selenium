package seleniumwebdriver;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class A {

	public static void main(String[] args) throws InterruptedException{
	
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxBinary bin = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
		
		WebDriver driver= new FirefoxDriver(bin,profile);
		driver.manage().window().maximize();
driver.get("https://amazon.com");
Thread.sleep(10000);
String acthomepage= driver.getTitle();
System.out.println(acthomepage);
String actual="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
if(acthomepage.equals(actual)) { System.out.println("login page is varified==>pass");}
	else {System.out.println("login page is ==>fail");}
driver.findElement(By.xpath("//*[@id='nav-link-accountList']")).click();
Thread.sleep(1000);
String signpage=driver.getTitle();
System.out.println(signpage);
String actual1="Amazon Sign In";
if(signpage.equals(actual1)) {System.out.println("pass");}
else {System.out.println("fail");}

driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys("6200488242");
driver.findElement(By.xpath("//*[@id='ap_password']")).sendKeys("rehan786");
driver.findElement(By.xpath("//*[@id='signInSubmit']")).click();
Thread.sleep(1000);
String pagetitle1=driver.getTitle();
System.out.println(pagetitle1);
String actual2="Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
if(pagetitle1.equals(actual2)) {System.out.println("pass2");}
else {System.out.println("fail2");}
driver.quit();}}
