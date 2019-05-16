package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.basePage.BasePage;
import com.qa.hubspot.constants.Contsants;
import com.qa.hubspot.page.LoginPage;

public class LoginTest {
public BasePage basePage;
public LoginPage loginPage;
public WebDriver driver;
public Properties pro;

@BeforeMethod
public void setUp()
{
	basePage=new BasePage();
	pro=basePage.initialize_Property();
	driver=basePage.initialize_WebDriver();
	driver.get(pro.getProperty("url"));
	loginPage=new LoginPage(driver);
	//uiLoading uiLoading-grow uiLoadingDot dot-1
}

@Test(priority=1)
public void titleTest()
{
	String title=loginPage.verifyPageTitle();
	System.out.println(title);
	Assert.assertEquals(title, Contsants.HUBSPOT__LOGINPAGE_TITLE);
	
}

@Test(priority=2)
public void signUpLinkTest()
{
	boolean val=loginPage.verifySignupLink();
	Assert.assertTrue(val);
}

@Test(priority=3)
public void loginTest()
{
	loginPage.verifyLogin(pro.getProperty("username"), pro.getProperty("password"));
}


@AfterMethod
public void tearDown()
{
	driver.quit();
}

}
