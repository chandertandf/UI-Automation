package com.tnf.unsdg.qa.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tnf.unsdg.qa.base.TestBase;
import com.tnf.unsdg.qa.pages.UnsdgHomePage;
import com.tnf.unsdg.qa.pages.UnsdgLoginPage;

public class UnsdgLoginPageTest extends TestBase{
	
	UnsdgLoginPage objLogin;
	UnsdgHomePage objHomePage;
	
	public UnsdgLoginPageTest() {
		super();
	}
		
	@BeforeTest
	public void setup(){
		initialization();
	}

	@Test(priority=0)
	public void test_Home_Page_Appear_Correct(){
		objLogin = new UnsdgLoginPage(driver);
		//login to application
		objLogin.loginToUnsdg(prop.getProperty("username"), prop.getProperty("password"));
		
		objHomePage = new UnsdgHomePage(driver);
	//	System.out.println(objHomePage.getHomePageDashboardName());
		Assert.assertEquals(objHomePage.getHomePageDashboardName(), "Dashboard");
	}

}
