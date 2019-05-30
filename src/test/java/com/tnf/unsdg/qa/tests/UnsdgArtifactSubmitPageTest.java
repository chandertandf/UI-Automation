package com.tnf.unsdg.qa.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tnf.unsdg.qa.base.TestBase;
import com.tnf.unsdg.qa.pages.UnsdgArtifactSubmitPage;
import com.tnf.unsdg.qa.pages.UnsdgHomePage;
import com.tnf.unsdg.qa.pages.UnsdgLoginPage;
import com.tnf.unsdg.qa.pages.UnsdgUploadCuratedContent;

public class UnsdgArtifactSubmitPageTest extends TestBase {
	
	Logger logger;
	UnsdgLoginPage objLogin;
	UnsdgHomePage objHomePage;
	UnsdgUploadCuratedContent objUploadCurated;
	UnsdgArtifactSubmitPage objSubmitPage;
	
	public UnsdgArtifactSubmitPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		logger = Logger.getLogger("devpinoyLogger");
		objLogin = new UnsdgLoginPage(driver);
		//login to application
		logger.debug("Starting the webBrowser");
		objLogin.loginToUnsdg(prop.getProperty("username"), prop.getProperty("password"));
		logger.debug("login in using username and password");
		objHomePage = new UnsdgHomePage(driver);
		logger.debug("go to home page");
		objHomePage.click_Upload_Curated_Content();
		
	}
	
	@Test
	public void test_artifact_submit_result() {
		objSubmitPage = new UnsdgArtifactSubmitPage(driver);
		objSubmitPage.clickOnGotoListingPage();
	}
	
	

}
