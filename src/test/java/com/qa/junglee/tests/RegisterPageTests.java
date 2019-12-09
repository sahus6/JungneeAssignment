package com.qa.junglee.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.junglee.pages.BasePage;
import com.qa.junglee.pages.RegisterPage;
import com.qa.junglee.pages.StartPage;
import com.qa.junglee.utils.Constants;

public class RegisterPageTests
{
	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public RegisterPage registerPage;
	public StartPage startPage;
	public Actions actions;
	
	@BeforeMethod
	public void setUp()
	{
		basePage = new BasePage();
		prop = basePage.initProperties();
		driver = basePage.init(prop);
		startPage = new StartPage(driver);
		registerPage = startPage.clickRegister();
	}
	
	@Test
	public void registerPageTest()
	{
		String title = registerPage.getPageTitle();
		System.out.println("Register Page Title is :" + title);
		Assert.assertEquals(title.trim(), Constants.REGISTER_PAGE_TITLE.trim());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
