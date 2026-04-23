package com.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class createNewOrgnanizationPage {
	WebDriver driver;
	public createNewOrgnanizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(name="industry")
	private WebElement industryDD;
	
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createOrg(String orgname) {
		orgNameEdt.sendKeys(orgname);
		saveBtn.click();
	}
	public void createOrg(String orgname,String industry) {
		orgNameEdt.sendKeys(orgname);
		Select sel=new Select(industryDD);
		sel.selectByVisibleText(industry);
		saveBtn.click();
	}
	@FindBy(id="phone")
	private WebElement PhoneNumberEdt;
	
	public WebElement getPhoneNumberEdt() {
	return PhoneNumberEdt;}
	
	public void createOrgPhoneNumber(String orgname,String phoneNumber) {
	orgNameEdt.sendKeys(orgname);
	PhoneNumberEdt.sendKeys(phoneNumber);
	saveBtn.click();
	
		  
		  
	    	
	    }
	
	

	
	
	//xtras for additional testscript.
	@FindBy(name="campaignname")
	private WebElement campaignnameEdt ;


    public void campaignNameEdt(String compaignName) {
    	campaignnameEdt.sendKeys(compaignName);
    	saveBtn.click();
    	
    }
    
    @FindBy(name="productname")
	private WebElement productname ;


    public void productnameEdt(String productName) {
    	productname.sendKeys(productName);
    	saveBtn.click();
    	
    }
    
    @FindBy(xpath="//input[@title='Delete [Alt+D]']")
    private WebElement delKey;
    
    public void deleteProdkey() {
    	delKey.click();
    	
    }
    
   
}