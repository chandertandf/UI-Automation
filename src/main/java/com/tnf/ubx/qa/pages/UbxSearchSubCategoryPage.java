package com.tnf.ubx.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tnf.ubx.qa.base.TestBase;

public class UbxSearchSubCategoryPage extends TestBase {

	WebDriver driver;
	
	@FindBy(xpath="//div[@class='large-screen hidden-xs hidden-sm']//child::span[@class='result-count']")
	WebElement resultCount;
	
	@FindBy(xpath="//div[@class='large-screen hidden-xs hidden-sm']//child::div[@class='result-container']//child::a[@class='product-banner-title']")
	List<WebElement> subResultContainer;
	
	@FindBy(xpath="//div[@class='large-screen hidden-xs hidden-sm']//child::div[@class='result-container']//child::span[@class='product-banner-author-name']")
	List<WebElement> authorList;
	
	@FindBy(xpath="//div[@class='large-screen hidden-xs hidden-sm']//child::div[@class='product-banner-publication']/span[1]")
	List<WebElement> editionList;
	
	public UbxSearchSubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getResultCount() {
		return resultCount.getText();
	}
	
	public List<WebElement> getSubResultContainerList() {
		// System.out.println(" Size :"+subResultContainer.size());
		return subResultContainer;
	}
	
	public List<WebElement> getAuthorNameList() {
		return authorList;
	}
	
	public List<WebElement> getEditionList() {
		return editionList;
	}
	
}
