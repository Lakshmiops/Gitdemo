package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {

	public WebDriver driver;
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By login=By.cssSelector("a[href*='sign_in']");
	By gettitle=By.xpath("//section[@class='courses-section']/div/div/div/h2");
	By nav=By.xpath("//ul[contains(@class,'navigation clearfix')]");
	By popup=By.xpath("//button[text()='NO THANKS']");
	
	public WebElement Signin()
	{
		return driver.findElement(login);
		//return driver.findElement(login).click();
		//LoginPage lp=new LoginPage(driver);
		//return lp;
		 
		
	}
	
	public WebElement title()
	{
		return driver.findElement(gettitle);
	}
	
	public WebElement navigation()
	{
		return driver.findElement(nav);
	}
	public int getPopUpSize()
	{
		return driver.findElements(popup).size();
	}
	public WebElement getPopUp()
	{
		return driver.findElement(popup);
	}	
	
	}
