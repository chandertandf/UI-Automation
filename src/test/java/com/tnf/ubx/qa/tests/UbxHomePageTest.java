package com.tnf.ubx.qa.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tnf.ubx.qa.base.TestBase;
import com.tnf.ubx.qa.pages.UbxHomePage;
import com.tnf.ubx.qa.pages.UbxSearchPage;
import com.tnf.ubx.qa.util.TestUtil;

public class UbxHomePageTest extends TestBase {
	
	UbxHomePage objHomepage;
	UbxSearchPage objSearchpage;
	Logger log = Logger.getLogger(UbxHomePageTest.class);
	
	public UbxHomePageTest() {
		super();
		
	}
	@BeforeMethod
	public void setup() {
		initialization();
		log.info("UbxHomePageTest");
		log.info("Starting the UbxHomePageTest");
		log.info("Initializing the WebDriver");
		objHomepage = new UbxHomePage(driver);
		
	}
	
	@Test(priority=0)
	public void test_search_title() {
		
		log.info(objHomepage.getTitle());
		TestUtil.captureScreenShot(driver,"homepage");
	}
	
	@Test(priority=1)
	public void test_searchItem() {
		try {
			objSearchpage = new UbxSearchPage(driver);
			objHomepage.searchItem(prop.getProperty("search"));
			log.info(objSearchpage.getDocumentName());
			TestUtil.captureScreenShot(driver,"searchpage");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
