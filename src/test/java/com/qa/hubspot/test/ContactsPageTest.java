package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.basePage.BasePage;
import com.qa.hubspot.page.ContactsPage;
import com.qa.hubspot.page.HomePage;
import com.qa.hubspot.page.LoginPage;
import com.qa.hubspot.utility.Utility;

public class ContactsPageTest  {
	
	public BasePage basePage;
	public Properties pro;
	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public ContactsPage contactsPage;
	
	@BeforeMethod
	public void setUp()
	{
		basePage=new BasePage();
		pro=basePage.initialize_Property();
		driver=basePage.initialize_WebDriver();
		driver.get(pro.getProperty("url"));
		loginPage=new LoginPage(driver);
		homePage=loginPage.verifyLogin(pro.getProperty("username"), pro.getProperty("password"));
		contactsPage=homePage.verifyContactNavigation();
		
	}
	
	@DataProvider(name="getContact")
	public Object[][]getContactsData()
	{
		Object[][] contactsData=Utility.getData("Contacts");
		
		return contactsData;
		
	}
	
	@Test(dataProvider="getContact")
	public void testCreateContacts(String email, String fName, String lName, String job) throws InterruptedException
	{
		contactsPage.createContact(email, fName, lName, job);
		Thread.sleep(10000);
	}
	
@AfterMethod

	public void tearDown()
	{
		driver.quit();
	}
}

