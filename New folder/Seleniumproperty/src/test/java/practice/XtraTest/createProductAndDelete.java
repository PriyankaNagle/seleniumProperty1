package practice.XtraTest;

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
import com.crm.objectRepositoryUtility.createNewOrgnanizationPage;
import com.crm.objectRepositoryUtility.organizationPage;

public class createProductAndDelete {
	public static void main(String[] args) throws Exception {
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		javaUtility jlib=new javaUtility();
		webDriveraUtility wlib=new webDriveraUtility();
		
		String BROWSER=flib.getDataFromPropertiesFile("browser");
		String URL=flib.getDataFromPropertiesFile("url");
		String USERNAME=flib.getDataFromPropertiesFile("username");
		String PASSWORD=flib.getDataFromPropertiesFile("password");
		
		String productName=elib.getDataFromExcel("org",1,2)+jlib.randomNumber();
		
		
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
		wlib.waitForUtility(driver);
		driver.get(URL);
		
		//step1=Login to app
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp("admin","admin");
		
		//step2=Navigate to product link
		Homepage hm=new Homepage(driver);
		hm.productLink();
		
		//step3=click on  create new campaignbutton.
		organizationPage or=new organizationPage(driver);
		or.getCreateNewProductBtn().click();
		
		//step4=enter vthe details in page and save.
				createNewOrgnanizationPage cop=new createNewOrgnanizationPage(driver);
				cop.productnameEdt(productName);
				cop.deleteProdkey();
				driver.quit();
		

}
}