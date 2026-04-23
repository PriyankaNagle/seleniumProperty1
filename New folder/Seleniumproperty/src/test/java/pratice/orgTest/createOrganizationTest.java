package pratice.orgTest;


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
import com.crm.baseTest.baseClass;
import com.crm.objectRepositoryUtility.Homepage;
import com.crm.objectRepositoryUtility.LoginPage;
import com.crm.objectRepositoryUtility.OrganizationInfo;
import com.crm.objectRepositoryUtility.createNewOrgnanizationPage;
import com.crm.objectRepositoryUtility.organizationPage;

public class createOrganizationTest extends baseClass {

 @Test(groups = "smokeTest")
 public void createOrgTest() throws Throwable {
	 
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		//Read testScript data from excel file
		String orgname=elib.getDataFromExcel("org",1,2)+jlib.randomNumber();
		
		//step1 =login to app
		 wlib.waitForUtility(driver);
		//driver.get(URL);
		
		//LoginPage lp = new LoginPage(driver);
		//lp.loginToApp(URL,USERNAME,PASSWORD);
	/*		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//step2-navigate to organization module
		 driver.findElement(By.linkText("Organizations")).click();
		
		//step 3=click on create organization button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//step 4=enter all the details and create organization
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verify header msg  expected result
		String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(header.contains(orgname)) {
			System.out.println(orgname + "is created==pass");
		}
		else {
			System.out.println(orgname + "is not created==fail");
			
			String actualOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
				if(actualOrgName.contains(orgname)) {
					System.out.println( + " is correct==pass");
					}
				else {
					System.out.println(orgname + " is not correct==fail");
		}												*/
		
		//step 2=navigate to organization module
		 UtilityClassObject.getTest().log(Status.INFO,"navigate to org page");
		Homepage hm=new Homepage(driver);
		hm.getOrglink().click();
		
		//step 3=click on create organization button
		 UtilityClassObject.getTest().log(Status.INFO,"navigate to create org page");
		organizationPage or=new organizationPage(driver);
		or.getCreateNewOrgBtn().click();
		
		//step 4=enter all the details and create organization
		 UtilityClassObject.getTest().log(Status.INFO,"navigate to new org");
		createNewOrgnanizationPage cnop=new createNewOrgnanizationPage(driver);
		cnop.createOrg(orgname);
		
		//step 5=verify header info.
		 UtilityClassObject.getTest().log(Status.INFO,"=======>>create a new org");
		OrganizationInfo oi=new OrganizationInfo(driver);
		String actOrgName=oi.getHeaderMsg().getText();
		Assert.assertEquals(true,actOrgName.contains(orgname));
 }
		
		@Test(groups = "regressionTest")
		public void createOrgWithPhoneNumberTest() throws Throwable{
		
			//raed testsScript data from excel file.
			UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
			String orgname = elib.getDataFromExcel("org",7,2)+jlib.randomNumber();
			String phoneNumber =elib.getDataFromExcel("org",7,3);
			
			//step 2:navigate to organizzation module
			UtilityClassObject.getTest().log(Status.INFO,"create a new org");
			Homepage hp=new Homepage(driver);
			hp.getOrglink().click();
			
			//step3  click on create organization button
			organizationPage or=new organizationPage(driver);
			or.getCreateNewOrgBtn().click();
			System.out.println();
			
		
			// step 4=enter all the details and create organization
			UtilityClassObject.getTest().log(Status.INFO,"create a new org with phone number");
			createNewOrgnanizationPage cnop=new createNewOrgnanizationPage(driver);
			cnop.createOrgPhoneNumber(orgname,phoneNumber);
			
			//verify header phonenumber into expected result
			
			OrganizationInfo io=new OrganizationInfo(driver);UtilityClassObject.getTest().log(Status.INFO,"verify phone number");
			String actOrgName=io.getHeaderMsg().getText();
			Assert.assertEquals(true,actOrgName.contains(orgname));
			String actualPhNum=io.getPhoneNumberEdt().getText();
			Assert.assertEquals(actualPhNum,phoneNumber);
			UtilityClassObject.getTest().log(Status.PASS,actualPhNum+"===verify the pnoneNumber");
		
		hp.LogOut();
		
		driver.quit();
	}
	}





	