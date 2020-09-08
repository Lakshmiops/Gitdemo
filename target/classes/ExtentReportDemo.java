package resource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportDemo {
	static ExtentReports re;
	@BeforeTest
	public static ExtentReports b()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Extent");
		reporter.config().setDocumentTitle("Reports");
		
		 re = new ExtentReports();
		re.attachReporter(reporter);
		re.setSystemInfo("tester", "Lakshmi");
		return re;
		
	}
	
@Test
	public void a()
	{
	ExtentTest test = re.createTest("Initial");
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\l.priya.ravindran\\PriyaWork\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/");
	System.out.println(driver.getTitle());
	test.fail("No results");
	re.flush();
	}
}
