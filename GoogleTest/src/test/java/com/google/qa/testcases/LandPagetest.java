package com.google.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.qa.base.TestBase;
import com.google.qa.pages.LandPage;
import com.google.qa.pages.SignInPage;

public class LandPagetest extends TestBase {

	LandPage landpage;
	SignInPage signinpage;
	public LandPagetest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		landpage = new LandPage();
	}
	
	@Test
	public void SigninClickTest() throws IOException{
		 signinpage=landpage.SigninClick();
	}
	
	@AfterMethod
	public void teardown() throws IOException{
		driver.quit();
	}
}
