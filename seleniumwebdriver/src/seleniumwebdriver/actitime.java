package seleniumwebdriver;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
public class actitime {

	public static void main(String[] args) throws InterruptedException {
		
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxBinary bin = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
		
		WebDriver driver= new FirefoxDriver(bin,profile);
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1/login.do;jsessionid=7d1hb4hecl0b");
		Thread.sleep(10000);
		String acthomepage= driver.getTitle();
		System.out.println(acthomepage);
		String str="actiTIME - Login";
				if (acthomepage.equals(str)) {
					System.out.println("pass-login page");
				}
				else {System.out.println("fail-login page");}
				driver.findElement(By.xpath(".//*[@id='loginFormContainer']/tbody/tr[1]/td/table/tbody/tr[1]/td[2]/input")).sendKeys("admin");
				driver.findElement(By.xpath(".//*[@id='loginFormContainer']/tbody/tr[1]/td/table/tbody/tr[2]/td[2]/input")).sendKeys("manager");
				driver.findElement(By.xpath("//*[@id='loginButton']")).click();
				Thread.sleep(5000);
				String acthomepage1=driver.getTitle();
				System.out.println(acthomepage1);
				String str2="actiTIME - Enter Time-Track";
				if (acthomepage1.equals(str2)) {
					System.out.println("pass homepage");
				}else {System.out.println("fail homepage");}
				
				driver.findElement(By.xpath(".//*[@id='topnav']/tbody/tr[1]/td[5]/a/img")).click();
				driver.findElement(By.xpath(".//*[@id='filterForm']/table/tbody/tr[1]/td/table/tbody/tr/td[2]/table/tbody/tr/td/input")).click();
				driver.findElement(By.xpath(".//*[@id='container']/form[1]/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[4]/td/table/tbody/tr[2]/td[4]/select")).click();
				driver.findElement(By.xpath(".//*[@id='logoutLink']")).click();
				Thread.sleep(5000);
				
		driver.quit();
	}

}
