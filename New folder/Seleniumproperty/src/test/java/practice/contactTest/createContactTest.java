package practice.contactTest;

import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.math3.stat.regression.RegressionResults;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.GENERIC.FILE_UTILITY.ExcelUtility;
import com.crm.GENERIC.FILE_UTILITY.FileUtility;
import com.crm.GENERIC.WEBDRIVER_UTILITY.UtilityClassObject;
import com.crm.GENERIC.WEBDRIVER_UTILITY.javaUtility;
import com.crm.GENERIC.WEBDRIVER_UTILITY.webDriveraUtility;
import com.crm.baseTest.baseClass;
import com.crm.listenerUtility.listenerImplementation;
import com.crm.objectRepositoryUtility.Homepage;
import com.crm.objectRepositoryUtility.OrganizationInfo;
import com.crm.objectRepositoryUtility.contactPage;
import com.crm.objectRepositoryUtility.createNewContactPage;
import com.crm.objectRepositoryUtility.createNewOrgnanizationPage;
import com.crm.objectRepositoryUtility.organizationPage;

public class createContactTest extends baseClass {
	
	@Test(groups = "smokeTest")
	public void CreateContactTest() throws Exception {
		
		UtilityClassObject.getTest().log(Status.INFO,"Read data from excel");

		// FileInputStream fis=new
		// FileInputStream("./configurationData/commonData2.properties");
		// Properties pro=new Properties();
		// pro.load(fis);

		//for baseclass		String BROWSER=flib.getDataFromPropertiesFile("browser");
		//for baseclass			String URL=flib.getDataFromPropertiesFile("url");
		//for baseclass			String USERNAME=flib.getDataFromPropertiesFile("username");
		//for baseclass			String PASSWORD=flib.getDataFromPropertiesFile("password");

		/*
		 * //generate Random number Random random=new Random(); int
		 * randomInt=random.nextInt(1000);
		 */
		/*
		 * FileInputStream fis1 =new FileInputStream("./configurationData/Book4.xlsx");
		 * Workbook wb = WorkbookFactory.create(fis1); Sheet sh =
		 * wb.getSheet("contact"); Row rw = sh.getRow(1); String LastName =
		 * rw.getCell(2).toString()+randomInt; wb.close();
		 * 
		 */

		String LastName = elib.getDataFromExcel("contact", 1, 2) + jlib.randomNumber();

		// for baseclass WebDriver driver=null;

		// for baseclass if(BROWSER.equals("chrome")) {
		// for baseclass driver=new ChromeDriver();}
		// for baseclass else if(BROWSER.equals("firefox")) {
		// for baseclass driver=new FirefoxDriver();}
		// for baseclass else if(BROWSER.equals("edge")) {
		// for baseclass driver=new EdgeDriver();
		// for baseclass }
		// for baseclass else {
		// for baseclass driver=new ChromeDriver();

		// for baseclass }

		// step1 =login to app
		// driver.manage().timouts().implicitlyWait(Duration.ofSeconds(20));
		// step2-navigate to contact module
		UtilityClassObject.getTest().log(Status.INFO,"navigate To contact page");
		Homepage hm = new Homepage(driver);
		hm.getContactLink().click();

		//step 3=create contact page
		UtilityClassObject.getTest().log(Status.INFO,"navigate to create contactpage");
		contactPage cp = new contactPage(driver);
		cp.getCreateNewcontactBtn().click();

		// step 4=enter all the details and create organization
		UtilityClassObject.getTest().log(Status.INFO,"create org");		
		createNewContactPage cncp = new createNewContactPage(driver);
		cncp.lastnameEdt(LastName);

		// verifying header contact number into expected result.
		String actualLastname = cp.getHeaderMsg().getText();
/*		if (actualLastname.contains(LastName)) {
			System.out.println(LastName + " is created==pass");
		} else {
			System.out.println(LastName + " is not created==fail");
		}								*/
		boolean status=actualLastname.contains(LastName);
		Assert.assertEquals(status, true);
		
		//String actLastName=driver.findElement(By.id("dtlview_Last Name")).getText();
		SoftAssert assertObj=new SoftAssert();
		assertObj.assertEquals(actualLastname,LastName);
	}

	@Test(groups = "smokeTest")
	public void createcontactWithSupportDateTest() throws EncryptedDocumentException, IOException {
		String LastName=elib.getDataFromExcel("contact",4,2)+jlib.randomNumber();
		wlib.waitForUtility(driver);
		
		Homepage hm = new Homepage(driver);
		hm.getContactLink().click();
		
		contactPage cp = new contactPage(driver);
		cp.getCreateNewcontactBtn().click();
		
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
		
	}
	
	@Test
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException {
		String orgname=elib.getDataFromExcel("contact", 7, 2)+jlib.randomNumber();
		String contactLastName=elib.getDataFromExcel("contact", 7, 3)+jlib.randomNumber();

		Homepage hm=new Homepage(driver);
		hm.getOrglink().click();
		
		organizationPage orp=new organizationPage(driver);
		orp.getCreateNewOrgBtn().click();
		
		createNewOrgnanizationPage cnop=new createNewOrgnanizationPage(driver);
		cnop.createOrg(orgname);
		
		OrganizationInfo oi=new OrganizationInfo(driver);
		String actOrgName=oi.getHeaderMsg().getText();
		
		if(actOrgName.contains(orgname)) {
			System.out.println(orgname + "is created==pass");
		}
		else {
			System.out.println(orgname + "is not created==fail");
			
		
		hm.getContactLink().click();
		organizationPage cp=new organizationPage(driver);
		cp.getCreateNewOrgBtn().click();
		
		
		driver.findElement(By.linkText("Contacts")).click();	
		driver.findElement(By.name("lastname")).sendKeys(contactLastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		wlib.switchtoTabOnURL(driver,"module=Accounts" );
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//switch to parent window
		wlib.switchtoTabOnURL(driver,"Contacts&action" );
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	}}}



