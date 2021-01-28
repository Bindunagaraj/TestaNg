package TestNG.Programmes;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XeWebsite extends SeleniumUtility{
	
	@Test
	public void Test1() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://www.xe.com/");
		driver.manage().window().maximize();
		
		WebElement ele2=driver.findElement(By.xpath("(//div[contains(@class,'__indicator converterform-dropdown__dropdown-indicator')])[1]"));
		waitExplicitly(10,ele2);
		ele2.click();
		Thread.sleep(3000);
		WebElement ele3=driver.findElement(By.xpath("//input[@name='From']"));
		waitExplicitly(10,ele3);
		Thread.sleep(3000);
		Select se=new Select(ele3);
		se.selectByIndex(3);
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();",ele3);
		//ele3.sendKeys("INR");
		//Thread.sleep(3000);
		
		
		//
	}

}
