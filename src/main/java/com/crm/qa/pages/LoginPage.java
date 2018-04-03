package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory for the login page
	@FindBy(name ="username")
	WebElement username;
	
	@FindBy(name ="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign up')")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[@alt='free crm logo']")
	WebElement crmLogo;
	
	//initializing the Page Objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginTitlePage(){
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
		
	}
	
	public HomePage login( String un, String pwd) throws InterruptedException{
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(4000);
		loginBtn.click();
		
		return new HomePage();
	}

}
