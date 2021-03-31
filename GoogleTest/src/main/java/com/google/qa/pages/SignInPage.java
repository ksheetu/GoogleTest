package com.google.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.qa.base.TestBase;

public class SignInPage extends TestBase {
	

	@FindBy(xpath="//input[@type='email']")
	WebElement Email;
	
	@FindBy(xpath="//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']")
	WebElement NextBtn1;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Pass;
	
	@FindBy(xpath="//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc lw1w4b']")
	WebElement NextBtn2;
	
	
	public SignInPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public void  Email(String email) throws  IOException {
		Email.sendKeys(email);
		NextBtn1.click();
		
		
		
		
		
		
	}
	
	public HomePage Pass(String pass) {
		Pass.sendKeys(pass);
		NextBtn2.click();
		return new HomePage();
	}
	
	
}
