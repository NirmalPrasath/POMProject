package com.qa.hubspot.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.basePage.BasePage;
import com.qa.hubspot.utility.WaitUtil;

public class ContactsPage extends BasePage {
	
	
	@FindBy(xpath="//span[text()='Create contact']") WebElement createContactBtn;
	
	@FindBy(xpath="//input[@data-field='email']") WebElement email;
	
	@FindBy(xpath="//input[@data-field='firstname']") WebElement firstName;
	
	@FindBy(xpath="//input[@data-field='lastname']") WebElement lastName;
	@FindBy(xpath="//input[@data-field='jobtitle']") WebElement jobTitle;
	@FindBy(xpath="//button/span[text()='Create contact']") WebElement createButton;
	
	
	
	public ContactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void createContact(String emai, String fName, String lName, String jobTit)
	{
		WaitUtil.elementtoBeClickable(driver, createContactBtn);
		createContactBtn.click();
		WaitUtil.mediumWait();
		email.sendKeys(emai);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		WaitUtil.elementtoBeClickable(driver, jobTitle);
		jobTitle.sendKeys(jobTit);
		
		WaitUtil.elementtoBeClickable(driver, createButton);
		createButton.click();
		WaitUtil.shortWait();
	}

}
