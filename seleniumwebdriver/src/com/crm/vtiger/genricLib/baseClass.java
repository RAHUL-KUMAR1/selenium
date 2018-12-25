package com.crm.vtiger.genricLib;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.crm.vtiger.objectRepositoryLib.homePage;
import com.crm.vtiger.objectRepositoryLib.loginPage;

public class baseClass {

		public static WebDriver driver;
		public fileutil flib=new fileutil();
 @BeforeClass
 public void configBC() throws IOException {
	    System.out.println("===LaunchBrawser===");
	    Properties pobj=flib.getpropertiesfileobject();
	    String browserName=pobj.getProperty("browser");
	 if (browserName.equals("chrome")) {
		 System.setProperty("WebDriver.chrome.driver","./chromedriver.exe");
		 driver=new ChromeDriver();
	 }
	 else if (browserName.equals("firefox")) {
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxBinary bin = new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe"));
		driver= new FirefoxDriver(bin,profile);
			 
	 }
	 else if (browserName.equals("IE")) {
		 System.setProperty("WebDriver.IE.driver","./IEDriverServer.exe");
		 driver=new InternetExplorerDriver();
	 }
	     driver.manage().window().maximize();
	     
	     driver.manage().timeouts().implicitlyWait(5 , TimeUnit.SECONDS);
}
	@BeforeMethod
	public void configbm() throws IOException, InvalidFormatException {
		System.out.println("===Login==");
		
 		Properties pobj=flib.getpropertiesfileobject();
		String URL=pobj.getProperty("URL");
		driver.get(URL);
		
		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		lp.loginToApp(pobj.getProperty("USERNAME"),pobj.getProperty("PASSWORD"));
		
	}
		
@AfterMethod
public void configAM() {
	    System.out.println("logout");
	    homePage signout=PageFactory.initElements(driver,homePage.class);
		signout.navigateToSignOut();
		homePage logout=PageFactory.initElements(driver,homePage.class);
		logout.selectSignOut();
	
	   
}
@AfterClass
public void configAC() {
	   System.out.println("=====closeBrowser======");
	   driver.close();
}    
	}


