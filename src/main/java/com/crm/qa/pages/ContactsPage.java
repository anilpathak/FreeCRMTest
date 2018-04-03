package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//td[text()[contains(.,'Contacts')]]")
	WebElement contactsLabel;
	
	@FindBy(name="title")
	WebElement titleDropDown;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="last_name")
	WebElement lastName;
	
	@FindBy(id="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@value='Save' and @type='submit' ]")
	WebElement saveBtn;
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	public void createNewContact( String title, String ftName, String ltname, String comp){
		Select select = new Select(titleDropDown);
		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltname);
		company.sendKeys(comp);
		saveBtn.click();
		
		
	}

}
