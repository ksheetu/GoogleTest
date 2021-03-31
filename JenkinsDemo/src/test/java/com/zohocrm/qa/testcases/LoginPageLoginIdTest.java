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

public class LoginPageLoginIdTest extends TestBase {
	LandingPage landingPage;
	LoginPageLoginId loginPageloginId;
	LoginPagePassword loginPagePassword;
	HomePage homepage;
	ExtentReports extent;
	ExtentSparkReporter spark;
	ExtentTest extenttest;
	TestUtil testutil;
	String ExtentReportPath=System.getProperty("user.dir")+"\\test-output"+"\\ExtentReport.html";
	public LoginPageLoginIdTest(){
		super();
	}
	
	/*
	 * @BeforeSuite public void setupextent() { extent= new ExtentReports();
	 * spark=new ExtentSparkReporter(ExtentReportPath);
	 * extent.attachReporter(spark); testutil= new TestUtil();
	 * 
	 * }
	 */
	
	@BeforeMethod
	public void setup() {
		initialize();
		landingPage= new LandingPage();
		loginPageloginId=landingPage.ClickOnSignIn();
		loginPagePassword= new LoginPagePassword();
		
		
	}
	
	
	@Test(priority=1)
	public void LoginPageLoginIdTitleTest() {
		extenttest= extent.createTest("LoginPageLoginIdTitleTest");
		String LoginPageLoginIdTitle=loginPageloginId.VerifyLoginPageLoginIdTitle();
		Assert.assertEquals(LoginPageLoginIdTitle, "Zoho Accounts","LoginPageLoginIdTitle is not matching");
	
		
	}
	@Test(priority=2)
	public void ClickOnNextBtnTest() {
		extenttest= extent.createTest("ClickOnNextBtnTest");
		loginPageloginId.ClickOnNextBtn(prop.getProperty("usernamedata"));
	}
	
	
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		if (result.getStatus()==ITestResult.FAILURE) {
			extenttest.log(Status.FAIL, "Failed Test --> " +result.getName() );
			extenttest.log(Status.FAIL, "Failed Test --> " +result.getThrowable() );
			String ScreenshotPath=testutil.takeScreenshotAtEndOfTest(driver, result.getName());
			extenttest.addScreenCaptureFromPath(ScreenshotPath);
			
		}else if(result.getStatus()==ITestResult.SKIP) {
			extenttest.log(Status.SKIP, "Skipped Test --> " +result.getName() );
			
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			extenttest.log(Status.PASS, "Passed Test --> " +result.getName() );
		}
		
		
		driver.quit();
	}	
	/*
	 * @AfterSuite public void ReportFlush() throws IOException { extent.flush();
	 * Desktop.getDesktop().browse(new File(ExtentReportPath).toURI());//open extent
	 * report result }
	 */
	 
}
