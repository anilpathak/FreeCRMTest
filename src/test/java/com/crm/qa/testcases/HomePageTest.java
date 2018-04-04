package com.crm.qa.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		
	}
	
	@Test(priority =1)
	public void verifyHomePageTitleTest(){
		
		String homePageTitle = homepage.verifyHomePageTitle();
		System.out.println("_"+homePageTitle+"_");
		Assert.assertEquals(homePageTitle, "CRMPRO", "Homepage title mismatch");
		
	}
	
	@Test( priority =2 )
	public void verifyCorrectUserNameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());
		
	}
	
	@Test(priority = 3)
	public void verifyContactslinkTest(){
		testUtil.switchToFrame();
		contactsPage = homepage.clickOnContactsLink();
	}
	
	@AfterMethod()
	public void tearDown(){
		driver.quit();
	}

}
