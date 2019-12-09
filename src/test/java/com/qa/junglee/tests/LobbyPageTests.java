package com.qa.junglee.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.junglee.pages.BasePage;
import com.qa.junglee.pages.LobbyPage;
import com.qa.junglee.pages.LoginPage;
import com.qa.junglee.pages.RegisterPage;
import com.qa.junglee.pages.StartPage;
import com.qa.junglee.utils.Constants;

public class LobbyPageTests
{
	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public StartPage startPage;
	public LoginPage loginPage;
	public RegisterPage registerPage;
	public LobbyPage lobbyPage;
	public Actions actions;
	
	@BeforeMethod
	public void setUp()
	{
		basePage = new BasePage();
		prop = basePage.initProperties();
		driver = basePage.init(prop);
		startPage = new StartPage(driver);
	}
	
	@Test(priority = 2)
	public void loginTest()
	{
		loginPage = startPage.clickLogin();
		lobbyPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String title = lobbyPage.getPageTitle();
		System.out.println("Lobby Page Title is :" + title);
		Assert.assertEquals(title.trim(), Constants.LOBBY_PAGE_TITLE.trim());
	}
	
	@Test(priority = 1)
	public void registerTest()
	{
		registerPage = startPage.clickRegister();
		lobbyPage = registerPage.register(prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("referralCode"));
		String title = lobbyPage.getPageTitle();
		System.out.println("Lobby Page Title is :" + title);
		Assert.assertEquals(title.trim(), Constants.LOBBY_PAGE_TITLE.trim());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
