package Acad.E2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Homepage;
import resource.Project;

public class base extends Project{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(Project.class.getName());
	@Test
	public void text() throws IOException
	
	{
		driver=initializeDriver();
		log.info("base driver");
		driver.get("https://rahulshettyacademy.com/#/index");
		Homepage hp=new Homepage(driver);
		  Assert.assertEquals(hp.title().getText(), "Featured Courses");
	        Assert.assertTrue(hp.navigation().isDisplayed());
	       // log.info("successfully validated text");
	}
	

}
