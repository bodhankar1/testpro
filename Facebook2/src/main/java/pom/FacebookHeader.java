package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookHeader 
{
	@FindBy (xpath="//a[@aria-label=\"Home\"]")
    private WebElement home;
	
	@FindBy (xpath="(//div[@aria-label='Messenger, 2 unread'])[1]")
    private WebElement messenger;
	
	@FindBy (xpath="//a[@aria-label=\"Watch, 54 notifications\"]")
    private WebElement reel;
	
	
	@FindBy (xpath="aria-label=\"Groups\"")
    private WebElement group;
	
	
	@FindBy (xpath="//div[@aria-label='Account']")
    private WebElement downarrow;
	
	@FindBy (xpath="//span[text()='Log Out']")
    private WebElement logout;
	
	public FacebookHeader(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterHome()
	{
		home.click();
	}
	
	public void enterreel()
	{
		reel.click();
	}
	
	public void entergroup()
	{
		group.click();
	}
	
	public void enterdownarrow()
	{
		downarrow.click();
	} 
	public void logout()
	{
		logout.click();
	}
}
