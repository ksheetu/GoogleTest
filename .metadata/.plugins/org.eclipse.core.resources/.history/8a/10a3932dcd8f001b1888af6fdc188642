package com.zohocrm.qa.testcases;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class TestDataTesting {
	public static String TestDataFilePath="F:\\NaveenJavatraining\\ZohoCRMTest\\src\\main\\java\\com\\zohocrm\\qa\\TestData\\ZohoCRMTestdata.xlsx";
	 static String sheetName;
	 static Workbook book;
	 static Sheet sheet;
	
	public static void main(String[] args) {
		System.out.println(TestDataFilePath);
		
		Object[][]  obj=getTestData("Contact");			
		System.out.println(obj.length);
		
		for (int i = 0; i < obj.length; i++) {
			for (int j = 0; j < obj[i].length; j++) {
				System.out.println(obj[i][j]);
				
			}
		}
		

	}

	public static Object[][] getTestData(String sheetName){
		
		FileInputStream file= null;
		
		try {
			file= new FileInputStream(TestDataFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet=book.getSheet(sheetName);
		
		Object[][]data =new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i <sheet.getLastRowNum(); i++) {
			for (int j = 0; j <sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				//System.out.println(sheet.getRow(i+1).getCell(j).toString());
			}
		}
		
		return data;
		
	}
}
