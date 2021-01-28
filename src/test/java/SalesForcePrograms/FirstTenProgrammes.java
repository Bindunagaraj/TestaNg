package SalesForcePrograms;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import SalesForce.SalesForceUtiliry;
import SalesForce.XLsheetReading;

public class FirstTenProgrammes extends SalesForceUtiliry {
	XLsheetReading excel = new XLsheetReading();
	ExtentReports extent;
	ExtentHtmlReporter htmlReport;
	String dateFormat;
	ExtentTest test;

	@BeforeClass
	public void initialise() throws IOException {
		launchBrowser(excel.readData("url"));
		dateFormat = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		extent = new ExtentReports();
		String htmlfilepath = "C:\\bindu folder\\TestNg Programmes\\Programmes\\resources\\Reports\\" + dateFormat
				+ "SalesForceReport.html";
		htmlReport = new ExtentHtmlReporter(htmlfilepath);
		extent.attachReporter(htmlReport);

	}

	@Test(priority = 1)
	public void Test1(Method name) throws IOException, InterruptedException {
		test = extent.createTest(name.getName());
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		username.sendKeys(excel.readData("Username"));
		waitTDisplayhardTime("//input[@id='password']");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.clear();
		byXpath("//input[@id='Login']");
		WebElement error = driver.findElement(By.xpath("//div[contains(text(),'Please enter your password.')]"));
		waitExplicitly(10, error);
		Thread.sleep(3000);
		test.info("Entered email");
		test.info("Din't enter password");
		if ((error.getText()).equals("Please enter your password.")) {
			test.log(Status.PASS, "Test1 passed");
			Assert.assertEquals(error.getText(), "Please enter your password.");
			//System.out.println("Test1 is passed");
		} else {
			test.log(Status.FAIL, "Test1 failed");
			test.addScreenCaptureFromPath(screenShot());
			Assert.assertEquals(error.isDisplayed(), false);
			//System.out.println("test1 is failed");
		}
	}
@Test(priority=2)
public void Test2(Method name) throws InterruptedException, IOException
{   
	test=extent.createTest(name.getName());
	logIn("//input[@id='username']","//input[@id='password']",excel.readData("Username"),excel.readData("Password"),"//input[@id='Login']");
	Thread.sleep(2000);
	WebElement home_page=driver.findElement(By.xpath("//a[normalize-space()='Home']"));
	test.info("correct username is entered");
	test.info("correct password is entered");
	if(home_page.getText().equals("Home"))
	{
		test.log(Status.PASS,"Second test ia pass");
		Assert.assertEquals(home_page.isDisplayed(), true);
	
	}
	else
	{
		test.log(Status.FAIL,"Second test case is fail");
		test.addScreenCaptureFromPath(screenShot());
		Assert.assertEquals(home_page.isDisplayed(),false);
	}
}
	@AfterClass
	public void closingAll() {
		extent.flush();
	}

}
