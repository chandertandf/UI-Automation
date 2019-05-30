package com.tnf.ubx.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tnf.ubx.qa.base.TestBase;

public class UbxSearchPage extends TestBase {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='filter-by']")
	WebElement searchDocName;
	
	@FindBy(xpath="//div[@class='publicationTitle' and contains(text(),' SUBJECT ')]")
	WebElement publicationTitle;
	
	@FindBy(xpath="//span[@class='count']")
	List<WebElement> listBookCounts;
	
	@FindBy(xpath="//span[@class='text-value ellipsis']")
	List<WebElement> listBookTitles;
	
	
	public UbxSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getDocumentName() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(searchDocName));
		return searchDocName.getText();
	}
	
	public String getPublicationTitle() {
		return publicationTitle.getText();
	}
	
	public List<WebElement> getBookListCounts() {
		// System.out.println(" Size :"+listBookCounts.size());
		return listBookCounts;
	}
	public List<WebElement> getBookListTitles() {
		// System.out.println(" Size :"+listBookTitles.size());
		return listBookTitles;
	}

}
