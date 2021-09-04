package com.netBanking1.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.netBanking1.PageObjects.EditCustomer;
import com.netBanking1.PageObjects.LoginPage;

public class TC_EditCustomer_004 extends BaseClass
{
    @Test  
	public void editCustomer() throws InterruptedException, IOException
	{
    	
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username entered");
		lp.setPassword(password);
		logger.info("Password entered");
		lp.clickButton();
		
		Thread.sleep(4000);
		
		EditCustomer ec=new EditCustomer(driver);
		ec.clickEditButton();
		Thread.sleep(2000);
		TC_AddNewCustomer_003 TC_ec=new TC_AddNewCustomer_003();
		String cusId=TC_ec.getcusId();
		ec.enterCusId(cusId);
		ec.clickCusIdSubmit();
		Thread.sleep(2000);
		ec.editCityName("Bhuvaneshwar");
		ec.Submit_edit();
		Thread.sleep(3000);
		Boolean Status=driver.getPageSource().contains("Customer details updated Successfully!!!");
		
		if(Status==true)
		{
			Assert.assertTrue(true);
			logger.info("Successfully edited");
		}
		else
		{
			captureScreen(driver,"editCustomer");
			Assert.assertTrue(false);	
			logger.info(" edit failed");
		}
	}
	
}
