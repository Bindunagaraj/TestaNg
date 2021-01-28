package TestNG.Programmes;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day_2_DataProviderUSingExcel extends SeleniumUtility {
	
	ExcelLogINCredentials exceldata=new ExcelLogINCredentials();
	@Test(dataProvider ="ExcelDAta" )
	public void hitlogIn(String username , String password) throws InterruptedException
	{
		launchBrowser("https://qa-tekarch.firebaseapp.com/");
		logInToTeckarch1(username, password);
	}
   @DataProvider(name="ExcelDAta")
   public Object[][] dataProvideByExcel() throws IOException
   {
	  Object[][] data= exceldata.credentials();
	  return data;
   }
}
