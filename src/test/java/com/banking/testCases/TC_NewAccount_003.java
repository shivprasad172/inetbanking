package com.banking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.LoginPage;
import com.banking.pageObjects.NewAccountPage;

public class TC_NewAccount_003 extends BaseClass{

	@Test
	public void CreateNewAccount() throws InterruptedException, IOException {
		
		LoginPage lp =new LoginPage(driver);
		lp.userName(username);
		lp.userPassword(password);
		lp.Loginbtn();
		
		Thread.sleep(2000);
		
		NewAccountPage newpage = new NewAccountPage(driver);
		newpage.clickNewAccount();
		newpage.setCustId("89487");
		newpage.selectAccount("Current");
		newpage.setInitialDepo("10000");
		newpage.clickSubmit();
		if(driver.getPageSource().contains("Account Generated Successfully!!!")) {
			Assert.assertTrue(true);
		}else {
			captureScreenshot(driver, "CreateNewAccount");
			Assert.assertTrue(false);
		}
	}
}
