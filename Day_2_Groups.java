package TestNG.Programmes;

import org.testng.annotations.Test;

public class Day_2_Groups {
	
	@Test(groups = {"sanity"})
	public void methodA()
	{
		
	}

	@Test(groups = {"regression"})
	public void methodB()
	{
		}

	@Test(groups = {"sanity" ,"regression"})
	public void methodC()
	{
		}

	@Test(groups = {"sanity"})
	public void methodD()
	{
		}
	
@Test(groups= {"sanity"})
public void Test1() {
	System.out.println("Inside Test1");
}
@Test(groups= {"regression"})
public void Test2() {
	System.out.println("Inside Test2");
}
@Test(groups= {"sanity","regression"})
public void Test3() {
	System.out.println("Inside Test3");
}
@Test
public void Test4() {
	System.out.println("Inside Test4");
}
}