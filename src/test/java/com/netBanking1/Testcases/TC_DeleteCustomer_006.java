package com.netBanking1.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.netBanking1.PageObjects.DeleteCustomer;
import com.netBanking1.PageObjects.LoginPage;

public class TC_DeleteCustomer_006 extends BaseClass
{
    @Test
	public void deleteCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		
		lp.setUsername(username);
		logger.info("Username entered");
		lp.setPassword(password);
		logger.info("Password entered");
		lp.clickButton();
		
		Thread.sleep(4000);
		
		DeleteCustomer dc=new DeleteCustomer(driver);
	    dc.clickDelCustomer();
	    Thread.sleep(2000);
	    dc.enterCusId("31237");
	    dc.click_CusId_Submit();
	    driver.switchTo().alert().accept();
		Thread.sleep(2000);
		String text=driver.switchTo().alert().getText();
		System.out.println(text);
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();

		String text2="Customer deleted Successfully";
		if(text.equals(text2))
		{
			Assert.assertTrue(true);
			logger.info("Deleted successfully");
		}
		else
		{
//			captureScreen(driver,"deleteCustomer");
			Assert.assertTrue(false);
			logger.info("Deletion failed");
		}
		
		
		
	}
	
}
