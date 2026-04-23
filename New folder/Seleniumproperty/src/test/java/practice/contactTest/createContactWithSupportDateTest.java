package practice.contactTest;

import java.io.FileInputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.GENERIC.FILE_UTILITY.ExcelUtility;
import com.crm.GENERIC.FILE_UTILITY.FileUtility;
import com.crm.GENERIC.WEBDRIVER_UTILITY.javaUtility;
import com.crm.GENERIC.WEBDRIVER_UTILITY.webDriveraUtility;
import com.crm.objectRepositoryUtility.Homepage;
import com.crm.objectRepositoryUtility.contactPage;

public class createContactWithSupportDateTest {
public static void main(String[] args) throws Exception {
	FileUtility flib=new FileUtility();
	ExcelUtility elib=new ExcelUtility();
	javaUtility jlib=new javaUtility();
	webDriveraUtility wlib=new webDriveraUtility();
	
	
	String BROWSER=flib.getDataFromPropertiesFile("browser");
	String URL=flib.getDataFromPropertiesFile("url");
	String USERNAME=flib.getDataFromPropertiesFile("username");
	String PASSWORD=flib.getDataFromPropertiesFile("password");
	//generate Random number
	String LastName=elib.getDataFromExcel("contact",4,2)+jlib.randomNumber();
	
		WebDriver driver=null;
		
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();}
			else if(BROWSER.equals("firefox")) {
				driver=new FirefoxDriver();}
			else if(BROWSER.equals("edge")) {
				driver=new EdgeDriver();
			}
			else {
				driver=new ChromeDriver();
			
			}
		
		//step1 =login to app
		wlib.waitForUtility(driver);
		
		Homepage hm = new Homepage(driver);
		hm.getContactLink().click();
		
		contactPage cp = new contactPage(driver);
		cp.getCreateNewcontactBtn().click();
		
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		
		//navigate to organization module
		//driver.findElement(By.linkText("Contacts")).click();
		
		//click on create organization button
		//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//step 4=enter all the details and create organization
		//driver.findElement(By.name("lastname")).sendKeys(LastName);
		
	/*	Date dateobj=new Date(0);
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String actDate = sim.format(dateobj);
		System.out.println(actDate);
	
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,30);
		String reqDate = sim.format(cal.getTime());
		System.out.println(reqDate);								*/
		
		String actDate=jlib.getSystemDateYYYYDDMM(); 
		String reqDate=jlib.getRequiredDateYYYYDDMM(30);
		
		
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys("actDate");
		
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys("reqDate");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
		
		String actualStrtDate= driver.findElement(By.name("support_start_date")).getText();
		
		
		
		if(actualStrtDate.contains(actDate)) {
			System.out.println(actDate + " is created==pass");
		}
		else {
			System.out.println(actDate + " is not created==fail");
		}
		
		String actualEndDate= driver.findElement(By.name("support_end_date")).getText();
		if(actualEndDate.contains(reqDate)) {
			System.out.println(reqDate + " is created==pass");
		}
		else {
			System.out.println(reqDate + " is not created==fail");
		}
					driver.quit();
	}

	

}
