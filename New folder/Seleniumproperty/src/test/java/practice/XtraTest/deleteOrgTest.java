package practice.XtraTest;

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
import com.crm.objectRepositoryUtility.LoginPage;

public class deleteOrgTest {
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
		String orgname=elib.getDataFromExcel("org",1,2)+jlib.randomNumber();
		
		
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
		driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp("admin","admin");
		
		Homepage hm=new Homepage(driver);
		hm.getOrglink().click();
		driver.findElement(By.xpath("//a[text()=" + orgname + "]/ancestor::tr[@id='row_3']/child::td[@width='2%']")).click();
		driver.findElement(By.className("crmbutton small delete")).click();
		
		Alert alrt=driver.switchTo().alert();
		alrt.accept();
		
		driver.quit();
		
		

}
}
