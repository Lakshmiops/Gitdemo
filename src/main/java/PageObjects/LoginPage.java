package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By username=By.id("user_email");
	By password=By.id("user_password");
	By login=By.xpath("//input[@value='Log In']");
	By forgotpassword=By.cssSelector("[href*='password/new']");
	
	public WebElement usernm()
	{
		return driver.findElement(username);
	}
	public WebElement pswrd()
	{
		return driver.findElement(password);
	}
	public WebElement lgn()
	{
		return driver.findElement(login);
	}
	
	public ForgotPassword forgotpassword()
	{
		driver.findElement(forgotpassword).click();
		 return new ForgotPassword(driver);
	}
	
}
