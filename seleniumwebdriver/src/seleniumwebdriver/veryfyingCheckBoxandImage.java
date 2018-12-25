package seleniumwebdriver;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class veryfyingCheckBoxandImage {

	public static void main(String[] args) throws InterruptedException {
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxBinary bin = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
		
		WebDriver driver= new FirefoxDriver(bin,profile);
	driver.get("http://127.0.0.1/login.do");
	driver.manage().window().maximize();
	Thread.sleep(1000);
	
	WebElement checkbox=driver.findElement(By.xpath("//input[@name='remember']"));
	boolean b1=checkbox.isSelected();
	System.out.println(b1);
	boolean b2=checkbox.isEnabled();
	System.out.println(b2);
	WebElement img= driver.findElement(By.xpath("//img[contains(@src, 'timer.gif')]"));
	Point p =img.getLocation();
	System.out.println("x"+p.getX());
	System.out.println("y"+p.getY());
	Dimension d=img.getSize();
	System.out.println("height"+d.getHeight());
	System.out.println("weidth"+d.getWidth());
	driver.close();
	
	
	

	}

}
