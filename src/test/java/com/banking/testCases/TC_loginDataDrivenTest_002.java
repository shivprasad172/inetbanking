package com.banking.testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.pageObjects.LoginPage;
import com.banking.utilities.XLUtils;

public class TC_loginDataDrivenTest_002 extends BaseClass {

	
	@Test (dataProvider="Logindata")
	public void loginDDTest(String username, String password) {
		// create the object of LoginPage class pageObjects
	
			LoginPage lp=new LoginPage(driver);
			lp.userName(username);
			lp.userPassword(password);
			lp.Loginbtn();
			
		
		if (isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else {
			lp.Logoutbtn();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
		}
		
	}
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert(); // if true, then login failed
		return true;
		}
		catch (Exception e){
			return false;  // if false, login is passed
		}
	
	}
	
	@DataProvider(name="Logindata")
	String [][] getData() throws EncryptedDocumentException, IOException{
		
	String data [][]=	XLUtils.getDataFromXLSheet();
		return data;
		
	}
}
