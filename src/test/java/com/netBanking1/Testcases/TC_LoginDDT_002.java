package com.netBanking1.Testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.netBanking1.PageObjects.LoginPage;
import com.netBanking1.Utilities.XLUtils;
//import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
public class TC_LoginDDT_002 extends BaseClass
{
    @Test(dataProvider="LoginData")
	public void Login_Test(String usrName,String psword) throws Exception
	{
    	 
    	LoginPage lp=new LoginPage( driver);
    	lp.setUsername(usrName);
    	logger.info("Username provided");
    	lp.setPassword(psword);
    	logger.info("Password provided");
    	lp.clickButton();
    	
    	if(toChechkAlert()==true)
    	{
    		
    		Thread.sleep(3000);
    		logger.warn("Login failed");
    		driver.switchTo().alert().accept();
    		driver.switchTo().defaultContent();
    		Assert.assertTrue(false);
    		
    		
       	}
    	else
    	{
    		Assert.assertTrue(true);
    		logger.info("Logged in successfully");
    		lp.Logout_Button();
    		Thread.sleep(3000);
    		driver.switchTo().alert().accept();
    		driver.switchTo().defaultContent();
    		
    	}
		
	}
    
    
    public boolean toChechkAlert()
    {
    	try
    	{
    		driver.switchTo().alert();
    		return true;
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
    }
	
    @DataProvider(name="LoginData")
    String[][] getData() throws IOException
    {
    	String path=System.getProperty("user.dir")+"/src/test/java/com/netBanking1/TestData/LoginData.xlsx";
    	int rowNum=XLUtils.getRowCount(path, "Sheet1");
    	int cellNum=XLUtils.getCellCount(path, "Sheet1");
    	String[][] Storage=new String[rowNum][cellNum];
    	for(int i=1;i<=rowNum;i++)
    	{
    		for(int j=0;j<cellNum;j++)
    		{
    			Storage[i-1][j]=XLUtils.getCellValue(path, "Sheet1", i, j);
    		}
    		
    	}
    	
    	return Storage;
    }
}
