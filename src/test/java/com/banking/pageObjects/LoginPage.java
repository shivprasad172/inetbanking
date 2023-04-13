package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//declare web driver
	WebDriver driver;
	// find elements
	@FindBy(xpath="//input[@name='uid']")
	WebElement setuserName;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement setPassword;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	WebElement logoutBtn;
	
	//create constructor
	public LoginPage (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	// create action methods
	public void userName (String uname) {
		setuserName.sendKeys(uname);
	}
	
	public void userPassword (String upass) {
		setPassword.sendKeys(upass);
	}
	
	public void Loginbtn () {
		loginBtn.click();
	}
	public void Logoutbtn () {
		logoutBtn.click();
	}
	
}
