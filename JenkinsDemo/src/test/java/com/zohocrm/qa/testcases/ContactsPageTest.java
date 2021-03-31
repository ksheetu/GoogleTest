package com.zohocrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.zohocrm.qa.Pages.ContactsPage;
import com.zohocrm.qa.Pages.HomePage;
import com.zohocrm.qa.Pages.LandingPage;
import com.zohocrm.qa.Pages.LoginPageLoginId;
import com.zohocrm.qa.Pages.LoginPagePassword;
import com.zohocrm.qa.base.TestBase;



public class ContactsPageTest extends TestBase {
	
	LandingPage landingPage;
	LoginPageLoginId loginPageloginId;
	LoginPagePassword loginPagePassword;
	HomePage homePage;
	ContactsPage contactsPage;
	
	
	public ContactsPageTest(){
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		initialize();
		
		landingPage= new LandingPage();
		System.out.println(driver.getTitle());
		loginPageloginId=landingPage.ClickOnSignIn();
		System.out.println(driver.getTitle());
		loginPagePassword= loginPageloginId.ClickOnNextBtn(prop.getProperty("usernamedata"));
		System.out.println(driver.getTitle());
		
		homePage= loginPagePassword.ClickOnSignInBtn(prop.getProperty("passworddata"));
		Thread.sleep(2000);
		 contactsPage= homePage.VerifyContactLinkClick();
	
		
	}
		
	@Test
	public void ContactsPageTitleTest() {
		
		
			  homePage= loginPagePassword.ClickOnSignInBtn(prop.getProperty("passworddata")); 
			 
		 
	
		String ContactsPageTitle=contactsPage.VerifyContactsPageTitle();
		Assert.assertEquals(ContactsPageTitle, "Contacts - Zoho CRM","ContactsPageTitle does not match");
	}
	
	@Test
	public void selectContactTest() {
		
			homePage= loginPagePassword.ClickOnSignInBtn(prop.getProperty("passworddata"));
		
	
		Assert.assertTrue(contactsPage.selectContact("Ravi Sakhare"));
		
		
	}
	  @AfterMethod 
	  public void teardown(){ 
		
			
			homePage=null;
			contactsPage=null;
			 
		  driver.quit();
	  
	  }
	 

}
