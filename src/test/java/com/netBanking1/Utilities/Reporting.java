package com.netBanking1.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	
	public void onStart(ITestContext testContext) 
	{
		String timestamp=new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
		String exRepName="Extent-Test-Report"+timestamp+".html";
		
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/Extent_Reports/"+exRepName);
//		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		htmlReporter.config().setDocumentTitle("net Banking TestProject");
		htmlReporter.config().setReportName("Functional test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Tester", "Imran");
		extent.setSystemInfo("HostName", "loaclHost");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Environment", "QA");
		
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
				
		String timestamp=new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
		String ScreenShotPath=System.getProperty("user.dir")+"/ScreenShots/"+tr.getName()+"-"+timestamp+".png";
		File f=new File(ScreenShotPath);
		
		if(f.exists())
		{
			try
			{
				logger.fail("Screenshot is below "+logger.addScreenCaptureFromPath(ScreenShotPath));
			}
			catch(IOException io)
			{
				io.printStackTrace();
			}
		}
	}
	
	 public void onTestSkipped(ITestResult tr)
	 {
		 logger=extent.createTest(tr.getName());
			logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
		 
	 }
	
	 public void onFinish(ITestContext testContext)
	 {
		 extent.flush();
	 }

}
