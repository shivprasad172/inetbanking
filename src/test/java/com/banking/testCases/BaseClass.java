package com.banking.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.banking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	public String baseURL =readconfig.getApplicationURL();
	public String username  = readconfig.getUsername();
	public String password  = readconfig.getPassword();
	public static WebDriver driver;
	
	
	
//public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setupBrowser(String br) {
		
		if(br.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		}
		
		else if(br.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			}
		
		else if(br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));     //wait
		driver.get(baseURL);  // open url
		// add logger info
		
		//logger= Logger.getLogger("ebanking");
		//PropertyConfigurator.configure("log4j.properties");
	}
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	
	public void captureScreenshot(WebDriver driver, String tname) throws IOException {
		File source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File target =new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}
}
