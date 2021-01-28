package UsingTestNgProjectCreation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;


  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("i am in before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("i am in aftermethod");
  }


 
  @BeforeClass
  public void beforeClass() {
	  System.out.println("i am in beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  
			System.out.println("i am in afterclass");
		
  }
  

  @BeforeTest
  public void beforeTest() {
	 
			System.out.println("i am in before test");
		
  }

  @AfterTest
  public void afterTest() {
	  
			System.out.println("i am in aftertest");
		
  }

  @BeforeSuite
  public void beforeSuite() {
	
			System.out.println("i am in before suit");
		}
  

  @AfterSuite
  public void afterSuite() {
	
			System.out.println("i am aftersuit");
		
  }
  

}
