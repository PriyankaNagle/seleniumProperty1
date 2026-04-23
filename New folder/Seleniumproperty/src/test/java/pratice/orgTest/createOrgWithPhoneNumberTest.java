package pratice.orgTest;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.GENERIC.FILE_UTILITY.ExcelUtility;
import com.crm.GENERIC.FILE_UTILITY.FileUtility;
import com.crm.GENERIC.WEBDRIVER_UTILITY.UtilityClassObject;
import com.crm.GENERIC.WEBDRIVER_UTILITY.javaUtility;
import com.crm.GENERIC.WEBDRIVER_UTILITY.webDriveraUtility;
import com.crm.objectRepositoryUtility.Homepage;
import com.crm.objectRepositoryUtility.OrganizationInfo;
import com.crm.objectRepositoryUtility.createNewOrgnanizationPage;
import com.crm.objectRepositoryUtility.organizationPage;


public class createOrgWithPhoneNumberTest extends baseClass {
	@Test
	public void createOrgWithPhoNumberTest() {
	
		//raed testsScript data from excel file.
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		String orgname = elib.getDataFromExcel("org",7,2)+jlib.randomNumber();
		String phoneNumber =elib.getDataFromExcel("org",7,2);
		
		//step 2:navigate to organizzation module
		UtilityClassObject.getTest().log(Status.INFO,"create a new org");
		Homepage hp=new Homepage(driver);
		hp.getOrglink().click();
		
		//step3  click on create organization button
		organizationPage or=new organizationPage(driver);
		or.getCreateNewOrgBtn().click();
		
	
		// step 4=enter all the details and create organization
		UtilityClassObject.getTest().log(Status.INFO,"create a new org with phone number");
		createNewOrgnanizationPage cnop=new createNewOrgnanizationPage(driver);
		cnop.createOrgPhoneNumber(orgname,PhoneNumber);
		
		//verify header phonenumber into expected result
		
		OrganizationInfo io=new OrganizationInfo(driver);UtilityClassObject.getTest().log(Status.INFO,"verify phone number");
		String actOrgName=io.getHeaderMsg().getText();
		Assert.assertEquals(true,actOrgName.contains(orgname));
	    String actualPhNum=io.getPhoneNumberEdt().getText();
		Assert.assertEquals(actualPhNum,PhoneNumber);
		UtilityClassObject.getTest().log(Status.PASS,actualPhNum+"===verify the pnoneNumber");
		//wlib.waitForUtility(driver);
		//driver.get(URL);

/*		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// navigate to organization module
		driver.findElement(By.linkText("Organizations")).click();

		// click on create organization button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// step 4=enter all the details and create organization
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.id("phone")).sendKeys(phoneNumber);	
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//verify phonenumber into expedted result
		String actualPhNum = driver.findElement(By.id("dtlview_Phone")).getText();
		if(actualPhNum.contains(phoneNumber)) {
			System.out.println(phoneNumber + " is created==pass");
		}
		else {
			System.out.println(phoneNumber + " is not created==fail");
		}

		

		driver.quit();*/
	}
	}


	


