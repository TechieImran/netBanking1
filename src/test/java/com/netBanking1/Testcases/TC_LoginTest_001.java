package com.netBanking1.Testcases;

import java.io.IOException;
import java.text.SimpleDateFormat;

//import static org.testng.Assert.assertEquals;

//import java.util.concurrent.TimeUnit;

//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
//import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.netBanking1.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
   @Test
   public void login() throws InterruptedException, IOException
   {
	  
	  
	   driver.get(baseURL);
//	   Thread.sleep(2000);
	    	  
	   logger.info(" URL is oppened ");
	   driver.manage().window().maximize();
	   
	   LoginPage lp=new LoginPage(driver);
	   lp.setUsername(username);
	   logger.error("Username is entered");
	   lp.setPassword(password);
	   logger.info("password is entered");
	   lp.clickButton();
	   logger.info("Clicked on login button");
	  if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
	  {
		 Assert.assertTrue(true); 
		 logger.info("Login test is passed");
	  }
	  else
	  {
		 captureScreen(driver,"login");
		  Assert.assertTrue(false);
		  logger.info("Login test is failed");
	  }
	   
	   
	   
   }
	
	
	
	
}
