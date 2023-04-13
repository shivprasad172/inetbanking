package com.banking.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class XLUtils {

	
	public static String [][] getDataFromXLSheet() throws EncryptedDocumentException, IOException {
	
		
		//FileInputStream excel = new FileInputStream("/inetBankingHybrid/src/test/java/com/banking/testData/testDataHybrid.xlsx");
		
		FileInputStream excel = new FileInputStream("E:/Automation Test/Miscelleneous/testDataHybrid.xlsx");
		Sheet sheet = WorkbookFactory.create(excel).getSheet("Sheet1");
		int rowcount=sheet.getPhysicalNumberOfRows();
		int columncount =sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.print(rowcount+"  "+ columncount);
		
		String exceldata [][]=new String [rowcount][columncount];
		for (int i=0;i<rowcount;i++) {
			for(int j=0;j<columncount;j++) {
				exceldata [i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(exceldata[i][j]);
			}
		}
		return exceldata;
		
			
		
		
		
	}

	
}
