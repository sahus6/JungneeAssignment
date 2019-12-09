package com.qa.junglee.pages;

import java.io.FileInputStream;
import org.apache.log4j.Logger;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.junglee.utils.Constants;

import listeners.WebEventListener;

public class BasePage
{
	WebDriver driver;
	Properties prop;
	//To capture all the events
	EventFiringWebDriver eDriver;
	WebEventListener eventListener;
	
	// Creating logger object to attach customized logs
	public static final Logger log = Logger.getLogger(BasePage.class);
	
	public WebDriver init(Properties prop)
	{
		//Initializing driver
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICITE_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		log.info("All cookies deleted");
		driver.manage().window().maximize();
		log.info("Window Maximized");
		
		eDriver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		eDriver.register(eventListener);
		driver = eDriver;
		log.info("Entering Start page URL");
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	public Properties initProperties()
	{
		prop = new Properties();
		try
		{
			FileInputStream in = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\junglee\\configuration\\config.properties");
			prop.load(in);
			log.info("Loading properties file");
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}
	
}
