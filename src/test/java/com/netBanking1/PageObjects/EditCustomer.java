package com.netBanking1.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomer 
{

	WebDriver ldriver;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[3]/a")
	WebElement editButton;
	
	@FindBy(name="cusid")
	WebElement CustId;
	
	@FindBy(name="AccSubmit")
	WebElement CustIdSubmit;
	
	@FindBy(xpath="//input[@name='city']")
	WebElement city;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement editSubmit;
	
	public void clickEditButton()
	{
		editButton.click();
	}
	
	public void enterCusId(String CusId)
	{
		CustId.sendKeys(CusId);
	}
	
	public void clickCusIdSubmit()
	{
		CustIdSubmit.click();
	}
	
	public void editCityName(String cityName) throws InterruptedException
	{
		city.clear();
		Thread.sleep(2000);
		city.sendKeys(cityName);
	}
	
	public void Submit_edit()
	{
		editSubmit.click();
	}
	
	public EditCustomer(WebDriver sdriver)
	{
		ldriver=sdriver;
		PageFactory.initElements(sdriver, this);
	}
}
