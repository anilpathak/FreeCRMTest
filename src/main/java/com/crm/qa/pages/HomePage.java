package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[@align='left' and @class='headertext']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	// Initialize the Home Page
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
		
	}
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
		
	}
	
	public ContactsPage clickOnContactsLink(){
		contactsLink.clear();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		dealsLink.clear();
		return new DealsPage();
	}
	
	public TasksPage clickOnTaskslink(){
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactlink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}

}
