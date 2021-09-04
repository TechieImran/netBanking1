package com.netBanking1.Testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.netBanking1.PageObjects.AddNewCustomer;
import com.netBanking1.PageObjects.LoginPage;

public class TC_AddNewCustomer_003 extends BaseClass
{
    @Test
	public void addingNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username is entered");
		lp.setPassword(password);
		logger.info("password is entered");
		lp.clickButton();
		
//		Thread.sleep(3000);
		
		AddNewCustomer addNewCus=new AddNewCustomer(driver);
		addNewCus.clickAddNewCustomer();
		addNewCus.enterName("Tanzeel");
		addNewCus.enterGender("male");
		addNewCus.enterDOB("10","9","1994");
		logger.info("Date is entered");
		Thread.sleep(1000);
		addNewCus.enterAddress("Hanuman nagar");
		addNewCus.enterCity("Cuttack");
		addNewCus.enterState("Odisa");
		addNewCus.enterPIN("500937");
		addNewCus.enterTelPhNo("9999988888");
		
		String gmail=genRandomString().concat("@gmail.com");
		addNewCus.enterEMail(gmail);
		addNewCus.enterPasswrd("Hiroshima");
		Thread.sleep(2000);
		addNewCus.ClickOnSubmit();
		Thread.sleep(3000);
		logger.info("Submitted for new customer");
		boolean status=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
//		String CId=driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]")).getText();
////		Thread.sleep(4000);
//		System.out.println(CId);
		
		if(status==true)
		{  
		
			Assert.assertTrue(true);
			logger.info("New Customer added");
//			Assert.assertEquals(status1, status);
		}
		else
		{
			captureScreen(driver,"addingNewCustomer");
			Assert.assertTrue(false);
			logger.info("New Customer not added");
		}
		
		
	}
    @AfterMethod
    public String getcusId() throws InterruptedException
	{
    	String CId=driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]")).getText();
		Thread.sleep(4000);
		System.out.println(CId);
		return CId;
	}
//	
	
}
