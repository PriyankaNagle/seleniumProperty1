package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfo {
	WebDriver driver;
	public OrganizationInfo(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	@FindBy(id="phone")
	private WebElement PhoneNumberEdt;
	
	public WebElement getPhoneNumberEdt() {
	return PhoneNumberEdt;}
	
	
	
	//xtras done for additional testscripts.
	@FindBy(className = "lvtHeaderText")
	private WebElement prodHeader;
	
	public WebElement getProdHeader() {
		return prodHeader;
	}
	
	
}
