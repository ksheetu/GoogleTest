package com.google.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.qa.base.TestBase;
import com.google.qa.pages.HomePage;
import com.google.qa.pages.LandPage;
import com.google.qa.pages.SignInPage;

public class SignPageTest extends TestBase {
	LandPage landpage;
	SignInPage signinpage;
	HomePage homepage;
	
	public SignPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		landpage=new LandPage();
		signinpage=landpage.SigninClick();
	}
	
	@Test
	public void LoginTest() throws InterruptedException, IOException{
		
		signinpage.Email("ksheetu@gmail.com");
		Thread.sleep(2000);
		homepage= signinpage.Pass("Tej@m123");		 
				
		
	}
	
	@AfterMethod
	public void teardown() throws IOException{
		driver.quit();
	}

}
