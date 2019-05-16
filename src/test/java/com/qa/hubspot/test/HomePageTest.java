package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.basePage.BasePage;
import com.qa.hubspot.constants.Contsants;
import com.qa.hubspot.page.HomePage;
import com.qa.hubspot.page.LoginPage;

public class HomePageTest {
	
	public BasePage basePage;
	public Properties pro;
	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	
	@BeforeMethod
	public void setUp()
	{
		basePage=new BasePage();
		pro=basePage.initialize_Property();
		driver=basePage.initialize_WebDriver();
		driver.get(pro.getProperty("url"));
		loginPage=new LoginPage(driver);
		homePage=loginPage.verifyLogin(pro.getProperty("username"), pro.getProperty("password"));
	}
	
	@Test(priority=1)
	public void homePageTitleTest()
	{
		String title=homePage.verifyHomePageTitle();
		Assert.assertEquals(title, Contsants.HUBSPOT__HOMEPAGE_TITLE, "Title not valid");
	}
	
	@Test(priority=2)
	public void  homePageHeaderTest()
	{
		String header=homePage.verifyHomePageHeader();
		Assert.assertEquals(header, "Marketing Dashboard" , "Header not valid");
	}

	@Test(priority=3)
	public void  homePageShareDDTest()
	{
		boolean b=homePage.verifyShareList("Create recurring email");
		Assert.assertTrue(b);
	}
	
	
	@Test(priority=4)
	public void  homePageContactsTabTest()
	{
		homePage.verifyContactNavigation();
		
	}
	

	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
