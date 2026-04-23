package com.crm.objectRepositoryUtility;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GENERIC.WEBDRIVER_UTILITY.webDriveraUtility;
/**
 * @author PRIYANKA
 * contains login page elements and business lib.
 */

public class LoginPage extends webDriveraUtility{ 	//rule1= create separate java class
							//rule 2; object creation
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	@FindBy(name="user_name")
	private WebElement UN;
	
	@FindBy(name="user_password")
	private WebElement PSWD;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//rule 3 =object initialization--do in create org program
	//rule4 = object encapsulation
			public WebElement getUN() {
				return UN;
			}
		
			public WebElement getPSWD() {
				return PSWD;
			}

			public WebElement getLoginBtn() {
				return loginBtn;
			}
	//rule 5 provide action
			
			/**
			 * login to app based on Un,Pswrd,Url
			 * @author PRIYANKA
			 * @param URL
			 * @param username
			 * @param pswrd
			 */
			 
			public void loginToApp(String URL,String username,String pswrd) {
				waitForUtility(driver);
				driver.manage().window().maximize();
				driver.get(URL);
				UN.sendKeys(username);
				PSWD.sendKeys(pswrd);
				loginBtn.click();
			}
	
	
}
