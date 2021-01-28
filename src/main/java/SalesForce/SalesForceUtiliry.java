package SalesForce;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceUtiliry {
	public WebDriver driver;
	public String dateFormat;

	@BeforeSuite
	public void LaunchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		dateFormat=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
	 public void launchBrowser( String URL)
		{
			driver.get(URL);
			driver.manage().window().maximize();
		}
		public void waitExplicitly(int timeInSec ,WebElement ele)
		{  
			WebDriverWait wait=new WebDriverWait(driver, timeInSec);
			wait.until(ExpectedConditions.visibilityOf(ele));
			
			}
		public void logIn(String userXpath,String passwordXpath,CharSequence userkeys,CharSequence passwordKeys,String loginXpath) throws InterruptedException
	  {   
		  
		  waitExplicitly( 10, driver.findElement(By.xpath(userXpath)));
		  
		  WebElement e1=driver.findElement(By.xpath(userXpath));
		  waitTDisplayhardTime(userXpath);
		  e1.sendKeys(userkeys);
		  waitExplicitly(10, driver.findElement(By.xpath(passwordXpath)));
		 
		  WebElement e2=driver.findElement(By.xpath(passwordXpath));
		  waitTDisplayhardTime(passwordXpath);
		  e2.sendKeys(passwordKeys);
		  waitExplicitly(10, driver.findElement(By.xpath(loginXpath)));
		  waitTDisplayhardTime(loginXpath);
		  driver.findElement(By.xpath(loginXpath)).click();
		  
	  }
		public void bYId(String Id ,CharSequence keyss)
		{
			WebElement e=driver.findElement(By.id(Id));
			e.sendKeys(keyss);
			e.click();
		}
		public void byXpath(String xpath ) throws InterruptedException
		{
			
			waitExplicitly(20, driver.findElement(By.xpath(xpath)));
			WebElement e=driver.findElement(By.xpath(xpath));
			waitTDisplayhardTime(xpath);
			e.click();
			
		}
		public void byClassName(String className)
		{
			
			waitExplicitly(10, driver.findElement(By.className(className)));
			WebElement e=driver.findElement(By.className(className));
			e.click();
		}
		public void byLinkText(WebDriver driver,String link)
		{
			waitExplicitly(10,driver.findElement(By.linkText(link)));
			WebElement e=driver.findElement(By.linkText(link));
			e.click();
			
		}
		public void sendKeys(WebElement e, String string) {
			// TODO Auto-generated method stub
			e.sendKeys(string);
		}
		public void dropDown(String xpath,int index) throws InterruptedException
		{  
			
			waitExplicitly(20, driver.findElement(By.xpath(xpath)));
			waitTDisplayhardTime(xpath);
			Select se=new Select(driver.findElement(By.xpath(xpath)));//it is select tab and has alloptions inside it
			se.selectByIndex(index);
			
		}
		public void dropDown(String xpath,String text) throws InterruptedException
		{  
			waitExplicitly(20, driver.findElement(By.xpath(xpath)));
			waitTDisplayhardTime( xpath);
			Select se=new Select(driver.findElement(By.xpath(xpath)));//it is select tab and has alloptions inside it
			se.selectByValue(text);
			
			
		}
		public String screenShot() throws IOException
		{
			TakesScreenshot screenShot=(TakesScreenshot) driver;//its an interface used to take screenshot in selenium
			String ScreenShotPath="C:\\bindu folder\\TestNg Programmes\\Programmes\\resources\\ScreenShots\\"+dateFormat+"Screenshots.png";
			File sourceFile=screenShot.getScreenshotAs(OutputType.FILE);//u get screen shot as file
			File destinatinFile=new File(ScreenShotPath);
			FileUtils.copyFile(sourceFile, destinatinFile);
			return ScreenShotPath;
		}
	 public void waitTDisplayhardTime(String xpath) throws InterruptedException
	 {   int count=0;
		 boolean res_flag=true;
	 
		 while(res_flag)
		 {
			 try {
			 if(count==10)
				 res_flag=false;
			 driver.findElement(By.xpath(xpath));
			 res_flag=false;
			 }catch(Exception e)
			 {
				 count++;
				 Thread.sleep(1000);
			 }
		 }
	 }
	 @AfterSuite
	 public void close()
	 {
		 driver.quit();
		 
	 }
	
	

}
