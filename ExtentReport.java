package TestNG.Programmes;

import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	ExtentReports extent;
	 ExtentHtmlReporter htmlReport;
	 ExtentTest test;
	@BeforeClass
	 public void reportGenerator( )
	 {   //initialise excel reports
		  extent=new ExtentReports();
		 //initialise html report
		 String htmlfilepath ="C:\\bindu folder\\TestNg Programmes\\Programmes\\resources\\Reports\\report2.html";
		 ExtentHtmlReporter htmlReport=new ExtentHtmlReporter(htmlfilepath);
		 extent.attachReporter(htmlReport);
	 }
@AfterClass
public void closingAll()
{
extent.flush();}
@Test(priority = 1)
public void test1(Method name)
{
	test=extent.createTest(name.getName());
	test.info("test1");
	test.log(Status.PASS,"I am pass");
	}
@Test(priority = 2)
public void test2(Method name)
{

	test=extent.createTest(name.getName());
	test.info("test2");
	test.log(Status.FAIL,"I am failed");
	}

	

}
