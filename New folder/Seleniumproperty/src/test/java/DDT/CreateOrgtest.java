package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrgtest {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData2.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String browser=pro.getProperty("browser");
		String URL=pro.getProperty("url");
				String USERNAME=pro.getProperty("username");
						String PASSWORD=pro.getProperty("password");
				
						/*
						 * Scanner s=new Scanner("System.in");
						 * System.out.println(" enter the browser: "); String Browser=s.next();
						 */
		WebDriver driver=null;
		
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();}
			else if(browser.equals("firefox")) {
				driver=new FirefoxDriver();}
			else if(browser.equals("edge")) {
				driver=new EdgeDriver();
			}
			else {
				driver=new ChromeDriver();
			
			}
			
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		  driver.get(URL);
		  driver.findElement(By.id("username")).sendKeys(USERNAME);
		  driver.findElement(By.id("inputPassword")).sendKeys("PASSWORD");
		  driver.findElement(By.xpath("//button[@type='submit']")).click();
		  driver.close();
	}

}
