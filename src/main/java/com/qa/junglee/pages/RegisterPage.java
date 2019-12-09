package com.qa.junglee.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage
{
	@FindBy(xpath="//input[@class ='text-input text-input-md' and @placeholder='Email or mobile']")
	WebElement userName;

	@FindBy(xpath="//input[@class ='text-input text-input-md' and @placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//input[@class ='text-input text-input-md' and @placeholder='Enter Referral Code']")
	WebElement referralCode;
	
	@FindBy(xpath="//span[@class='button-inner'  and contains(text(), 'Register')]")
	WebElement register;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public LobbyPage register(String username,String pswd, String refCode)
	{
		userName.sendKeys(username);
		password.sendKeys(pswd);
		referralCode.sendKeys(refCode);
		register.click();
		return new LobbyPage(driver);
	}

}
