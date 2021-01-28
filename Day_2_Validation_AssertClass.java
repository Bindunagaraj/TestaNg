package TestNG.Programmes;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day_2_Validation_AssertClass extends SeleniumUtility{

	@BeforeTest
	public void OpenUrl() throws InterruptedException {
		gotToTeckarch();
		logInToTeckarch(); 
	}
	
	@Test(priority=1)
	public void radioButton1() throws InterruptedException
	{  
		System.out.println("I ma in priority 1");
		waitExplicitly( 10,driver.findElement(By.xpath("//input[@value='male']")));
		driver.findElement(By.xpath("//input[@value='male']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//input[@value='male']")).isSelected(),true,"Yes, button is clicked on male");
	}
	@Test(priority=2)
	public void radiobutton2() throws InterruptedException
	{   
		System.out.println("I ma in priority 2");
		waitExplicitly( 10,driver.findElement(By.xpath("//input[@value='female']")));
		driver.findElement(By.xpath("//input[@value='female']")).click();
	}

}
