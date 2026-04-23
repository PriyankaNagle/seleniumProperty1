package practice.XtraTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.GENERIC.FILE_UTILITY.ExcelUtility;
import com.crm.GENERIC.FILE_UTILITY.FileUtility;
import com.crm.GENERIC.WEBDRIVER_UTILITY.javaUtility;
import com.crm.GENERIC.WEBDRIVER_UTILITY.webDriveraUtility;
import com.crm.objectRepositoryUtility.LoginPage;

public class QuickCreateEdt {
	public static void main(String[] args) throws Exception {
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		javaUtility jlib=new javaUtility();
		webDriveraUtility wlib=new webDriveraUtility();
		
		String BROWSER=flib.getDataFromPropertiesFile("browser");
		String URL=flib.getDataFromPropertiesFile("url");
		String USERNAME=flib.getDataFromPropertiesFile("username");
		String PASSWORD=flib.getDataFromPropertiesFile("password");
	

		
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
		String headerinfo=elib.getDataFromExcel("org",1,2)+jlib.randomNumber();
		
		
		//step1=Login to app
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp("admin","admin");
		
		//step2=navigate to create new dropdown
		WebElement createNewDD = driver.findElement(By.id("qccombo"));
		Select sel=new Select(createNewDD);
		sel.selectByVisibleText("New Document");
		driver.findElement(By.name("notes_title")).sendKeys("hcdhc");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actualheaderinfo = driver.findElement(By.id("dvHeaderText")).getText();
		if(actualheaderinfo.contains(headerinfo)) {
			System.out.println(headerinfo + " is created==pass");
		}
		else {
			System.out.println(headerinfo + " is not created==fail");
		}


}
}