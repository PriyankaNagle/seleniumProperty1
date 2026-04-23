package practice.contactTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
import com.crm.objectRepositoryUtility.LoginPage;
import com.crm.objectRepositoryUtility.contactPage;
import com.crm.objectRepositoryUtility.createNewContactPage;
import com.crm.objectRepositoryUtility.createNewOrgnanizationPage;
import com.crm.objectRepositoryUtility.organizationPage;

public class createContactWithOrgTest {
	
		public static void main(String[] args) throws Exception {
			FileUtility flib=new FileUtility();
			ExcelUtility elib=new ExcelUtility();
			webDriveraUtility wlib=new webDriveraUtility();
			javaUtility jlib=new javaUtility();
			
			String BROWSER=flib.getDataFromPropertiesFile("browser");
			String URL=flib.getDataFromPropertiesFile("url");
			String USERNAME=flib.getDataFromPropertiesFile("username");
			String PASSWORD=flib.getDataFromPropertiesFile("password");
			
			
			
			String orgname=elib.getDataFromExcel("contact",7,2)+jlib.randomNumber();
			String contactLastName=elib.getDataFromExcel("contact",7,3)+jlib.randomNumber();
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
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			wlib.waitForUtility(driver);
			driver.get(URL);
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp(URL, USERNAME, PASSWORD);
			
			Homepage hm=new Homepage(driver);
			hm.getOrglink().click();
			
			organizationPage orp=new organizationPage(driver);
			orp.getCreateNewOrgBtn().click();
			
			createNewOrgnanizationPage cnop=new createNewOrgnanizationPage(driver);
			cnop.createOrg(orgname);
			
	/*		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			//navigate to organization module
			driver.findElement(By.linkText("Organizations")).click();
			
			//click on create organization button
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
			//step 4=enter all the details and create organization
			driver.findElement(By.name("accountname")).sendKeys(orgname);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();     */
			
			//verify header msg  expected result
			String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(header.contains(orgname)) {
				System.out.println(orgname + "is created==pass");
			}
			else {
				System.out.println(orgname + "is not created==fail");
				
				//step 5
			//hm.getContactLink().click();
			driver.findElement(By.linkText("Contacts")).click();	
			organizationPage cp=new organizationPage(driver);
			cp.getCreateNewcontactBtn().click();
			
			
				
			driver.findElement(By.name("lastname")).sendKeys(contactLastName);
			driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
			
			//switch to child window
			wlib.switchtoTabOnURL(driver,"module=Accounts" );
	/*		Set<String> handles = driver.getWindowHandles();
			Iterator<String> it = handles.iterator();
			while(it.hasNext()) {
				String windowID = it.next();
				driver.switchTo().window(windowID);
				
				
				String actualUrl = driver.getCurrentUrl();
				if(actualUrl.contains("module=Accounts")) {
					break;
				}
				
			}								*/
			
			
			
			driver.findElement(By.name("search_text")).sendKeys(orgname);
			driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			//switch to parent window
			wlib.switchtoTabOnURL(driver,"Contacts&action" );

	/*		Set<String> handles1 = driver.getWindowHandles();
			Iterator<String> it1 = handles.iterator();
			while(it.hasNext()) {
				String windowID = it1.next();
				driver.switchTo().window(windowID);
				
				
				String actualUrl = driver.getCurrentUrl();
				if(actualUrl.contains("Contacts&action")) {
					break;
				}
				
			}										*/
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			}
			
		
	}

}
