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
import com.zohocrm.qa.Pages.ContactsPage;
import com.zohocrm.qa.Pages.HomePage;
import com.zohocrm.qa.Pages.LandingPage;
import com.zohocrm.qa.Pages.LoginPageLoginId;
import com.zohocrm.qa.Pages.LoginPagePassword;
import com.zohocrm.qa.base.TestBase;
import com.zohocrm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LandingPage landingPage;
	LoginPageLoginId loginPageloginId;
	LoginPagePassword loginPagePassword;
	HomePage homePage;
	ContactsPage contactsPage;
	ExtentReports extent;
	ExtentSparkReporter spark;
	ExtentTest extenttest;
	TestUtil testutil;
	String ExtentReportPath=System.getProperty("user.dir")+"\\test-output"+"\\ExtentReport.html";
	public HomePageTest(){
		super();
		
	}

	/*
	 * @BeforeSuite public void setupExtent() {
	 * 
	 * extent= new ExtentReports(); spark= new
	 * ExtentSparkReporter(System.getProperty("user.dir") +
	 * "\\test-output"+"\\ExtentReport.html" );
	 * 
	 * 
	 * 
	 * extent.attachReporter(spark); }
	 */
	@BeforeMethod
	public void setup() throws InterruptedException{
		initialize();
		
		landingPage= new LandingPage();
		System.out.println(driver.getTitle());
		loginPageloginId=landingPage.ClickOnSignIn();
		System.out.println(driver.getTitle());
		loginPagePassword= loginPageloginId.ClickOnNextBtn(prop.getProperty("usernamedata"));
		System.out.println(driver.getTitle());
		 
		//homePage= loginPagePassword.ClickOnSignInBtn(prop.getProperty("passworddata"));
		 
		
		Thread.sleep(2000);
		
		 contactsPage= new ContactsPage();
		 testutil= new TestUtil();
		
	}
	
	
	
	  @Test(priority=1) 
	  public void VerifyHomePageTest() throws InterruptedException{
			extenttest=extent.createTest("VerifyHomePageTest");
	  
	  homePage=  loginPagePassword.ClickOnSignInBtn(prop.getProperty("passworddata"));
	  
	  Thread.sleep(2000); String HomePageTitle= homePage.VerifyHomePageTitle();
	  Assert.assertEquals(HomePageTitle,
	  "Home Page - Zoho CRM","HomePageTitle does not match"); }
	 
	  
	  
	
	  @Test(priority=2)
	  public void ContactLinkClickTest() throws InterruptedException{
		  extenttest=extent.createTest("ContactLinkClickTest");
	  homePage=  loginPagePassword.ClickOnSignInBtn(prop.getProperty("passworddata"));
	  
	  
	  Thread.sleep(2000); contactsPage=homePage.VerifyContactLinkClick();
	  
	  }
	 
	  
	 @Test(priority=3)
	 public void SignOutTest() {
		 extenttest=extent.createTest("SignOutTest");
		 homePage= loginPagePassword.ClickOnSignInBtn(prop.getProperty("passworddata"));
		 homePage.VerifySignOut();
		 String AfterSignout=driver.getTitle();
		 Assert.assertEquals(AfterSignout, "Zoho CRM - Bigin","AfterSignout Window Title not matching");
	 }
	
	  @AfterMethod 
	  public void teardown(ITestResult result) throws IOException{ 
		  
		  if(result.getStatus()==ITestResult.FAILURE) {
			  extenttest.log(Status.FAIL, "Test Failed -->" + result.getName());
			  extenttest.log(Status.FAIL, result.getThrowable());
			 String ScreenshotPath= testutil.takeScreenshotAtEndOfTest(driver,result.getName());
			  extenttest.addScreenCaptureFromPath(ScreenshotPath);
			  
		  }else if(result.getStatus()==ITestResult.SKIP){
			  extenttest.log(Status.SKIP, "Test Skipped -->" + result.getName());
		  }if(result.getStatus()==ITestResult.SUCCESS){
			  extenttest.log(Status.PASS, "Test Success -->" + result.getName());
		  }
		  
	
			loginPagePassword=null; 
			homePage=null;
			 
		  driver.quit();
	  
	  }
	 
		
		  @AfterSuite
		  public void ReportFlush() throws IOException { extent.flush();
		  Desktop.getDesktop().browse(new File(ExtentReportPath).toURI());//open extent report result 
		  }
		 
	
}
