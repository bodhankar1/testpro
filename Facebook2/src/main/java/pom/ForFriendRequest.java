package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForFriendRequest 
{
   @FindBy (xpath="//span[text()='Friends']")
   private WebElement friends;
   
   @FindBy (xpath=" (//span[text()='Confirm'])[1]")
   private WebElement accept;
   
   public ForFriendRequest(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
   
   public void enterFriends()
   {
	   friends.click();
   }
   
   public void AcceptFriendsRequest()
   {
	   accept.click();
   }
   
   
}
