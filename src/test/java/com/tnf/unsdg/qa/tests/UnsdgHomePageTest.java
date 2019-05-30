package com.tnf.unsdg.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tnf.unsdg.qa.base.TestBase;
import com.tnf.unsdg.qa.pages.UnsdgHomePage;
import com.tnf.unsdg.qa.pages.UnsdgLoginPage;
import com.tnf.unsdg.qa.pages.UnsdgUploadCuratedContent;

public class UnsdgHomePageTest extends TestBase {
	
	UnsdgLoginPage objLogin;
	UnsdgHomePage objHomePage;
	UnsdgUploadCuratedContent objUploadCurated;
	
	public UnsdgHomePageTest() {
		super();
	}
	
	@BeforeTest
	public void setup() {
		initialization();
		objLogin = new UnsdgLoginPage(driver);
		//login to application
		objLogin.loginToUnsdg(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void test_Upload_Curated_Content_link() {
		objHomePage = new UnsdgHomePage(driver);
		objHomePage.click_Upload_Curated_Content();
		
		objUploadCurated = new UnsdgUploadCuratedContent(driver);
		//	System.out.println(objUploadCurated.getUploadCuratedContentName());
			Assert.assertEquals(objUploadCurated.getUploadCuratedContentName(), "Artifact Name*");
	}

}
