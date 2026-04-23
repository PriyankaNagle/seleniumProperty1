package PRACTICE_TEST;





import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReportTestExample {
	public ExtentSparkReporter spark;
	public ExtentReports report;
	
	@BeforeSuite
	public void configBS() {
		//sparkReportconfig
				ExtentSparkReporter  spark=new ExtentSparkReporter("./AdvanceReport/report.html");
				spark.config().setDocumentTitle("Testsuite Results");
				spark.config().setReportName("CRM report");
				spark.config().setTheme(Theme.STANDARD);

			//add envrnment info and create Test.
				 report=new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("os","windows" );
				report.setSystemInfo("browser","chrome" );
			}
	
		@AfterSuite
		public void configAS() {
			report.flush();
		}
	
		@Test
		public void reportTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		
		//takescreenShot ==commenting becaise we are not going to write the prog here.
		
//		TakesScreenshot ts=(TakesScreenshot)driver;
//      String fpath = ts.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test=report.createTest("reportTest");
		test.log(Status.INFO, "Login to test");
		test.log(Status.INFO, "Navigate to contact page");
		test.log(Status.INFO, "create contact");
		if("HDFC".equals("hhnh")) {
			test.log(Status.PASS, "contact is created");	
		}
		else {
			//test.log(Status.FAIL, "contact is not created");	
			//test.addScreenCaptureFromBase64String(fpath,"errorFile");
		}
		
		driver.close();
		
	}

}
