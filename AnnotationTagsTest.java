package TestNG.Programmes;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationTagsTest {
	@BeforeSuite
	public void method1()
	{
		System.out.println("I am inside before suit");
	}
@AfterSuite
	public void method2()
	{
		System.out.println("I am inside after suit");
	}
@BeforeClass
public void method3()
{
	System.out.println("I am inside before class");
}
@AfterClass
public void method4()
{
	System.out.println("I am inside after class");
}
@BeforeMethod
public void method5()
{
	System.out.println("I am inside before method");
}
	@AfterMethod
	public void method6()
	{
		System.out.println("I am inside after method");
	}
@Test(priority = 1)


public void method8() throws Exception
{
	System.out.println("I am inside Test");
	throw new Exception("I am throwing exception intensionally");
}
//see here mathod8 is intentionally failed usining throw exception and since method 7 deoendes on method8 result, it will also fail
@Test(dependsOnMethods="method7")
public void method7()
{
	System.out.println("I am inside Test");
}}
