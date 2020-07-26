package com.avaamo;

import java.io.File;	
import java.io.IOException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public abstract class LaunchBrowser {
	
	public static WebDriver driver=null;
	@Parameters({ "browser" })
	@BeforeTest
	public void opendriver(String browser) throws IOException {

		Reporter.log("Browser Choosen for testing:- " + browser);
		
		if(browser.equalsIgnoreCase("Firefox")){
					System.setProperty("webdriver.gecko.driver","src/drivers/geckodriver");
					driver = new FirefoxDriver();
					driver.manage().deleteAllCookies();
					driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("Chrome")){
					System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver");
					driver = new ChromeDriver();
					driver.manage().window().maximize();
		}
	}


	@AfterTest
	public void terminateBrowser(){
					driver.quit();
	}
}
