package seleniumwebdriver;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Search_quote_using_createFilters_editandcancel {
	public static void main(String[] args) throws Throwable {
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxBinary bin = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
		
		WebDriver driver= new FirefoxDriver(bin,profile);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		String str=driver.getTitle();
	//	System.out.println(str);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		
		
		String str1=driver.getTitle();
		String str2="vtiger CRM 5 - Commercial Open Source CRM";
		if(str1.equals(str2))
		{
			System.out.println("LOGIN_page Display");
		}
		else
		{
			System.out.println("LOGIN_page Not Display");
		}
		
		driver.findElement(By.id("submitButton")).click();
		
		
		
		
		String r1=driver.getCurrentUrl();
		//System.out.println(r1);
		String r2="http://localhost:8888/index.php?action=index&module=Home";
		if(r1.equals(r2))
		{
			System.out.println("Home page Display");
		}
		else
		{
			System.out.println("Home_page Not Display");
		}
		
		
		WebElement wb=driver.findElement(By.xpath("//a[text()='More']"));
		Actions act=new Actions(driver);
		act.moveToElement(wb).perform();
		driver.findElement(By.xpath("//a[text()='Quotes']")).click();
	
	
		String str4="Open Quotes";
		boolean flag=false;
		driver.findElement(By.id("viewname")).click();	
		WebElement wb2=driver.findElement(By.xpath("//select[@name='viewname']"));
		Select ver=new Select(wb2);
		List<WebElement> lst=ver.getOptions();
		//System.out.println(lst);
		for(int i=0;i<=lst.size();i++)
		{
			String str5=lst.get(i).getText();
			if(str4.equals(str5))
			{
				ver.selectByVisibleText(str4);
				flag=true;
				break;
			}
		}
		if(flag==true)
		{
			System.out.println("Open Quotes Available");
		}
		else
		{
			System.out.println("Open Quotes Not Available");
		}
		//ver.selectByIndex(3);
	
		
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
	
		String ram="Sub Total";
		boolean flag1=false;
	WebElement wb3=driver.findElement(By.xpath("//select[@name='column6']"));
		//Actions grn=new Actions(driver);
	Select grn1=new Select (wb3);
	//grn1.moveToElement(driver.findElement(By.xpath("//select[@name='column6']"))).perform();
	//grn1.selectByVisibleText("Sub Total");///////////////
	List<WebElement>fst=grn1.getOptions();
	for(int i=0;i<fst.size();i++)
	{
		String a=fst.get(i).getText();
		if(ram.equals(a))
		{
			grn1.selectByVisibleText(ram);
			flag1=true;
			break;
		}
	}
	if(flag1==true)
	{
		System.out.println("Sub Total is Available");
	}
	else
	{
		System.out.println("Sub Total is not Available");
	}

	driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	
	
	
	}

}
