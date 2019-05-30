package com.tnf.unsdg.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tnf.unsdg.qa.base.TestBase;

public class UnsdgHomePage extends TestBase {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[contains(text(),'Dashboard')]")
	WebElement homePageName;
	
	@FindBy(xpath="//div[contains(text(),'Upload Curated Content')]")
	WebElement uploadcontent;
	
	
	public UnsdgHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getHomePageDashboardName(){
		 return	homePageName.getText();
		}

	
	public void click_Upload_Curated_Content() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(uploadcontent));
		uploadcontent.click();
	}

}
