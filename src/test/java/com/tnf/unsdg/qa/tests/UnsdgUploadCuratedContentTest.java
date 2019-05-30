package com.tnf.unsdg.qa.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tnf.unsdg.qa.base.TestBase;
import com.tnf.unsdg.qa.pages.UnsdgArtifactSubmitPage;
import com.tnf.unsdg.qa.pages.UnsdgHomePage;
import com.tnf.unsdg.qa.pages.UnsdgLoginPage;
import com.tnf.unsdg.qa.pages.UnsdgUploadCuratedContent;

public class UnsdgUploadCuratedContentTest extends TestBase {
	
	UnsdgLoginPage objLogin;
	UnsdgHomePage objHomePage;
	UnsdgUploadCuratedContent objUploadCurated;
	UnsdgArtifactSubmitPage objSubmitPage;
	Logger log = Logger.getLogger(UnsdgUploadCuratedContentTest.class);
	
	public UnsdgUploadCuratedContentTest() {
		super();
	}
	
	@BeforeTest
	public void setup() {
		initialization();
		objLogin = new UnsdgLoginPage(driver);
		//login to application
		log.info("Starting the webBrowser");
		objLogin.loginToUnsdg(prop.getProperty("username"), prop.getProperty("password"));
		log.debug("login in using username and password");
		objHomePage = new UnsdgHomePage(driver);
		log.debug("go to home page");
		objHomePage.click_Upload_Curated_Content();
	}
	
	@Test
	public void test_Upload_Curated_Content() {
		objSubmitPage = new UnsdgArtifactSubmitPage(driver);
		log.debug("go to upload content page");
		objUploadCurated = new UnsdgUploadCuratedContent(driver);
		objUploadCurated.setArtifactName(prop.getProperty("artifactname"));
		objUploadCurated.setFirstName(prop.getProperty("firstname"));
		objUploadCurated.setLastName(prop.getProperty("lastname"));
		objUploadCurated.selectType();
		objUploadCurated.setDOIChapter(prop.getProperty("doichapter"));
		objUploadCurated.selectCollection();
		objUploadCurated.setDOINumber(prop.getProperty("doinumber"));
		objUploadCurated.setDescription(prop.getProperty("discription"));
		objUploadCurated.selectGoals();
		objUploadCurated.selectSubGoals();
		objUploadCurated.selectDocument();
		objUploadCurated.uploadFile();
		Assert.assertEquals(objSubmitPage.getsubmitArtifactSuccessMessage(), "Artifact has been submitted.");
		log.debug("end of test");
	}

}
