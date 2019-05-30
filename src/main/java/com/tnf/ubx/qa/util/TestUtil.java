package com.tnf.ubx.qa.util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class TestUtil {
	
	WebDriver driver;
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public TestUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public void click_on_element(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	//	System.out.println(" Locator : "+element.getLocation()+" Element :"+element);
		Point point1 = element.getLocation();
		((JavascriptExecutor)driver).executeScript("return window.title;");
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+(point1.getY())+");");

		element.click();
	}
	
	public void click_on_elementAction(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOf(element));
		Point point1 = element.getLocation();
		JavascriptExecutor js = (JavascriptExecutor) driver; 
	    js.executeAsyncScript("arguments[0].scrollIntoView(true)", element);
	    js.executeAsyncScript("window.scrollBy(0,"+(point1.getY())+");");

		element.click();
	}
	
	public static void captureScreenShot(WebDriver ldriver, String FileName){
		// Take screenshot and store as a file format             
		 File src=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);           
		// now copy the  screenshot to desired location using copyFile method
		try {
			Files.copy(src, new File(System.getProperty("user.dir")+"\\src\\main\\java\\Screenshots"+FileName+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 
		}

}
