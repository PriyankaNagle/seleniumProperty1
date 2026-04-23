package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createNewContactPage {
	WebDriver driver;
	public createNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(name="lastname")
	private WebElement lastnameEdt ;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;			


    public void lastnameEdt(String lastname) {
    	lastnameEdt.sendKeys(lastname);
    	saveBtn.click();
    	
    	

}
}
