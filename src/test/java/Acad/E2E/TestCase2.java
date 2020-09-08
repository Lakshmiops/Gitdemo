package Acad.E2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.ForgotPassword;
import PageObjects.LoginPage;
import resource.Project;

public class TestCase2 extends Project {
	public WebDriver driver;
	//private static Logger log=LogManager.getLogger(Project.class.getName());
	
	/*@BeforeTest
	public void bef() throws IOException
	{
		
		//driver.get("https://rahulshettyacademy.com");
	
	}*/
	public static Logger log=LogManager.getLogger(Project.class.getName());
	@Test(dataProvider="getData")

	public void s(String username, String password) throws IOException
	{
	
	
		//log.info("url set");
	
		driver=initializeDriver();
		log.info("test initialization");
		driver.get("https://rahulshettyacademy.com/#/index");
		//Homepage hp=new Homepage(driver);
        LoginPage lp=new LoginPage(driver);
        lp.lgn().click();
		lp.usernm().sendKeys(username);
		lp.pswrd().sendKeys(password);
		lp.lgn().click();
		ForgotPassword fp=lp.forgotpassword();
		fp.usernm();
		fp.sendins();
	}
		
		@DataProvider
		public Object[][] getData()
		{
			Object[][] data=new Object[2][2];
			data[0][0]="nonres@d.com";
			data[0][1]="password";
			data[1][0]="res@d.com";
			data[1][1]="ppassword";
			return data;
			
		}
		@AfterTest
		public void tear()
		{
			driver.close();
		}

}
