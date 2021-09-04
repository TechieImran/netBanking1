package com.netBanking1.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomer
{

	WebDriver ldriver;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[4]/a")
	WebElement delCustomer;
	
	@FindBy(name="cusid")
	WebElement cusId;
	
	@FindBy(name="AccSubmit")
	WebElement CusId_Submit;
	
	public void clickDelCustomer()
	{
		delCustomer.click();
	}
	
	public void enterCusId(String custId)
	{
		cusId.sendKeys(custId);
	}
	
	public void click_CusId_Submit() 
	{
		CusId_Submit.click();
			
	}
	
	public DeleteCustomer(WebDriver sdriver)
	{
		ldriver=sdriver;
		PageFactory.initElements(sdriver, this);
	}
	
	
}
