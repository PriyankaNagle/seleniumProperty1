package com.crm.listenerUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.GENERIC.WEBDRIVER_UTILITY.UtilityClassObject;
import com.crm.baseTest.baseClass;

public class listenerImplementation implements ITestListener,ISuiteListener{
	public static ExtentTest test;
	public static ExtentReports report;
	
	
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		String time=new Date().toString().replace(" ","_").replace(":","_");

		//sparkReportconfig
		ExtentSparkReporter  spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("Testsuite Results");
		spark.config().setReportName("CRM report");
		spark.config().setTheme(Theme.STANDARD);

	//add envrnment info and create Test.
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os","windows" );
		report.setSystemInfo("browser","chrome" );
		
		}
	
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		report.flush();
		}
	
	public void onTestStart(ITestResult result) {
		System.out.println("======="+result.getMethod().getMethodName()+"=====START=====");
		test=report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO,result.getMethod().getMethodName()+"======Started======");
		}
	public void onTestSuccess(ITestResult result) {
		System.out.println("======="+result.getMethod().getMethodName()+"=====END=====");
		test.log(Status.PASS,result.getMethod().getMethodName()+"======completed======");
		}
	
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Random r=new Random();
		int ran=r.nextInt(100);
		
		TakesScreenshot ts=(TakesScreenshot)baseClass.sdriver;
		File fpath = ts.getScreenshotAs(OutputType.FILE);
		
		String time=new Date().toString().replace(" ","_").replace(":","_");
		test.addScreenCaptureFromBase64String(testName+"_"+time);
		test.log(Status.FAIL,result.getMethod().getMethodName()+"======Failed======");
		}
	
	public void onTestSkipped(ITestResult result) {
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
	public void onStart(ITestContext context) {
	}
	
	public void onFinish(ITestContext context) {
		
	}

}
