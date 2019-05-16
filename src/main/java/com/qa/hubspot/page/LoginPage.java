package com.qa.hubspot.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.basePage.BasePage;
import com.qa.hubspot.constants.Contsants;
import com.qa.hubspot.utility.WaitUtil;

public class LoginPage extends BasePage {
	
	@FindBy(id="username") WebElement emailId;
	@FindBy(xpath="//input[@id='password']") WebElement password;
	@FindBy(css="#loginBtn") WebElement loginButton;
	@FindBy(linkText="Sign up") WebElement signup;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}

	
	public String verifyPageTitle()
	{
		WaitUtil.titleContains(driver, Contsants.HUBSPOT__LOGINPAGE_TITLE);
		String title=driver.getTitle();
		return title;
		
	}
	
	public boolean verifySignupLink()
	{
		
		boolean signUPLink=signup.isDisplayed();
		return signUPLink;	
		
	}
	
	public HomePage verifyLogin(String uname, String pword)
	{
		emailId.sendKeys(uname);
		password.sendKeys(pword);
		loginButton.click();
		return new HomePage(driver);
		
	}
	

}
