package com.netBanking1.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer 
{
    WebDriver ldriver;
	
    @FindBy(how=How.XPATH,using="/html/body/div[3]/div/ul/li[2]/a")
     WebElement newCustButton;
	
    @FindBy(how=How.XPATH,using="//input[@name='name']")
    WebElement cusName;
    
    @FindBy(how=How.NAME,using="rad1")
    WebElement cusGender;
	
    @FindBy(how=How.ID,using="dob")
    WebElement cusDOB;
    
    @FindBy(how=How.XPATH,using="//textarea[@name='addr']")
    WebElement cusAddress;
    
    @FindBy(how=How.XPATH,using="//input[@name='city']")
    WebElement cusCity;
    
    @FindBy(how=How.XPATH,using="//input[@name='state']")
    WebElement cusState;
    
    @FindBy(how=How.NAME,using="pinno")
    WebElement cusPinCode;
    
    @FindBy(how=How.NAME,using="telephoneno")
    WebElement cusTelPhoneNo;
    
	@FindBy(how=How.NAME,using="emailid")
	WebElement cusEmailId;
	
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	WebElement cusPassword;
	
	@FindBy(how=How.XPATH,using="/html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[1]")
	WebElement ClickSubmit;
	
	public void clickAddNewCustomer()
	{
		newCustButton.click();
	}
	
	public void enterName(String Name)
	{
		
		cusName.sendKeys(Name);
		
	}
	
	public void enterGender(String gender)
	{
		cusGender.click();
	}
	
	public void enterDOB(String dd,String mm,String yy)
	{
		cusDOB.sendKeys(dd);
		cusDOB.sendKeys(mm);
		cusDOB.sendKeys(yy);
		
	}
	
	public void enterAddress(String Address)
	{
		cusAddress.sendKeys(Address);
	}
	
	public void enterCity(String City)
	{
		cusCity.sendKeys(City);
	}
	
	public void enterState(String State)
	{
		cusState.sendKeys(State);
	}
	
	public void enterPIN(String PIN)
	{
		cusPinCode.sendKeys(PIN);
	}
	
	public void enterTelPhNo(String TelPhNo)
	{
		cusTelPhoneNo.sendKeys(TelPhNo);
	}
	
	public void enterEMail(String EMail)
	{
		cusEmailId.sendKeys(EMail);
	}
	
	public void enterPasswrd(String PassWord)
	{
		cusPassword.sendKeys(PassWord);
	}
	
	public void ClickOnSubmit()
	{
		ClickSubmit.click();
	}
	
	public AddNewCustomer(WebDriver sdriver) 
	{
	
		ldriver=sdriver;
		PageFactory.initElements(sdriver, this);
	}
    
}
