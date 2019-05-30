package com.tnf.unsdg.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tnf.unsdg.qa.base.TestBase;

public class UnsdgArtifactSubmitPage extends TestBase {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='thank-you']/p[1]")
	WebElement submitText;
	
	@FindBy(id="slide_start_button")
	WebElement submitAnotherArtifact;
	
	@FindBy(id="slide_stop_button")
	WebElement gotoListingPage;
	
	public UnsdgArtifactSubmitPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getsubmitArtifactSuccessMessage() {
		return	submitText.getText();
	}
	
	public void clickOnSubmitAnotherArtifact() {
		submitAnotherArtifact.click();
	}
	
	public void clickOnGotoListingPage() {
		gotoListingPage.click();
	}

}
