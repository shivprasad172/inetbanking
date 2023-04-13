package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage {

	
	
	WebDriver driver;
	// find elements
	@FindBy(xpath="//a[normalize-space()='New Account']")
	WebElement newaccount;
	
	@FindBy(xpath="//input[@name='cusid']")
	WebElement Custid;
	
	@FindBy(xpath="//select[@name='selaccount']")
	WebElement selectaccount;
	
	@FindBy(xpath="//input[@name='inideposit']")
	WebElement initialdeposit;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submitbtn;
	
	//create constructor
		public NewAccountPage (WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(driver, this);
		
		}
		
	public void clickNewAccount() {
		newaccount.click();
	}
	public void setCustId(String id) {
		Custid.sendKeys(id);
	}
	public void selectAccount(String account) {
		Select select=new Select(selectaccount);
		select.selectByVisibleText(account);
	}
	public void setInitialDepo(String deposit) {
		initialdeposit.sendKeys(deposit);
	}
	public void clickSubmit() {
		submitbtn.click();
	}
}
