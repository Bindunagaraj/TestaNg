package TestNG.Programmes;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Day_3_extentreportGenerating extends  SeleniumUtility{
	ExcelRead excel=new ExcelRead();
	 ExtentReports extent;
	 ExtentHtmlReporter htmlReport;
	 ExtentTest test;
	@BeforeClass
		 public void reportGenerator( )
		 {//dateformat generating
		String dateFormat=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());//creating new date everytime
		//initialise excel reports
			  extent=new ExtentReports();
			 //initialise html report
			 String htmlfilepath ="C:\\bindu folder\\TestNg Programmes\\Programmes\\resources\\Reports\\"+dateFormat+"report8.html";
			 ExtentHtmlReporter htmlReport=new ExtentHtmlReporter(htmlfilepath);
			 extent.attachReporter(htmlReport);
		 }
@AfterClass
public void closingAll()
{
	extent.flush();}
	
	@Test
	public void getURL() throws IOException
	{
		launchBrowser(excel.getData("url"));
	}
	@Test(priority = 1, dependsOnMethods ="getURL")
	public void userNameValidation(Method name) throws IOException, InterruptedException//reflect method gives nam eof the method
	{
		 test=extent.createTest(name.getName());
		WebElement ele1=driver.findElement(By.xpath("//input[@id='username']"));
		waitExplicitly(10,ele1);
		ele1.sendKeys(excel.getData("username"));
		WebElement ele2=driver.findElement(By.xpath("//input[@id='password']"));
		waitExplicitly(10,ele2);
		ele2.sendKeys(excel.getData("password"));
		byXpath("//input[@id='Login']");
		Thread.sleep(3000);
		WebElement ele3=driver.findElement(By.xpath("//a[normalize-space()='Home']"));
		Assert.assertEquals(ele3.isDisplayed(),true);
		  test.info("username is entered");
		  test.info("password is entered");
		  if(driver.findElement(By.xpath("//a[normalize-space()='Home']")).getText().equals("Home")) {
		  test.log(Status.PASS,"login is passed");
		  Assert.assertEquals(driver.findElement(By.xpath("//a[normalize-space()='Home']")).isDisplayed(),true);}
		  else
		  {
			  test.log(Status.FAIL,"Couldn't see home page");
		  }
		  
		 // test.log(Status.FAIL,"log in is not done");
		    
	}
	@Test(priority =0,dependsOnMethods = "getURL")
	public void PasswordValidation(Method name) throws InterruptedException, IOException {
		test=extent.createTest(name.getName());
		WebElement ele1=driver.findElement(By.xpath("//input[@id='username']"));
		waitExplicitly(10,ele1);
		ele1.sendKeys(excel.getData("username"));
		WebElement ele2=driver.findElement(By.xpath("//input[@id='password']"));
		waitExplicitly(10,ele2);
		ele2.sendKeys("hello");
		byXpath("//input[@id='Login']");
		Thread.sleep(3000);
		//WebElement ele3=driver.findElement(By.xpath("//a[normalize-space()='Home']"));
		//Assert.assertEquals(ele3.isDisplayed(),true);
		test.info("Wrong password is entered");
		if(driver.findElement(By.xpath("//div[@role='alert']")).getText().equals("Please check your username and password. If you still can't log in, contact your Salesforce administrator."))
		{
			test.log(Status.FAIL,"failed");
	    test.addScreenCaptureFromPath(Screenshot());
	    Assert.assertEquals(driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed(),true);
		}
		else
			test.log(Status.PASS,"login is passed");
		  
	}
	
	}


