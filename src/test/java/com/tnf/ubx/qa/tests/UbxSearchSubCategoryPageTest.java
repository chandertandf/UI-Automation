package com.tnf.ubx.qa.tests;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tnf.ubx.qa.base.TestBase;
import com.tnf.ubx.qa.pages.UbxDetailPage;
import com.tnf.ubx.qa.pages.UbxHomePage;
import com.tnf.ubx.qa.pages.UbxSearchPage;
import com.tnf.ubx.qa.pages.UbxSearchSubCategoryPage;
import com.tnf.ubx.qa.util.TestUtil;

public class UbxSearchSubCategoryPageTest extends TestBase {
	
	UbxHomePage objHomepage;
	UbxSearchPage objSearchpage;
	UbxSearchSubCategoryPage objSearchSubcat;
	TestUtil objutil;
	UbxDetailPage objdetail;
	SoftAssert assertion = new SoftAssert();
	Logger log = Logger.getLogger(UbxSearchSubCategoryPageTest.class);
	
	public UbxSearchSubCategoryPageTest() {
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
	
	@Test
	public void test_click_on_all_subResult_Container() throws InterruptedException {
		log.info(" ************ Test Started for Sub container ****************");
		objSearchSubcat = new UbxSearchSubCategoryPage(driver);
		objdetail = new UbxDetailPage(driver);
		List<WebElement> listTitle = objSearchpage.getBookListTitles();
		objutil.click_on_element(listTitle.get(0));
		List<WebElement> subContainer = objSearchSubcat.getSubResultContainerList();
		List<WebElement> authorNames = objSearchSubcat.getAuthorNameList();
		List<WebElement> editions = objSearchSubcat.getEditionList();
 		System.out.println(subContainer.size());
		for (int i=0; i<subContainer.size();i++){
			Thread.sleep(2000);
			String SummaryTitle = subContainer.get(i).getText();
			String SummaryArthor = authorNames.get(i).getText();
			String SummarEdition = editions.get(i).getText();
			log.info(" ************** Book Details *************");
			log.info(" Title : "+SummaryTitle);
			log.info(" Arthor : "+SummaryArthor);
			log.info(" Edition : "+SummarEdition);
			objutil.click_on_element(subContainer.get(i));
			Thread.sleep(2000);
			String DetailTitle = objdetail.getBannerSubTitle();
			String DetailAuthorName = objdetail.getAuthorName();
			String DetailEdition = objdetail.getEdition();
			assertion.assertEquals(SummaryTitle, DetailTitle);
			assertion.assertEquals(SummaryArthor, DetailAuthorName);
			assertion.assertEquals(SummarEdition.replace("|", "").trim(), DetailEdition);
			driver.navigate().back();
		}
		log.info(" ************ Test Ended for Sub container ****************");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
