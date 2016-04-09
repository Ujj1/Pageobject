package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utils.Utils;


	public class LoginPage extends BasePage {
		
		
		
		public LoginPage()
		{
			PageFactory.initElements(driver, this);
		
			
		}
		
		@FindBy(how= How.ID,using="username")
		public WebElement userName;
		
		@FindBy(how= How.ID,using="password")
		public WebElement passWord;
		

		@FindBy(how= How.XPATH,using="//*[@id='log']/button")
		public WebElement submitButton;

		
		
		public void login(String UserName,String PassWord) throws InterruptedException
		{
		
	        userName.sendKeys(UserName);
	        passWord.sendKeys(PassWord);
	        Thread.sleep(5000);
	        submitButton.click();
			
		}
		
		
		
		
		
		

}
