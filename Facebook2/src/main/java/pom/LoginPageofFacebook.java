package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPageofFacebook
{
	@FindBy (xpath="//input[@type='text']")
	private WebElement email;
	
	@FindBy (xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy (xpath="//button[text()='Log In']")
	private WebElement login;
	
	@FindBy (xpath="//a[text()='Create New Account']")
	private WebElement CreatAccount;
	
	@FindBy (xpath="//select[@aria-label='Month']")
	private WebElement monthButton;
	
	@FindBy (xpath="//select[@aria-label='Select your pronoun']")
	private WebElement pronoun;
	
	@FindBy (xpath="(//input[@type='radio'])[3]")
	private WebElement custom;
	
	
	public LoginPageofFacebook(WebDriver driver123)
	{
		PageFactory.initElements(driver123, this);
		
	}
	
    public void forEmail(String username) 
    {
       	email.sendKeys(username);
    
    }
   
    public void forPassword(String pass)
    {
    	password.sendKeys(pass);
    }
   
    public void forCreateAcc()
    {
    	CreatAccount.click();
    }


    public String forLogin()
    {
    	String loginText=login.getText();
    	login.click();
    	return loginText;
    }
    
    public void dropboxMonth()
    {
    	Select select =new Select(monthButton);
    	select.selectByIndex(2);
    }
    
    public boolean pronounVerify() 
    {
    	boolean pro=pronoun.isDisplayed();
    	return pro;
    }
    
    public void customButton() 
    {
    	custom.click();
    }
    
    
    
    
    
    
}