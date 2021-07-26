package com.up.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.up.qa.base.TestBase;

public class TestUtil extends TestBase{

	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
public static String TESTDATA_SHEET_PATH = "C:\\Users\\Abhis\\eclipse-workspace\\UPKeep\\src\\main\\java\\com\\up\\qa\\testdata\\signUpDate.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName) throws EncryptedDocumentException, IOException{
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		book = WorkbookFactory.create(file);
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i< sheet.getLastRowNum(); i++) {
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
	}

	
	
	
}
