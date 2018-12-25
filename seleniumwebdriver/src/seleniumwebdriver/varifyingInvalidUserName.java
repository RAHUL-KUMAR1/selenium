package seleniumwebdriver;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class varifyingInvalidUserName {
	static String username="mmm";

	public static void main(String[] args) throws InterruptedException {
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxBinary bin = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
		
		WebDriver driver= new FirefoxDriver(bin,profile);
	driver.get("http://127.0.0.1/login.do");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//*[@name='username']")).sendKeys(username);
	driver.findElement(By.xpath("//*[@id='loginButton']")).click();
	Thread.sleep(1000);
    WebElement actError= driver.findElement(By.xpath("//span[.='Username or Password is invalid. Please try again.']"));
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
	
	driver.close();
	driver.quit();
	
	

	}
	}
