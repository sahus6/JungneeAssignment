package com.qa.junglee.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage extends BasePage 
{
	//webElements and features(methods) 
	//PageFactory web element

	@FindBy(xpath="//div[contains(text(), 'Login')]")
	WebElement loginBtn;

	@FindBy(xpath="//div[contains(text(), 'Register Now') and @class='top-cta hideinphone']")
	WebElement registerBtn;
	
	public StartPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public LoginPage clickLogin()
	{
		loginBtn.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage clickRegister()
	{
		registerBtn.click();
		return new RegisterPage(driver);
	}
}
