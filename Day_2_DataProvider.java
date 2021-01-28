package TestNG.Programmes;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day_2_DataProvider extends SeleniumUtility{

	@BeforeTest
	public void OpenUrl() {
		gotToTeckarch();    
	
	}
	@Test(dataProvider="logInInData")
	public void logIn(String sEmail,String sPassword) throws InterruptedException
	{
		System.out.println(sEmail);
		System.out.println(sPassword);
		logInToTeckarch1(sEmail,sPassword); 
	}   
   @DataProvider(name="logInInData")	
   public  Object[][] loginInformation()  
   {   
	   Object[][] a= {{"admin123@gmail.com","admin123"} , {"admin@gmail.com","admin"}};
	   return a;
		 }
   
}
