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

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.zohocrm.qa.Pages.LandingPage;
import com.zohocrm.qa.Pages.LoginPageLoginId;
import com.zohocrm.qa.base.TestBase;
import com.zohocrm.qa.util.TestUtil;



public class LandingPageTest extends TestBase {
	
	
	ExtentReports extent;
	ExtentSparkReporter spark;
	ExtentTest extenttest;
	LandingPage landingPage;
	LoginPageLoginId loginPageloginId;
	TestUtil testutil;
	String ExtentReportPath=System.getProperty("user.dir") + "\\test-output"+"\\ExtentReport.html";
	
	
	
	
	public 	LandingPageTest(){
		super();
	}
	
	@BeforeSuite
	public void setupExtent() throws IOException {
	
		 extent= new ExtentReports();
		 spark= new ExtentSparkReporter(ExtentReportPath);
	/*	//Setting through java code
		 spark.config().setTheme(Theme.DARK);
		 spark.config().setDocumentTitle("Automation Result");
		 spark.config().setReportName("ZohoCRM Automation Result");*/
		
		 //
		// using the xml file path
		 File xmlfile= new File("F:\\NaveenJavatraining\\ZohoCRMTest\\src\\main\\java\\com\\zohocrm\\qa\\config\\extentxmlconfig.xml");
		 spark.loadXMLConfig(xmlfile);

		 extent.attachReporter(spark);
		
		 
	}
	
	@BeforeMethod
	public void setup() {
		
		initialize();
		landingPage= new LandingPage() ;
		loginPageloginId= new LoginPageLoginId();
		testutil= new TestUtil();
		
	}
	
	@Test(priority=1)
	public void landingPageTitleTest(){
		extenttest=extent.createTest("landingPageTitleTest");
		  String landingPageTitle=landingPage.validateTitle(); 
		  Assert.assertEquals(landingPageTitle,"Zoho CRM | Top-rated Sales CRM Software by Customers");
		
		
		
	}
	
	@Test(priority=2)
	public  void ClickOnSignInTest() {
		extenttest=extent.createTest("ClickOnSignInTest");
		loginPageloginId =landingPage.ClickOnSignIn();
		

		
	}			
	
	
	
	
	
	  @AfterMethod 
	  public void Teardown(ITestResult result) throws IOException{
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
		  
		 
		  driver.quit();
	  }
	 
	 @AfterSuite
	 public void ReportFlush() throws IOException {
		 extent.flush();
		  Desktop.getDesktop().browse(new File(ExtentReportPath).toURI());//open extent report result
	 }
	 
	 
}
