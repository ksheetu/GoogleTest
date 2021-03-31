package com.zohocrm.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zohocrm.qa.base.TestBase;

public class LandingPage extends TestBase {
	
	//PageFactory -Object Repository
	@FindBy(xpath="//div[@class='zgh-utilities']//div[@class='zgh-accounts']//a[@class='zgh-login']")
	WebElement SignInBtn;
	
	
	
	//Initializing Page Objects
	public LandingPage() {
		PageFactory.initElements(driver, this);
		
		
	}	

	//Actions
	
	public  String validateTitle() {
		return driver.getTitle();		
		
	}
	
	public  LoginPageLoginId ClickOnSignIn() {
		
		SignInBtn.click();
		return new LoginPageLoginId();
	}			
	
	
	
}
