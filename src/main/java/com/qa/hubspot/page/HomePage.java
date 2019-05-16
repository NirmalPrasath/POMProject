package com.qa.hubspot.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.basePage.BasePage;
import com.qa.hubspot.constants.Contsants;
import com.qa.hubspot.utility.WaitUtil;

public class HomePage extends BasePage {
	
	
	@FindBy(className="private-page__title") WebElement header;
	
	@FindBy(id="nav-primary-contacts-branch") WebElement contactsTab;
	
	@FindBy(xpath="//*[@aria-owns='dropdown-4']") WebElement ShareButton;	
	
	@FindBy(id="nav-secondary-contacts") WebElement contactMenu;
	
	@FindBy(xpath="//div[@id='dropdown-menu-3']//button") List<WebElement> shareDD;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String verifyHomePageTitle()
	{
		WaitUtil.titleContains(driver, Contsants.HUBSPOT__HOMEPAGE_TITLE);
		return driver.getTitle();
		
	}
	
	public String verifyHomePageHeader()
	{
		return header.getText();
		
	}
	
	public boolean verifyShareList(String value)
	{
		
		boolean b = false;
		ShareButton.click();
		System.out.println(shareDD.size());
		for(int i=0;i<shareDD.size();i++)
		{
			System.out.println(shareDD.get(i).getText());
			if(shareDD.get(i).getText().equals(value));
			{
				//shareDD.get(i).click();
				b=true;
			}
		}
		
		return b;
		
	}
	
	public ContactsPage verifyContactNavigation()
	{
		
		if(contactsTab.isDisplayed())
		{
			contactsTab.click();
		
			if(contactMenu.isDisplayed())
			{
			
			contactMenu.click();
		
			}
		}
		return new 	ContactsPage(driver);	
	}
	
	
	
	
	

}
