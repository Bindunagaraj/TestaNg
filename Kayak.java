package TestNG.Programmes;

import java.awt.Desktop.Action;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Kayak extends SeleniumUtility{
	
	ExcelRead  excel=new ExcelRead ();
	@BeforeClass
	public void launch() throws IOException
	{
		
		launchBrowser(excel.getData("kayakurl"));
	}
	
	@Test
	public void bookATicked() throws InterruptedException
	{
		
    BycssSelector("h2[class='title dark']");
    By.xpath("//div[contains(text(),'Flights')]");
    WebElement e4=driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/button[1]"));
    waitExplicitly(10,driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/button[1]")));
    Thread.sleep(3000);
    Actions actions=new Actions(driver);
    actions.click(e4);
    byXpath("/html[1]/body[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]");
   // driver.findElement(By.xpath("(//div[@role='list'])[9]"))
    WebElement e1=driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/div[1]"));
    waitExplicitly(10,e1);
    Thread.sleep(3000);
    try {
    	boolean displayed1=e1.isDisplayed();
    	if(displayed1)
    		System.out.println("can see from tab");
    	    WebElement e2=driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]"));
    	    waitExplicitly(10,e2);
    	    Thread.sleep(3000);
    		boolean displayed2=e2.isDisplayed();
    		System.out.println(displayed2);
    	    if(displayed2) {
			WebElement e3=driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]"));
			 byXpath("/html[1]/body[1]/div[4]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/button[1]");
			 WebElement bookFrom=driver.findElement(By.cssSelector("input[name='origin'][placeholder='From?']"));
			 waitExplicitly(30, bookFrom);
			 bookFrom.sendKeys("SAN");
    	    }
		
	} catch (Exception e) {
		System.out.println("From is not seen");
	}
   
	
	
	Thread.sleep(3000);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("input[name='origin'][placeholder='From?']")));
	Thread.sleep(3000);
	
	}
}
