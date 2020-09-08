package resource;
	import java.io.File;
import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

	public class Project {

		public  WebDriver driver;
		public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		
	 prop= new Properties();

FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resource\\data.properties");

	prop.load(fis);
	String browserName=prop.getProperty("browser");
	//String browserName=System.getProperty("browser");
	System.out.println(browserName);

	if(browserName.equals("chrome"))
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("headless");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resource\\chromedriver.exe");
driver= new ChromeDriver(options);
			//execute in chrome driver
		
	}
	else if (browserName.equals("firefox"))
	{
		//firefox code
	}
	else if (browserName.equals("IE"))
	{
//		IE code
	}

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;


	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File so=ts.getScreenshotAs(OutputType.FILE);
		String destFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(so,new File(destFile));
		return destFile;
	}
}