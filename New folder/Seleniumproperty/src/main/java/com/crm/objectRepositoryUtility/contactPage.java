package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactPage {

	WebDriver driver;
	public contactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createNewcontactBtn;

	public WebElement getCreateNewcontactBtn() {
		return createNewcontactBtn;
	}
	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	@FindBy(id = "dtlview_Last Name")
	private WebElement nameMsg;
	
	public WebElement getnameMsg() {
		return nameMsg;
	}

}
