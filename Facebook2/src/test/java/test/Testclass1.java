package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testclass1 
{
	@BeforeSuite
	public void beforesuit() {
		System.out.println("Before Suite");
	}
	
	@BeforeTest
	@Parameters("testData")
	public void BeforeTest(String data) {
		System.out.println("Before Test");
	}

	@BeforeClass
	public void beforeclass() {
		System.out.println("Before class");
	}

	@BeforeMethod
	public void beforemethod() {
		System.out.println("Before Method");
	}
	
	@Test
	public void test1() {
		System.out.println("Test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("Test 2");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After class");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}
	
	@AfterSuite
	public void aftersuit() {
		System.out.println("After Suite");
	}
}
