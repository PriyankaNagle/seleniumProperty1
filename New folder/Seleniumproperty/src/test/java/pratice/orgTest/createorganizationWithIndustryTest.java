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
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.GENERIC.FILE_UTILITY.ExcelUtility;
import com.crm.GENERIC.FILE_UTILITY.FileUtility;
import com.crm.GENERIC.WEBDRIVER_UTILITY.javaUtility;
import com.crm.GENERIC.WEBDRIVER_UTILITY.webDriveraUtility;
import com.crm.baseTest.baseClass;

public class createorganizationWithIndustryTest extends baseClass {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		javaUtility jlib=new javaUtility();
		webDriveraUtility wlib=new webDriveraUtility();
		

		FileInputStream fis = new FileInputStream("./configurationData/commonData2.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");

		// generate Random number
		Random random = new Random();
		int randomInt = random.nextInt(1000);

		//FileInputStream fis1 = new FileInputStream("./configurationData/Book4.xlsx");
		//Workbook wb = WorkbookFactory.create(fis1);
		//Sheet sh = wb.getSheet("org");
		//Row rw = sh.getRow(4);
		//String orgname = rw.getCell(2).toString() + randomInt;
		//String industry = rw.getCell(3).toString();
		//String type = rw.getCell(4).toString();
		//wb.close();
		//System.out.println(orgname+" I:"+industry+" T:"+type);
		
		
		WebDriver driver = null;

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();

		}

		// step1 =login to app
		wlib.waitForUtility(driver);
		driver.get(URL);

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// navigate to organization module
		driver.findElement(By.linkText("Organizations")).click();

		// click on create organization button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// step 4=enter all the details and create organization
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		Select sel = new Select(driver.findElement(By.name("industry")));
		sel.selectByValue(industry);
		Select sel1 = new Select(driver.findElement(By.name("accounttype")));
		sel1.selectByValue(type);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// verify the dropdownindustry and type
		String actIndustryName = driver.findElement(By.id("dtlview_Industry")).getText();
		if (actIndustryName.contains(industry)) {
			System.out.println(industry + "  is verified==pass");
		} else {
			System.out.println(industry + " is not verified==fail");
		}

		String actType = driver.findElement(By.id("dtlview_Type")).getText();
		if (actType.contains(type)) {
			System.out.println(type + "  is verified==pass");
		} else {
			System.out.println(type + "  is not verified==fail");
		}

		driver.quit();
	}

}
