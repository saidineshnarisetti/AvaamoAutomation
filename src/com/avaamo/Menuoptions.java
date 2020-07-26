package com.avaamo;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Menuoptions extends LaunchBrowser{
	@Test(priority=4) 
	public void Testagentpopup() throws InterruptedException
	{		
		
		driver.switchTo().frame("avaamoIframe"); // focus switching to 'Test agent - IRA' iframe 
		driver.findElement(By.linkText("Download Motor Policy")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Download")).click();
		Thread.sleep(5000);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    Assert.assertEquals(driver.getTitle(), "IFFCO TOKIO - Online");
	    driver.close();
	    driver.switchTo().window(tabs2.get(0));
	    driver.switchTo().frame("avaamoIframe");
	    
	    Thread.sleep(5000);
	    
	    
	}
	@Test(priority=5) 
	public void verifyTestBot() throws InterruptedException
	{
		driver.findElement(By.linkText("Test Bot")).click();
//		driver.findElement(By.id("single_line_text-7903c808-d773-4704-8b4e-8d4f0736fa2e_f09235")).sendKeys("Dinesh");
//		driver.findElement(By.id("data_capture-7903c808-d773-4704-8b4e-8d4f0736fa2e_fe5134")).sendKeys("Bangalore");
//		driver.findElement(By.xpath("//*[@id=\"options-7903c808-d773-4704-8b4e-8d4f0736fa2e_7eba58\"]/label[1]/span[1]")).click();
	
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id=\"msg-114d01dc-6ace-4cd4-9db6-15cf3d2a4a11\"]/div/div[3]/button")).click();

	}
	@Test(priority=6) 
	public void verifyNewTest() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"messageEditor-region\"]/div/div[3]/div[2]/textarea")).sendKeys("New Test" + Keys.ENTER);
		Thread.sleep(3000);
		Assert.assertEquals(driver.findElement(By.linkText("Google")).isDisplayed(), true);
		driver.findElement(By.linkText("Google")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'×')]")).click();
		
		Assert.assertEquals(driver.findElement(By.linkText("Call")).isDisplayed(), true);
		driver.findElement(By.linkText("Call")).click();
		Thread.sleep(3000);
		
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    //Assert.assertEquals(driver.getTitle(), "IFFCO TOKIO - Online");
	    driver.close();
	    driver.switchTo().window(tabs.get(0));
	    Thread.sleep(3000);
	    driver.navigate().refresh();
	    driver.switchTo().defaultContent();
	    WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        driver.switchTo().alert().dismiss();
	   


	}

}
