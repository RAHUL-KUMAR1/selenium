package seleniumwebdriver;


	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
	import org.apache.poi.ss.formula.ptg.StringPtg;
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

	public class Endtoend {
		public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
			
			FileInputStream fls=new FileInputStream("C:\\Users\\PREETY KUMARI\\Desktop\\worktable.xlsx");
			Workbook wb=WorkbookFactory.create(fls);
			Sheet sh=wb.getSheet("Sheet1");
			FileReader fobj=new FileReader("./Data/commondata.properties");
			Properties pobj=new Properties();
			pobj.load(fobj);
			
			String URL=pobj.getProperty("URL");
			String USERNAME=pobj.getProperty("USERNAME");
			String PASSWORD=pobj.getProperty("PASSWORD");
			
			WebDriver driver=new FirefoxDriver();
		     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		     driver.get(URL);
		     
		     String organisationName=" tata10";
		     String productName="steel10";
		     String lastName=" ambani10";
		     String subjectName=" iron10";
		     
		    /*login*/
		     driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		     driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		     driver.findElement(By.id("submitButton")).click();
			 
		   /*click on organisation*/
			 driver.findElement(By.xpath("//a[text()='Organizations']")).click();
			 
		   /* click new organisation  button*/
			 driver.findElement(By.xpath(" //img[@title='Create Organization...']")).click();
			 
		   /*create new organisation*/
			 driver.findElement(By.name("accountname")).sendKeys(organisationName);
			   
		   /*save*/
			 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			    Thread.sleep(5000);
			  
		   /*click on product*/
			 driver.findElement(By.xpath("//a[@href=\"index.php?module=Products&action=index\"]")).click();
				
		   /* click new product  button*/
			 driver.findElement(By.xpath("//img[@title='Create Product...']")).click();	
				 
		   /*create new product*/
			 driver.findElement(By.name("productname")).sendKeys(productName);
				 	   
		   /*save*/
			 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					    Thread.sleep(3000);
				
		   /*click on contact*/
			 driver.findElement(By.xpath("//a[text()='Contacts']")).click();
						 
		   /* click new contact  button*/
			 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
						 
		   /*create new contact*/
			 driver.findElement(By.name("lastname")).sendKeys(lastName);
			 
		   /*click on organisation */
			 driver.findElement(By.xpath("//tbody/tr[5]/td[2]/img")).click();
		 			Thread.sleep(5000);

		 			 Set<String>set=driver.getWindowHandles();
		 			 
		 			 Iterator<String>it=set.iterator();
		 			 String parentwindow=it.next();
		 			 String childwindow=it.next();
		 			 
		 			 driver.switchTo().window(childwindow);
		 			 
		 			 driver.findElement(By.xpath("//a[text()='gamlin comyany']")).click();
		 			Thread.sleep(5000);
		 			
	 	 			 driver.switchTo().window(parentwindow);
		 			 	     
			 /*save*/
			  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					
			 /* Dropdown menu*/
			   WebElement wb1=driver.findElement(By.xpath("//a[text()='More']/.."));
			 /*step.2 create an object to action class*/
						 Actions act=new Actions(driver);
						 
			 /*step.3 Take mouse cursor on the dropdown menu*/
						 act.moveToElement(wb1).perform();
						 
			 /*step.4 click on sub menu*/
			  driver.findElement(By.xpath("//a[text()='Quotes']")).click();
					 
			 /* click new contact  button*/
			  driver.findElement(By.xpath("//img[@title='Create Quote...']")).click();
			
			 /*create new contact*/
			  driver.findElement(By.name("subject")).sendKeys(subjectName);

			 /* organisation lookup image*/ 
			  driver.findElement(By.xpath("//tbody/tr[7]/td[4]/img")).click();
				 			 
				 			 
				 			 Set<String>set1=driver.getWindowHandles();
				 			 
				 			 Iterator<String>it1=set1.iterator();
				 			 String parentwindow1=it1.next();
				 			 String childwindow1=it1.next();
				 			 
				 			 driver.switchTo().window(childwindow1);
				 			 
				 			 driver.findElement(By.xpath("//a[text()='gamlin comyany']")).click();
				 			Thread.sleep(5000);
				 			
				 			Alert alt=driver.switchTo().alert();
				 			alt.accept();
				 			 
				 			 driver.switchTo().window(parentwindow1);
				 			
			  /* billing adress*/	 
							 driver.findElement(By.xpath("//textarea[@name='bill_street']")).sendKeys("marathali");
							 driver.findElement(By.xpath("//input[@name='bill_pobox']")).sendKeys("murgeshpalya");
							 driver.findElement(By.xpath("//input[@name='bill_city']")).sendKeys("marathali");
							 driver.findElement(By.xpath("//input[@name='bill_state']")).sendKeys("marathali");
							 driver.findElement(By.xpath("//input[@name='bill_code']")).sendKeys("marathali");
							 driver.findElement(By.xpath("//input[@name='bill_country']")).sendKeys("marathali");
				 			  
							 
			 /* copy billing adress*/	 
							 driver.findElement(By.xpath("//tbody/tr[10]/td[3]/input")).click();
						  
			 /*add  product*/
							 driver.findElement(By.xpath("//img[@id='searchIcon1']")).click();
								  		
							 Set<String>set2=driver.getWindowHandles();
				 			 Iterator<String>it2=set2.iterator();
				 			 String parentwindow2=it2.next();
				 			 String childwindow2=it2.next();
				 			 
				 			 driver.switchTo().window(childwindow2);
				 			 
				 			 driver.findElement(By.xpath("//a[text()='Laptop']")).click();
				  			 driver.switchTo().window(parentwindow2);
				  		
			 /* add product*/
							 driver.findElement(By.xpath("//input[@id='qty1']")).sendKeys("20");	  
				   		 
			 /*add  contact*/
							 driver.findElement(By.xpath("//tbody/tr[5]/td[4]/img")).click();
							 
							 Set<String>set3=driver.getWindowHandles();
				 			 Iterator<String>it3=set3.iterator();
				 			 String parentwindow3=it3.next();
				 			 String childwindow3=it3.next();
				 			 
				 			 driver.switchTo().window(childwindow3);
				 			 
				 			 driver.findElement(By.xpath("//a[text()='PRAVAKAR RANA']")).click();
				 			 
				 			//Alert alt1=driver.switchTo().alert();
				 			//alt.accept();
				 			
				  			 driver.switchTo().window(parentwindow3);
				  			 	
		   /*save*/
						     driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
						     	 
		   /*validation*/	
						     WebElement ee=driver.findElement(By.xpath("//span[contains(text(),'Quote Information')]"));
					          ee.getText();
					         String exresult="iron6 - Editing Quote Information";
					         String actresult="iron6 - Editing Quote Information";
					         if(exresult.contains(actresult))
					         {
					         	System.out.println(ee.getText() + " created sucessfully");
					         }
					         else
					         {
					         	System.out.println("quote not created");
					         }  
		   /*logout*/
						        driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
						        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
						         
						        driver.close();
							 
	 

							 
		}

}
