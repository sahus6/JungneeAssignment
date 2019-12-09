package com.qa.junglee.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.junglee.pages.StartPage;
import com.qa.junglee.pages.BasePage;
import com.qa.junglee.utils.Constants;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class StartPageTests
{
	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public StartPage startPage;
	public Actions actions;
	
	//only for test cases
	//set up - call init() and url
	//test -- test cases
	//tear down -- close the browser
	
	@BeforeMethod
	public void setUp()
	{
		basePage = new BasePage();
		prop = basePage.initProperties();
		driver = basePage.init(prop);
		startPage = new StartPage(driver);
	}
	
	@Test
	public void startPageTitleTest()
	{
		String title = startPage.getPageTitle();
		Assert.assertEquals(title.trim(), Constants.START_PAGE_TITLE.trim());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
