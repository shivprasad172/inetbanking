package com.banking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


// This is the listener class used to generate the report

public class Reporting extends TestListenerAdapter {
public ExtentSparkReporter htmlReporter;
public ExtentReports extent;
public ExtentTest logger;

public void onStart(ITestContext testcontext) {
	String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	String reportname="Test-Report-"+timestamp+".html";
	htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+reportname);
	try {
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	} catch (IOException e) {
		
		
	}
	extent=new ExtentReports();
	extent.attachReporter(htmlReporter);
	extent.setSystemInfo("Host name", "localhost");
	extent.setSystemInfo("Environment", "QA");
	extent.setSystemInfo("user", "Shivprasad");
	
	htmlReporter.config().setDocumentTitle("InetBanking Testing Project");// title of report
	htmlReporter.config().setReportName("Functional UI Test Report");//name of the report
	htmlReporter.config().setTheme(Theme.DARK);
	

}
	public void onTestSuccess(ITestResult result) {
	logger=extent.createTest(result.getName()); //create new entry in the report
	logger.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN)); // send the passed information
	
}
	public void onTestFailure(ITestResult result) {
	logger=extent.createTest(result.getName()); //create new entry in the report
	logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED)); // send the failed information
	
	String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
	
	File file=new File(screenshotPath);
	if (file.exists()) {
		logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			
	}
	
}
	public void onTestSkipped(ITestResult result) {
		logger=extent.createTest(result.getName()); //create new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE)); 
		
	}
	public void onFinish(ITestContext testcontext) {
		extent.flush();
	}
}
