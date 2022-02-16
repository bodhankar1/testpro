package test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;

import pom.FacebookHeader;
import pom.ForFriendRequest;
import pom.LoginPageofFacebook;
import utils.Utility;

public class validateTestcaseForFacebook extends browser
{
	private WebDriver driver;
	private LoginPageofFacebook loginPage;
	private ForFriendRequest forFriendRequest;
	private FacebookHeader facebookHeader;
	private SoftAssert   softAssert;
	private int testID;
	
     @BeforeTest
     @Parameters("browser")
     public void LaunchtheBrowser(String browser) 
     {
    	 
    	System.out.println(" browser");
    	
    	if(browser.equalsIgnoreCase("chrome")) {
    		 driver=launchtheChromeBrowser();
    	}
    	
    	if(browser.equalsIgnoreCase("firefox")) {
    		driver=launchtheFirefoxBrowser();
    	}
    	 
 		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 	 	driver.manage().window().maximize();
     }
     
     @BeforeClass
     public void createPOMobject() {
    	  loginPage=new LoginPageofFacebook(driver);
     	  forFriendRequest=new ForFriendRequest(driver);
     	  facebookHeader=new FacebookHeader(driver);
     }
     
     @BeforeMethod
     public void validateForLogin() throws EncryptedDocumentException, IOException 
     {
    	System.out.println("valid credintials");
    	driver.get("https://www.facebook.com/");
    	
    	String usename=Utility.getDataFromExcel("Sheet1", 1, 0);
     	loginPage.forEmail( usename);
    	
    	String pass=Utility.getDataFromExcel("Sheet1", 1, 1);
 		loginPage.forPassword(pass);
 		
 		loginPage.forLogin();
     }
     
     @Test
     public void ValidateForHomePage()
     {
    	 testID=101;
    	 System.out.println("homepage");
         String url= driver.getCurrentUrl();
         String title=driver.getTitle();
         
      /*  //hard assert
         Assert.assertEquals(url, "https://www.facebook.com/");
         System.out.println("yes");
         Assert.assertEquals(title, "Facebook");*/
         
         //soft assert
         softAssert =new  SoftAssert();
         softAssert.assertEquals(url, "https://www.faceboocom/");
         System.out.println("yes");
         softAssert.assertEquals(title, "Facebook");
         softAssert.assertAll();
         
         
         
         
        /* if(url.equals("https://www.facebook.com/"))
         {
        	 System.out.println("pass");
         }
         else 
         {
        	 System.out.println("fail");
         }
         
         if(title.equals("(7) Facebook"))
         {
        	 System.out.println("pass");
         }
         else 
         {
        	 System.out.println("fail");
         }*/
     }
     
     @Test 
     public void validateForFriendRequest() 
     {
    	 testID=102;
    	 System.out.println("friend request");
    	 forFriendRequest.enterFriends();
    	 forFriendRequest.AcceptFriendsRequest();
     }
     
     @AfterMethod
     public void ForLogout(ITestResult result) throws IOException 
     {
    	 if(ITestResult.FAILURE==result.getStatus())
    	 {
    		 Utility.Screenshot(driver, testID);
    	 }
    	 
    	 System.out.println("for Logout");
    	
    	 facebookHeader.enterdownarrow();
    	 facebookHeader.logout();
     }
     
     @AfterClass
     public void ClearthePOMobject() 
     {
    	 loginPage= null;
    	 forFriendRequest=null;
    	 facebookHeader=null;
    	 
     }
     
     @AfterTest
     public void CloseTheBrowser() 
     {
    	 System.out.println("close browser");
    	 driver.quit();
    	 driver=null;
    	 System.gc();  //to delete the object.
     }
}
