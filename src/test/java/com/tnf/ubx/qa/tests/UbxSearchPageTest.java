package com.tnf.ubx.qa.tests;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tnf.ubx.qa.base.TestBase;
import com.tnf.ubx.qa.pages.UbxHomePage;
import com.tnf.ubx.qa.pages.UbxSearchPage;
import com.tnf.ubx.qa.pages.UbxSearchSubCategoryPage;
import com.tnf.ubx.qa.util.TestUtil;

public class UbxSearchPageTest extends TestBase {
	
	UbxHomePage objHomepage;
	UbxSearchPage objSearchpage;
	UbxSearchSubCategoryPage objSearchSubcat;
	TestUtil objutil;
	SoftAssert assertion = new SoftAssert();
	Logger log = Logger.getLogger(UbxSearchSubCategoryPageTest.class);
	
	public UbxSearchPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		log.info(" Initializing the browser");
		objHomepage = new UbxHomePage(driver);
		objSearchpage = new UbxSearchPage(driver);
		objHomepage.searchItem(prop.getProperty("search"));
		objutil = new TestUtil(driver);
	}
	
	
	@Test(enabled = true)
	public void test_click_on_all_element() throws InterruptedException {
		log.info(" ************ Test Started for All Book Element ****************");
		log.info(" Document Name : "+objSearchpage.getDocumentName());
		List<WebElement> list = objSearchpage.getBookListCounts();
		List<WebElement> listTitle = objSearchpage.getBookListTitles();
		for (int i=0; i<list.size();i++){
			log.info(" ************** Book Details *************");
			objSearchSubcat = new UbxSearchSubCategoryPage(driver);
			Thread.sleep(2000);
			log.info(" Document Title : "+listTitle.get(i).getText()+" :" + list.get(i).getText());
		     int result = Integer.parseInt(list.get(i).getText().replaceAll(",", ""));
			 objutil.click_on_element(list.get(i));
			 Thread.sleep(3000);
			 int detail = Integer.parseInt(objSearchSubcat.getResultCount().replaceAll(",", ""));
			 assertion.assertEquals(result, detail);
			 driver.navigate().back();
		}
		log.info(" ************ Test Ended for All Book Element ****************");
	} 
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	

}
