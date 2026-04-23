package practice.contactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SampleTestwithPom {

	@FindBy(name = "user_name")
	WebElement UN;

	@FindBy(name = "user_password")
	WebElement PSWD;

	// {@FindBy(id="submitButton"), @FindBy(xpath="//input[@type='submit']")}
	@FindAll({ @FindBy(id = "submitButton"), @FindBy(xpath = "//input[@type='submit']") })
	private WebElement loginBtn;

	@Test
	public void sampleTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		SampleTestwithPom s = PageFactory.initElements(driver, SampleTestwithPom.class);
		s.UN.sendKeys("admin");
		s.PSWD.sendKeys("manager");
		driver.navigate().refresh();

		s.UN.sendKeys("admin");
		s.PSWD.sendKeys("manager");
		s.loginBtn.click();

	}

}
