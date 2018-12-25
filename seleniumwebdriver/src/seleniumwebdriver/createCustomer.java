package seleniumwebdriver;
/*
 * author Rahul Kumar
 */

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class createCustomer {
	static String userName1="admin";
	static String password="manager";
	static String customer="ICICI11";
	static String sucessmsg="Customer "+customer+" has been successfully created.";

	public static void main(String[] args) throws InterruptedException {
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxBinary bin = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
		
		WebDriver driver= new FirefoxDriver(bin,profile);
	driver.get("http://127.0.0.1/login.do");
	driver.manage().window().maximize();
	Thread.sleep(1000);
	
	/*     login page title checking**/
	String title1=driver.getTitle();
	System.out.println(title1);
	String actualtitle="actiTIME - Login";
	if(title1.equals(actualtitle)) {System.out.println("title is pass==>");}
	else {System.out.println("title is fail==>");}
	
	/* checkbox verying isenable or isselected**/
	WebElement checkbox=driver.findElement(By.xpath("//input[@name='remember']"));
	boolean b1=checkbox.isSelected();
	System.out.println(b1);
	boolean b2=checkbox.isEnabled();
	System.out.println(b2);
	
	/*   actitime img checking dimension and location**/
	WebElement img= driver.findElement(By.xpath("//img[contains(@src, 'timer.gif')]"));
	Point p =img.getLocation();
	System.out.println("x"+p.getX());
	System.out.println("y"+p.getY());
	Dimension d=img.getSize();
	System.out.println("height"+d.getHeight());
	System.out.println("weidth"+d.getWidth());
	
	/* veryfying error msg in username and color of error msg***/
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("mmm");
	driver.findElement(By.xpath("//a[@id='loginButton']")).click();
	 WebElement actError= driver.findElement(By.xpath("//span[text()='Username or Password is invalid. Please try again.']"));
	    String s=actError.getText();
	    System.out.println(s);
		String findError="Username or Password is invalid. Please try again.";
		if(s.equals(findError)) {System.out.println("user Error==.pass");}
		else {System.out.println("user Error fail");}
		
		String str=actError.getCssValue("color");
		String str2="rgba(206, 1, 0, 1)";
		System.out.println(str);
		if (str.equals(str2)) { System.out.println("Error color is pass==>");}
		else {System.out.println("Error color is fail==>");}
		
		/*login using correct username and password***/
		driver.findElement(By.xpath("//*[@name='username']")).clear();
		Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@name='username']")).sendKeys(userName1);
	driver.findElement(By.xpath("//*[@name='pwd']")).sendKeys(password);
	driver.findElement(By.xpath("//*[@id='loginButton']")).click();
	Thread.sleep(2000);
	/* homepage title checking***/
	String homepage=driver.getTitle();
	System.out.println(homepage);
	String act="actiTIME - Enter Time-Track";
	if (homepage.equals(act)) {System.out.println("home page pass==>");}
	else {System.out.println("homepage is fail==>");}
	
	/* creating customer*/
	
	driver.findElement(By.xpath("//*[.='Tasks']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[text()='Projects & Customers']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@value='Create New Customer']")).click();
	driver.findElement(By.xpath("//*[@name='name']")).sendKeys(customer);
	driver.findElement(By.xpath("//*[@value='Create Customer']")).click();
	Thread.sleep(2000);
	/* checking sucess mesg**/
	WebElement sucessmsg= driver.findElement(By.xpath("//span[@class='successmsg']"));
	String su=sucessmsg.getText();
	System.out.println(su);
	if (su.equals(sucessmsg)) {System.out.println("message pass==>");}
	else {System.out.println("message fail==>");}
	Thread.sleep(1000);
	driver.findElement(By.xpath(".//a[@id='logoutLink']")).click();
	
	
	
	
	driver.quit();
	
	}

}
