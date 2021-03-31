package com.zohocrm.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zohocrm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//div[@data-value='Contacts']//a")
	WebElement ContactLink;

	@FindBy(xpath = "//crm-profile-menu[@class='crmProfileMenu mL10']//div[@id='dropclk']//img[contains(@src,'contacts.zoho.com')]")
	WebElement SignoutImgBtn;

	@FindBy(xpath = "//lyte-yield[text()='Sign Out']")
	WebElement SignoutBtn;

	@FindBy(xpath = "//a[@title='Manage Sessions']")
	WebElement ManageSessions;

	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	public String VerifyHomePageTitle() {
		return driver.getTitle();
	}

	
	  public ContactsPage VerifyContactLinkClick() {
			/*
			 * if (ManageSessions.isDisplayed()) { ManageSessions.click(); }
			 */
	  
	  ContactLink.click(); return new ContactsPage(); }
	 

	public void VerifySignOut() {
		/*
		 * if (ManageSessions.isDisplayed()) { ManageSessions.click(); }
		 */
		SignoutImgBtn.click();
		SignoutBtn.click();

	}

}
