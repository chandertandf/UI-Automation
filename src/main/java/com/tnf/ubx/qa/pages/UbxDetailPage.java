package com.tnf.ubx.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UbxDetailPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//product-titles[@class='product-title-container']//following-sibling::span[@class='product-banner-title']")
	WebElement bannerSubtitle;
	
	@FindBy(xpath="//product-content[@class='product-detail-container container']//child::span[@class='product-banner-author-name']")
	WebElement authorName;
	
	@FindBy(xpath="//span[@class='display-label'][contains(text(),'Edition')]//following-sibling::span[1]")
	WebElement edition;
	
	
	
	public UbxDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getBannerSubTitle() {
		return bannerSubtitle.getText();
	}
	
	public String getAuthorName() {
		return authorName.getText();
	}
	
	public String getEdition() {
		return edition.getText();
	}

}
