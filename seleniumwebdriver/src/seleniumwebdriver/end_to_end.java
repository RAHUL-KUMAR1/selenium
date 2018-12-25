package seleniumwebdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class end_to_end {
	@Test
	public static void main() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream fls=new FileInputStream("C:\\Users\\PREETY KUMARI\\Desktop\\worktable.xlsx");
		Workbook wb=WorkbookFactory.create(fls);
		Sheet sh=wb.getSheet("Sheet1");
	
			String username=sh.getRow(0).getCell(1).getStringCellValue();
			String pwd=sh.getRow(0).getCell(2).getStringCellValue();
			String contactName=sh.getRow(1).getCell(1).getStringCellValue();
			String contactName1=sh.getRow(1).getCell(1).getStringCellValue();
			String phone=sh.getRow(2).getCell(1).getStringCellValue();
			String mobile=sh.getRow(3).getCell(1).getStringCellValue();
			String homephone=sh.getRow(4).getCell(1).getStringCellValue();
			String otherphone=sh.getRow(5).getCell(1).getStringCellValue();
			String fax=sh.getRow(6).getCell(1).getStringCellValue();
			String secondaryemail=sh.getRow(7).getCell(1).getStringCellValue();
			String mailingstreet=sh.getRow(8).getCell(1).getStringCellValue();
			String mailingcity=sh.getRow(9).getCell(1).getStringCellValue();
			String mailingpobox=sh.getRow(10).getCell(1).getStringCellValue();
			String mailingstate=sh.getRow(11).getCell(1).getStringCellValue();
			String mailingzip=sh.getRow(12).getCell(1).getStringCellValue();
			String mailingcountry=sh.getRow(13).getCell(1).getStringCellValue();
			String description=sh.getRow(14).getCell(1).getStringCellValue();
		
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxBinary bin = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
		
		WebDriver driver= new FirefoxDriver(bin,profile);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	driver.get("http://localhost:8888/index.php");
	driver.manage().window().maximize();

	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pwd);
	driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
	driver.findElement(By.xpath("//table[2]/tbody/tr/td[2]/table/tbody/tr/td[8]")).click();
	driver.findElement(By.xpath("//img[contains(@src,'btnL3Add.gif')]")).click();
	Select se=new Select(driver.findElement(By.xpath("//select[@name='salutationtype']")));
	se.selectByValue("Mr.");
	driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(contactName1);
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(contactName);
	Select s2=new Select(driver.findElement(By.xpath("//select[@name='leadsource']")));
	s2.selectByValue("Employee");
	
	driver.findElement(By.xpath("//input[@id='title']")).sendKeys(contactName);
	driver.findElement(By.xpath("//input[@id='department']")).sendKeys(contactName);
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys(contactName);
	driver.findElement(By.xpath("//input[@id='assistant']")).sendKeys(contactName);
	driver.findElement(By.xpath("//input[@id='assistantphone']")).sendKeys(contactName);
	driver.findElement(By.xpath("//input[@name='emailoptout']")).click();
	driver.findElement(By.xpath("//input[@name='reference']")).click();
	driver.findElement(By.xpath("//input[@name='notify_owner']")).click();
	driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phone);;
	driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys(mobile);
	driver.findElement(By.xpath("//input[@id='homephone']")).sendKeys(homephone);
	driver.findElement(By.xpath("//input[@id='otherphone']")).sendKeys(otherphone);
	driver.findElement(By.xpath("//input[@id='fax']")).sendKeys(fax);
	driver.findElement(By.xpath("//input[@id='secondaryemail']")).sendKeys(secondaryemail);
	driver.findElement(By.xpath("//input[@name='donotcall']")).click();
	driver.findElement(By.xpath("//input[@name='portal']")).click();
	driver.findElement(By.xpath("//textarea[@name='mailingstreet']")).sendKeys(mailingstreet);
	driver.findElement(By.xpath("//input[@id='mailingpobox']")).sendKeys(mailingpobox);
	driver.findElement(By.xpath("//input[@id='mailingcity']")).sendKeys(mailingcity);
	driver.findElement(By.xpath("//input[@id='mailingstate']")).sendKeys(mailingstate);
	driver.findElement(By.xpath("//input[@id='mailingzip']")).sendKeys(mailingzip);
	driver.findElement(By.xpath("//input[@id='mailingcountry']")).sendKeys(mailingcountry);
	driver.findElement(By.xpath("//textarea[@name='mailingstreet']")).sendKeys(mailingstreet);
	driver.findElement(By.xpath("//input[contains(@onclick,'copyAddressRight')]")).click();
	driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(description);
	driver.navigate().back();}
	@Test
	public static void main2() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		FileInputStream fls=new FileInputStream("C:\\Users\\PREETY KUMARI\\Desktop\\worktable.xlsx");
		Workbook wb=WorkbookFactory.create(fls);
		Sheet sh=wb.getSheet("Sheet1");
		String username=sh.getRow(0).getCell(1).getStringCellValue();
		String pwd=sh.getRow(0).getCell(2).getStringCellValue();
		String contactName=sh.getRow(18).getCell(1).getStringCellValue();
		String shipping=sh.getRow(19).getCell(1).getStringCellValue();
		String bill_code=sh.getRow(20).getCell(1).getStringCellValue();
		String bill_city=sh.getRow(21).getCell(1).getStringCellValue();
		String bill_country=sh.getRow(22).getCell(1).getStringCellValue();
		String bill_pobox=sh.getRow(23).getCell(1).getStringCellValue();
		String bill_state=sh.getRow(24).getCell(1).getStringCellValue();
		String bill_street=sh.getRow(25).getCell(1).getStringCellValue();
		String adjustment=sh.getRow(26).getCell(1).getStringCellValue();
		String listPrice1=sh.getRow(27).getCell(1).getStringCellValue();
		String shipping_handling_charge=sh.getRow(28).getCell(1).getStringCellValue();
		String qty1=sh.getRow(29).getCell(1).getStringCellValue();
		String mailingzip=sh.getRow(23).getCell(1).getStringCellValue();
		String mailingcountry=sh.getRow(21).getCell(1).getStringCellValue();
		String description=sh.getRow(21).getCell(1).getStringCellValue();
	
		
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxBinary bin = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
		
		WebDriver driver= new FirefoxDriver(bin,profile);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	driver.get("http://localhost:8888/index.php");
	driver.manage().window().maximize();

	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pwd);
	driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	Actions act=new Actions(driver);
    act.moveToElement(driver.findElement(By.xpath("//a[text()='Dashboard']/../../td[22]/a[@href='javascript:;']"))).perform();;
    
    driver.findElement(By.xpath("//a[text()='Quotes']")).click();
    driver.findElement(By.xpath("//img[contains(@src,'btnL3Add.gif')]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(contactName);
    Select s1=new Select(driver.findElement(By.xpath("//select[@name='carrier']")));
    s1.selectByValue("BlueDart");
    
	driver.findElement(By.xpath("//input[@id='shipping']")).sendKeys(shipping);
	driver.findElement(By.xpath("//input[@name='bill_street']")).sendKeys(bill_street);
	driver.findElement(By.xpath("//input[@id='bill_pobox']")).sendKeys(bill_pobox);
	driver.findElement(By.xpath("//input[@id='bill_city']")).sendKeys(bill_city);
	driver.findElement(By.xpath("//input[@id='bill_state']")).sendKeys(bill_state);
	driver.findElement(By.xpath("//input[@id='bill_code']")).sendKeys(bill_code);
	driver.findElement(By.xpath("//input[@id='bill_country']")).sendKeys(bill_country);
	
	driver.findElement(By.xpath("//input[contains(@onclick,'copyAddressRight')]")).click();
	driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(description);
	
	//driver.findElement(By.xpath(".//*[@id='searchIcon1']")).click();;
	
	
	Select s2=new Select(driver.findElement(By.xpath(".//*[@id='inventory_currency']")));
	s2.selectByVisibleText("India, Rupees (₨)");
	Alert a2=driver.switchTo().alert();
    a2.accept();
	
	driver.findElement(By.xpath("//input[@id='qty1']")).sendKeys(qty1);
	driver.findElement(By.xpath("//input[@id='listPrice1']")).sendKeys(listPrice1);
	WebElement w1=driver.findElement(By.xpath(".//*[@id='shipping_handling_charge']"));
			w1.clear();
	w1.sendKeys(shipping_handling_charge);
	Select s3=new Select(driver.findElement(By.xpath(".//*[@id='adjustmentType']")));
	s3.selectByVisibleText("Add");
	WebElement w2=driver.findElement(By.xpath(".//*[@id='adjustment']"));
	w2.clear();
	w2.sendKeys(adjustment);
	driver.navigate().back();}
	
	@test
public static void main3() throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		FileInputStream fls=new FileInputStream("C:\\Users\\PREETY KUMARI\\Desktop\\worktable.xlsx");
		Workbook wb=WorkbookFactory.create(fls);
		Sheet sh=wb.getSheet("Sheet1");
	
		String username=sh.getRow(0).getCell(1).getStringCellValue();
		String pwd=sh.getRow(0).getCell(2).getStringCellValue();
			String productName=sh.getRow(1).getCell(1).getStringCellValue();
			String contactName=sh.getRow(1).getCell(1).getStringCellValue();
			String accountname=sh.getRow(2).getCell(1).getStringCellValue();
			String billcode=sh.getRow(3).getCell(1).getStringCellValue();
			String billcity=sh.getRow(4).getCell(1).getStringCellValue();
			String billcountry=sh.getRow(5).getCell(1).getStringCellValue();
			String fax=sh.getRow(6).getCell(1).getStringCellValue();
			String billpobox=sh.getRow(7).getCell(1).getStringCellValue();
			String bill_street=sh.getRow(8).getCell(1).getStringCellValue();
			String billstate=sh.getRow(9).getCell(1).getStringCellValue();
			String employees=sh.getRow(10).getCell(1).getStringCellValue();
			String tickersymbol=sh.getRow(11).getCell(1).getStringCellValue();
			String phone=sh.getRow(12).getCell(1).getStringCellValue();
			String otherphone=sh.getRow(13).getCell(1).getStringCellValue();
			String website=sh.getRow(14).getCell(1).getStringCellValue();
			String ownership=sh.getRow(14).getCell(1).getStringCellValue();
			String biil_street=sh.getRow(14).getCell(1).getStringCellValue();
			String description=sh.getRow(14).getCell(1).getStringCellValue();
			String annualrevenue=sh.getRow(14).getCell(1).getStringCellValue();
			String email2=sh.getRow(14).getCell(1).getStringCellValue();
			String email1=sh.getRow(14).getCell(1).getStringCellValue();
	
		
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
driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(accountname);
driver.findElement(By.xpath("//input[@name='website']")).sendKeys(website);
driver.findElement(By.xpath("//input[@id='tickersymbol']")).sendKeys(tickersymbol);
driver.findElement(By.xpath("//input[@id='employees']")).sendKeys(employees);
driver.findElement(By.xpath("//input[@id='email2']")).sendKeys(email2);
Select s1=new Select(driver.findElement(By.xpath("//select[@name='industry']")));
s1.deselectByValue("Banking");
Select s2=new Select(driver.findElement(By.xpath("//select[@name='accounttype']")));
s2.selectByValue("Customer");
driver.findElement(By.xpath("//input[@name='emailoptout']")).click();
driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phone);
driver.findElement(By.xpath("//input[@id='fax']")).sendKeys(fax);
driver.findElement(By.xpath("//input[@id='otherphone']")).sendKeys(otherphone);
driver.findElement(By.xpath("//input[@id='email1']")).sendKeys(email1);
driver.findElement(By.xpath("//input[@id='ownership']")).sendKeys(ownership);
Select s3=new Select(driver.findElement(By.xpath("//select[@name='rating']")));
s3.selectByValue("Acquired");
WebElement w1=driver.findElement(By.xpath("//input[@name='annual_revenue']"));
w1.clear();
w1.sendKeys(annualrevenue);
driver.findElement(By.xpath("//input[@name='notify_owner']")).click();
driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys(biil_street);
driver.findElement(By.xpath("//input[@id='bill_pobox']")).sendKeys(billpobox);
driver.findElement(By.xpath("//input[@id='bill_city']")).sendKeys(billcity);
driver.findElement(By.xpath("//input[@id='bill_state']")).sendKeys(billstate);
driver.findElement(By.xpath("//input[@id='bill_code']")).sendKeys(billcode);
driver.findElement(By.xpath("//input[@id='bill_country']")).sendKeys(billcountry);
driver.findElement(By.xpath("//input[contains(@onclick,'copyAddressRight')]")).click();
driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(description);



}}
