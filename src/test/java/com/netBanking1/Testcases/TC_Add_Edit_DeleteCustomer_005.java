package com.netBanking1.Testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.netBanking1.PageObjects.AddNewCustomer;
import com.netBanking1.PageObjects.DeleteCustomer;
import com.netBanking1.PageObjects.EditCustomer;
import com.netBanking1.PageObjects.LoginPage;



public class TC_Add_Edit_DeleteCustomer_005 extends BaseClass
{

	String CId;
    @Test(priority=1)
	public void addingNewCustomer() throws InterruptedException, IOException
	{
    	driver.manage().timeouts().pageLoadTimeout(160, TimeUnit.SECONDS);
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Username is entered");
		lp.setPassword(password);
		logger.info("password is entered");
		lp.clickButton();
		logger.info("clicked on button");
		Thread.sleep(2000);
		
		AddNewCustomer addNewCus=new AddNewCustomer(driver);
		addNewCus.clickAddNewCustomer();
		addNewCus.enterName("Tanzeel");
		logger.info("Customer name entered");
		addNewCus.enterGender("male");
		
		addNewCus.enterDOB("10","9","1994");
		logger.info("Date is entered");
		Thread.sleep(2000);
		addNewCus.enterAddress("Hanuman nagar");
		addNewCus.enterCity("Cuttack");
		addNewCus.enterState("Odisa");
		addNewCus.enterPIN("500937");
		addNewCus.enterTelPhNo("9999988888");
		
		String gmail=genRandomString().concat("@gmail.com");
		addNewCus.enterEMail(gmail);
		addNewCus.enterPasswrd("Hiroshima");
		logger.info("password is entered");
		Thread.sleep(3000);
		addNewCus.ClickOnSubmit();
		logger.info("clicked on submit");
		Thread.sleep(3000);
		boolean status=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		 CId=driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]")).getText();
		 logger.info("got text");
		Thread.sleep(2000);
		System.out.println(CId);
        
        
		if(status==true)
		{
			Assert.assertTrue(true);
			logger.info("New Customer added");
		}
		else
		{
			captureScreen(driver,"addingNewCustomer");
			Assert.assertTrue(false);
			logger.info("New Customer not added");
		}
		

		
	}
    
    @Test(priority=2)  
   	public void editCustomer() throws InterruptedException, IOException
   	{
    	
//   		LoginPage lp=new LoginPage(driver);
//   		
//   		lp.setUsername(username);
//   		logger.info("Username entered");
//   		lp.setPassword(password);
//   		logger.info("Password entered");
//   		lp.clickButton();
   		driver.manage().timeouts().pageLoadTimeout(160, TimeUnit.SECONDS);
   		Thread.sleep(400);
   		
   		EditCustomer ec=new EditCustomer(driver);
   		ec.clickEditButton();
   		Thread.sleep(2000);
   		ec.enterCusId(CId);
   		ec.clickCusIdSubmit();
   		Thread.sleep(2000);
   		ec.editCityName("Bhuvaneshwar");
   		logger.info("City is edited");
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
   		System.out.println(CId);
   	}
   		@Test(priority=3)
   		public void deleteCustomer() throws InterruptedException, IOException
   		{
//   			LoginPage lp=new LoginPage(driver);
//   			
//   			lp.setUsername(username);
//   			logger.info("Username entered");
//   			lp.setPassword(password);
//   			logger.info("Password entered");
//   			lp.clickButton();
   			driver.manage().timeouts().pageLoadTimeout(160, TimeUnit.SECONDS);
   			Thread.sleep(2000);
   			
   			DeleteCustomer dc=new DeleteCustomer(driver);
   		    dc.clickDelCustomer();
   		    Thread.sleep(2000);
   		    dc.enterCusId(CId);
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
   				
   				Assert.assertTrue(false);
   				logger.info("Deletion failed");
   			}
   			
   			
   			
   		}
   		
   	}


    
