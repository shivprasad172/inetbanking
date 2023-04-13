package com.banking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.LoginPage;

public class TC_loginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException {
		
		
		LoginPage lp =new LoginPage(driver);
		lp.userName(username);
		lp.userPassword(password);
		lp.Loginbtn();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
		}
		
		else {
			captureScreenshot(driver, "loginTest" );
			Assert.assertTrue(false);
				}
		}
}
