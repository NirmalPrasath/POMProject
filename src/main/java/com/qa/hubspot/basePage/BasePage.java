package com.qa.hubspot.basePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.hubspot.constants.Contsants;

import bsh.org.objectweb.asm.Constants;

public class BasePage {
	
	public WebDriver driver;
	public Properties pro;
	
	public WebDriver initialize_WebDriver()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		String browser=pro.getProperty("browser");
		
		System.out.println(browser);
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		browserWait();
	
		return driver;	
		
	}
	
	public Properties initialize_Property()
	{
		
		pro=new Properties();
		try {
			FileInputStream fis=new FileInputStream("C:\\Selenium\\MyWorkSpace\\POMSericesFM\\src\\main\\java\\com\\qa\\hubspot\\config\\config.properties");
		
		pro.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pro;
		
	}
	
	public void browserWait()
	{
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Contsants.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Contsants.PAGELOAD_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(Contsants.SETSCRIPTLOAD_WAIT, TimeUnit.SECONDS);
	}

}
