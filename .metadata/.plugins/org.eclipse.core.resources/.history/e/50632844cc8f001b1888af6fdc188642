package com.zohocrm.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zohocrm.qa.base.TestBase;

public class LoginPageLoginId extends TestBase {

	
	@FindBy(xpath="//input[@id='login_id']")
	WebElement LoginId;
	
		
	@FindBy(xpath="//button[@class='btn blue']//span[text()='Next']")
	WebElement NextBtn;
	
	

	
	
	public LoginPageLoginId(){
		PageFactory.initElements(driver, this);
	}
	
	public String  VerifyLoginPageLoginIdTitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle();
		
	}
	
	public LoginPagePassword ClickOnNextBtn(String un) {
		LoginId.sendKeys(un);
		NextBtn.click();
		return new LoginPagePassword();
		
	}
	
	
	
	
}
