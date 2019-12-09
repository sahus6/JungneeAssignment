package com.qa.junglee.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage
{
	@FindBy(xpath="//input[@class ='text-input text-input-md' and @type='text']")
	WebElement userName;

	@FindBy(xpath="//input[@class ='text-input text-input-md' and @type='password']")
	WebElement password;
	
	@FindBy(xpath="//span[@class='button-inner' and contains(text(),'Login')]")
	WebElement login;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public LobbyPage login(String username,String pswd)
	{
		userName.sendKeys(username);
		password.sendKeys(pswd);
		login.click();
		return new LobbyPage(driver);
	}
}
