package test;

 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

 

public class browser 
{
	public static WebDriver launchtheChromeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
 		WebDriver driver=new ChromeDriver();
		return driver;
	}
	
	public static WebDriver launchtheFirefoxBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Lenovo\\Downloads\\geckodriver-v0.30.0-win32\\geckodriver.exe");
 		WebDriver driver=new FirefoxDriver();
 		return driver;
	}

}
