package com.zohocrm.qa.testcases;



import org.testng.annotations.Test;

import com.zohocrm.qa.base.TestBase;
import com.zohocrm.qa.util.TestUtil;

public class TestDataTest extends TestBase{
	
	@Test
	public void TestDataTesting() {
		testutil= new TestUtil();
		Object[][]obj= 	testutil.getTestData("Contact");
		System.out.println(obj.length);
		
	}

}
