package com.tnf.unsdg.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tnf.unsdg.qa.base.TestBase;

public class UnsdgLoginPage extends TestBase {

	WebDriver driver;
	
	@FindBy(xpath="//span[contains(text(),'Login')]")
	WebElement login;
	
	@FindBy(id="inputEmail")
	WebElement emailId;
	
	@FindBy(id="inputPassword")
	WebElement password;
	
	@FindBy(id="loginBtn")
	WebElement submit;
	
	public UnsdgLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickonLogin() {
		login.click();
	}
	
	//Set user name in textbox
	public void setUserName(String strUserName){
		emailId.sendKeys(strUserName);
		}
		
	//Set password in password textbox
	public void setPassword(String strPassword){
		password.sendKeys(strPassword);
	}
		
	//Click on login submit button
	public void clickSubmit(){
			submit.click();
		}
		
	public void loginToUnsdg(String strUserName,String strPasword){
		this.clickonLogin();
		//Fill user name
		this.setUserName(strUserName);
		//Fill password
		this.setPassword(strPasword);
		//Click Login button
		this.clickSubmit();
			
	}
	
}
