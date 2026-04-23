package com.crm.objectRepositoryUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
  

public class organizationPage {
	
	WebDriver driver;
	public organizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createNewcontactBtn;

	public WebElement getCreateNewcontactBtn() {
		return createNewcontactBtn;
	}
	
	
	
	
	//xtras done for additional testscripts.
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement createNewCampaignBtn;

	public WebElement getCreateNewCampaignBtn() {
		return createNewCampaignBtn;
	}
	
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement createNewProductBtn;

	public WebElement getCreateNewProductBtn() {
		return createNewProductBtn;
	}

}
