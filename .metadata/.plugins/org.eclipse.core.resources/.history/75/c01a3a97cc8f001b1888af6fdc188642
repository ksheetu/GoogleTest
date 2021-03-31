package com.zohocrm.qa.Pages;

import org.openqa.selenium.By;

import com.zohocrm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	
	
	
	
	
	public String VerifyContactsPageTitle() {
		
		return driver.getTitle();
	//
	}
	public  boolean selectContact(String name) {
		 driver.findElement(By.xpath("//a[@data-zcqa='"+name+"']//parent::lyte-yield//parent::lyte-exptable-td//preceding-sibling::lyte-exptable-td[contains(@class,'CheckboxCol')]//lyte-yield")).click();
		boolean ContactSelect= driver.findElement(By.xpath("//a[@data-zcqa='"+name+"']//parent::lyte-yield//parent::lyte-exptable-td//preceding-sibling::lyte-exptable-td[contains(@class,'CheckboxCol')]//lyte-yield")).isSelected();
		return ContactSelect;
	}
	

}
