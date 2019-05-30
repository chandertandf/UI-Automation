package com.tnf.unsdg.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tnf.unsdg.qa.util.TestUtil;


public class TestBase {
	
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		prop = new Properties();
		
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\lourd.chander\\workspace\\UNSDGUpdate\\src\\main\\java\\com\\tnf\\unsdg\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\lourd.chander\\Tricon\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\lourd.chander\\Tricon\\geckodriver-v0.24.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.InternetExplorerDriver.driver", "C:\\Users\\lourd.chander\\Tricon\\IEDriverServer.exe");
			//driver = new IEServerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	

}
