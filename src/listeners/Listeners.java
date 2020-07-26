package listeners;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class Listeners extends TestListenerAdapter {
	File source;
	WebDriver driver=null;
	String filePath = "/Users/saidinesh/workspace/AppAutomation/screenshots";
	public void onTestStart(ITestResult result) {
		System.out.println( "Test case " + result.getName() + " started");
		
	}
	@Override  
	public void onTestSuccess(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Success of test cases and its details are : "+result.getName());  
	}  
	  
	@Override  
	public void onTestFailure(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Failure of test cases and its details are : "+result.getName());  
//	String methodName=result.getName().toString().trim();
//    ITestContext context = result.getTestContext();
//    WebDriver driver = (WebDriver)context.getAttribute("driver");
//	takeScreenShot(methodName, driver);
	}  
	  
	@Override  
	public void onTestSkipped(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Skip of test cases and its details are : "+result.getName());  
	}  
	  
	@Override  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Failure of test cases and its details are : "+result.getName());  
	}  
	
	public String  timestamp() {
	    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	public void takeScreenShot(String methodName, WebDriver driver) {
		
		  try {
			  source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source, new File(filePath+methodName+timestamp()+".png"));
				System.out.println("***Placed screen shot in "+filePath+" ***");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}


}
