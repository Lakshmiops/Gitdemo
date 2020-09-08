package StepDefinations;

import PageObjects.Homepage;
import PageObjects.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resource.Project;

public class stepdefination extends Project {

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 driver =initializeDriver();
	}

	@And("^Navigate to Site$")
    public void navigate_to_site()
    {    // Write code here that turns the phrase above into concrete actions
		driver.get("https://rahulshettyacademy.com/#/index");
	}

	@Given("^Click on Login link in home page to land on Secure sign in Page$")
	public void click_on_Login_link_in_home_page_to_land_on_Secure_sign_in_Page() throws Throwable {
		
		Homepage hp=new Homepage(driver);
		if(hp.getPopUpSize()>0)
		{
			hp.getPopUp().click();
		}
		hp.Signin().click(); //driver.findElement(By.css()
	   
	}

	

	@Then("^Verify that user is succesfully logged in$")
	public void verify_that_user_is_succesfully_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
System.out.println("then block");
	}
	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and logs in$")
    public void user_enters_something_and_something_and_logs_in(String strArg1, String strArg2) throws Throwable {
		LoginPage lp=new LoginPage(driver);
	    lp.usernm().sendKeys(strArg1);
	    lp.pswrd().sendKeys(strArg2);
	   	lp.lgn().click();
	    }
	 @And("^close browsers$")
	    public void close_browsers() throws Throwable {
	        driver.quit();
	    }
	


}