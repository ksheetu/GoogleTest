package com.google.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.qa.base.TestBase;

public class LandPage extends TestBase {

	@FindBy(xpath="//a[text()='Sign in']")
	WebElement SigIn;
	
	public  LandPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	
	public SignInPage SigninClick() throws IOException {
		SigIn.click();
		return new SignInPage();
		
	}
}
