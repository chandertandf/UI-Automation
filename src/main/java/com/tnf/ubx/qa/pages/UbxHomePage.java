package com.tnf.ubx.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tnf.ubx.qa.base.TestBase;

public class UbxHomePage extends TestBase {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='form-group text-left']//child::input[@id='searchTerm']")
	WebElement searchItem;
	
	@FindBy(xpath="//div[@class='form-group text-left']//child::i[@id='searchButton']")
	WebElement clickSearch;
	
	public UbxHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void searchItem(String search) {	
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(searchItem));
		searchItem.sendKeys(search);
		clickSearch.click();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
}
