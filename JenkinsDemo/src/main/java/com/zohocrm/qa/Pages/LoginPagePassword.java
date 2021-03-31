package com.zohocrm.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zohocrm.qa.base.TestBase;

public class LoginPagePassword extends TestBase {
	
	@FindBy(xpath="//input[@name='PASSWORD']")
	WebElement PasswordTxt;
	
	@FindBy(xpath="//button[@class='btn blue']//span[text()='Sign in']")
	WebElement SignInBtn;
	
	
	public LoginPagePassword(){
		
		PageFactory.initElements(driver, this);	
		
	}

	public String  VerifyLoginPagePasswordTitle() {
		
		return driver.getTitle();
		
	}
	
	public HomePage ClickOnSignInBtn(String pw) {
		
		PasswordTxt.sendKeys(pw);
		SignInBtn.click();
		return new HomePage();
	}
	
}
