package com.avaamo;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;




public class Titlevalidation extends LaunchBrowser{
	
	@Test(priority=2, invocationCount=1) 
	public void verifyTitle()
	{
		  String acttitle = driver.getTitle(); 
	      String exptitle = "Test agent - IRA";
	      Assert.assertEquals(acttitle, exptitle);
	      Assert.assertEquals(driver.getCurrentUrl().contains("avaamo"), true);
	}
	@Test(priority=3) 
	public void Testagentpopup() throws InterruptedException
	{		
		 driver.findElement(By.xpath("//img[@class='avm-bot-icon animated']")).click();
		 
		 Thread.sleep(5000);
		 String actchttitle =driver.findElement(By.xpath("//*[@id=\"avaamo__popup\"]/div[2]/div[1]/div/h3")).getText();
		 //driver.findElement(By.className("nav-input")).click();
		 //String actscrtitle = driver.getTitle(); 
		 String expchttitle = "Test agent - IRA\n" + 
		 		"IRA iffco tokio";
		 Assert.assertEquals(actchttitle, expchttitle);
		 String actwlcmmsg = driver.findElement(By.className("welcome-message")).getText();
		 String expwlcmmsg = "Hello and welcome to IRA agent";
		 Assert.assertEquals(actwlcmmsg, expwlcmmsg);
		 driver.findElement(By.className("get-started-link")).click();// clicking on getting started link
		 
	}
	
	

}
