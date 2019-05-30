package com.tnf.unsdg.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tnf.unsdg.qa.base.TestBase;

public class UnsdgUploadCuratedContent extends TestBase {
	
	WebDriver driver;
	
	@FindBy(xpath="//label[contains(text(),' Artifact Name*')]")
	WebElement uploadCuratedPageName;
	
	@FindBy(id="material_title")
	WebElement artifactName;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//input[@type='radio' and @value='Case Studies']")
	WebElement categoryType;
	
	@FindBy(name="doi-chapter")
	WebElement chapterDOI;
	
	@FindBy(xpath="//input[@type='radio' and @value='UNSDGO']")
	WebElement collection;
	
	@FindBy(name="doi-no")
	WebElement chapterDOINumber;
	
	@FindBy(id="textarea_assetdesc")
	WebElement description;
	
	@FindBy(xpath="//input[@type='checkbox' and @value='Goal 1 : Poverty']")
	WebElement goals;
	
	@FindBy(xpath="//input[@type='checkbox' and @value='Poverty']")
	WebElement subCategorygoals;
	
	@FindBy(id="filetype_menu")
	WebElement selectDoc;
	
	@FindBy(id="fdocxi")
	WebElement uploadFile;
	
	public UnsdgUploadCuratedContent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getUploadCuratedContentName(){
		 return	uploadCuratedPageName.getText();
	}
	
	//Set Artifact Name in textbox
	public void setArtifactName(String artName){
		artifactName.sendKeys(artName);
	}		
	
	//Set First Name textbox
	public void setFirstName(String fName){
		firstName.sendKeys(fName);
	}
	//Set Last Name textbox
	public void setLastName(String lName){
		lastName.sendKeys(lName);
	}
	
	public void selectType() {
		categoryType.click();
	}
	
	//Set DOI Name textbox
	public void setDOIChapter(String doi){
		chapterDOI.sendKeys(doi);
	}
	
	public void selectCollection() {
		collection.click();
	}
	
	//Set DOI Number textbox
	public void setDOINumber(String doiNumber) {
		chapterDOINumber.sendKeys(doiNumber);
	}
	
	//Set Description textarea
	public void setDescription(String desc) {
		description.sendKeys(desc);
	}
	
	public void selectGoals() {
		goals.click();
	}
	
	public void selectSubGoals() {
		subCategorygoals.click();
	}
	
	public void selectDocument() {
		Select selectElement = new Select(selectDoc);
	    selectElement.selectByValue(prop.getProperty("filetype"));
	}
	
	public void uploadFile() {
		//uploadFile.sendKeys("C:\\Users\\lourd.chander\\Tricon\\TandF\\Test_Doc.docx");
		uploadFile.sendKeys(prop.getProperty("uploadfile"));
	}
	
}
