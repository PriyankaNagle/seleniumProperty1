package practice_AssertHomepage;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class homepageVerification {
	

	@Test
	public void homepageTest(Method mtd) {
		System.out.println(mtd.getName()+"Test start");
		String expectedPage="Home page";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		String actualTitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
	//	if(actualTitle.trim().contains(expectedPage)){
	//		System.out.println("expectedPage is verified==pass");
	//	}
	//	else {
	//		System.out.println("expectedPage is not verified==fail");
	//	}
		//hard asserrtt
		Assert.assertEquals(actualTitle, expectedPage);
		driver.close();
	}
	
	
	@Test
	public void verifyLogoTest(Method mtd) {
		System.out.println(mtd.getName()+"Test start");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isDisplayed();
	//	if(status) {
	//		System.out.println("logo is verified==pass");
	//	}
	//	else {
	//		System.out.println("logo is not verified==fail");
	//	}
		Assert.assertTrue(status);
		driver.close();
	}

}
