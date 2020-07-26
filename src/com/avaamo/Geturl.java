package com.avaamo;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Geturl extends LaunchBrowser{
	@Parameters({ "url" })
	@Test(priority = 1)
	     public void Url(String url) throws InterruptedException, IOException{
	     driver.get(url);
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     driver.getTitle();

	                          String list= driver.getCurrentUrl();
	                          Getstatus s =new Getstatus();
	                          int res =Getstatus.getStatus(list, "GET");                     
	                          Reporter.log(driver.getTitle()+"-"+res);
	                          Assert.assertEquals(200, res);
	           }
	}




