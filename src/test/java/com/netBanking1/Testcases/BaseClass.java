package com.netBanking1.Testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.security.Security;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.netBanking1.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
     ReadConfig readconfig= new ReadConfig();
	 	
	public String baseURL=readconfig.getURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) 
	{
//		System.setProperty("webdriver.firefox.driver", "C:\\Users\\Dell\\eclipse-workspace\\netBanking1\\Drivers\\chromedriver.exe");
//		driver=new FirefoxDriver();
		logger=LogManager.getLogger(BaseClass.class);
		
		if(browser.equalsIgnoreCase("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		}	   	 
		else if(browser.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		/*Desired capabities using Headless browser*/
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
//		WebDriver driver = new ChromeDriver(options);
		/*Handling SSLCertificate using Desired capabilities*/
		DesiredCapabilities handlSSLErr =new DesiredCapabilities(); 
				handlSSLErr.setAcceptInsecureCerts(true);
		driver=new ChromeDriver(handlSSLErr);
		
//		driver=new ChromeDriver();
//		/* Handling SSL Certificate using DevTools*/
		driver.manage().timeouts().pageLoadTimeout(160, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
//		DevTools devtool=((ChromeDriver)driver).getDevTools();
//		devtool.createSession();
//		devtool.send(Security.enable());
//		devtool.send(Security.setIgnoreCertificateErrors(true));
			
			
    	}
		else if(browser.equalsIgnoreCase("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		
		DevTools devtool=((EdgeDriver)driver).getDevTools();
		devtool.createSession();
		devtool.send(Security.enable());
		devtool.send(Security.setIgnoreCertificateErrors(true));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		
		driver.get(baseURL);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	public void captureScreen(WebDriver driver,String tName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File Source=ts.getScreenshotAs(OutputType.FILE);
		
		String timestamp=new SimpleDateFormat("yyy.MM.dd.HH.mm.ss").format(new Date());
		File Des=new File(System.getProperty("user.dir")+"/ScreenShots/"+tName+"-"+timestamp+".png");

		FileUtils.copyFile(Source, Des);
		System.out.println("Screenshot Taken");
		
	}
	
	public String genRandomString()
	{
		String RanStriValue=RandomStringUtils.randomAlphabetic(8);
		return RanStriValue;
	}
	
	public String genRandomInteger()
	{
		String RanStriValue2=RandomStringUtils.randomNumeric(10);
		return RanStriValue2;
	}
	
}
