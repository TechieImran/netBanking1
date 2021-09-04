package com.netBanking1.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver ldriver;
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement textUsername;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement textPassword;
	
	@FindBy(name="btnLogin")
	WebElement button;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement LogOut;
	
	public void setUsername(String username)
	{
		textUsername.sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		textPassword.sendKeys(password);
	}
	
	public void clickButton()
	{
		button.click();
	}
	
	public void Logout_Button()
	{
		LogOut.click();
	}
	
	public LoginPage(WebDriver sdriver)
	{
		ldriver=sdriver;
		PageFactory.initElements(sdriver, this);
	}
	

}
