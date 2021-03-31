package com.zohocrm.qa.testcases;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.zohocrm.qa.Pages.HomePage;
import com.zohocrm.qa.Pages.LandingPage;
import com.zohocrm.qa.Pages.LoginPageLoginId;
import com.zohocrm.qa.Pages.LoginPagePassword;
import com.zohocrm.qa.base.TestBase;
import com.zohocrm.qa.util.TestUtil;

public class LoginPagePasswordTest extends TestBase{
	LandingPage landingPage;
	LoginPageLoginId loginPageloginId;
	LoginPagePassword loginPagePassword;
	HomePage homePage;
	TestUtil testutil;
	ExtentReports extent;
	ExtentSparkReporter spark;
	ExtentTest extenttest;
	String ExtentReportPath=System.getProperty("user.dir")+"\\test-output"+"\\ExtentReport.html";
	public LoginPagePasswordTest(){
		super();
	}
	
	/*
	 * @BeforeSuite public void setupEvent() { extent= new ExtentReports(); spark=
	 * new ExtentSparkReporter(ExtentReportPath); extent.attachReporter(spark); }
	 */
	
	
	@BeforeMethod
	public void setup() {
		
		  initialize();
		
		  landingPage= new LandingPage(); 
		  loginPageloginId=landingPage.ClickOnSignIn();
		  
		  loginPagePassword=loginPageloginId.ClickOnNextBtn(prop.getProperty("usernamedata"));
		  
		  homePage= new HomePage();
		  
		  
		 
		
		System.out.println("Inside Setup");
	}
	
	
	  @Test(priority=2) 
	  public void LoginPagePasswordTitleTest()
	  {
	  extenttest= extent.createTest("LoginPagePasswordTitleTest");
	  String  LoginPagePasswordTitle=loginPagePassword.VerifyLoginPagePasswordTitle();
	  Assert.assertEquals(LoginPagePasswordTitle,"Zoho Accounts","LoginPagePasswordTitle not matching");
	  
	  System.out.println("Title Test");
	  
	  
	  }
	 
	
	  @Test(priority=1) 
	  public void ClickOnSignInBtnTest() {
		  
		  extenttest= extent.createTest("ClickOnSignInBtnTest");
		  //loginPagePassword=loginPageloginId.ClickOnNextBtn(prop.getProperty("username"));
		  
	    homePage=loginPagePassword.ClickOnSignInBtn(prop.getProperty("passworddata"));
	
	    System.out.println("ClickOnSign");
	  }
	 
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		if (result.getStatus()==ITestResult.FAILURE) {
			extenttest.log(Status.FAIL, "Failed Test-->" +result.getName());//Get Test name
			extenttest.log(Status.FAIL, "Failed Test-->" +result.getThrowable());//get error log
			String Screenshotpath=testutil.takeScreenshotAtEndOfTest(driver, result.getName());
			extenttest.addScreenCaptureFromPath(Screenshotpath);
		}else if(result.getStatus()==ITestResult.SKIP) {
			extenttest.log(Status.SKIP, "SKIPPED Test-->" +result.getName());//Get Test name
			extenttest.log(Status.SKIP, "SKIPPED Test-->" +result.getThrowable());//get error log
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			extenttest.log(Status.PASS, "PASSED Test-->" +result.getName());//Get Test name
			extenttest.log(Status.PASS, "PASSED Test-->" +result.getThrowable());//get error log
		}
		
		loginPagePassword=null;
		driver.quit();
		System.out.println("teardown");
	}
	
	/*
	 * @AfterSuite public void ReportFlush() throws IOException { extent.flush();
	 * Desktop.getDesktop().browse(new File(ExtentReportPath).toURI());//open extent
	 * report result }
	 */
}
