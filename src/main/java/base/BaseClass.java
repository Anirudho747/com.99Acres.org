package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.General;

import java.time.Duration;


public class BaseClass {
	
    public WebDriver driver;
	public ConfigReader cr;
	public ExtentReports extent;
	public ExtentSparkReporter spark;


	
	public BaseClass()
	{
		cr = new ConfigReader();
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("Spark.html");
	}
	
	  @BeforeTest
	  public void setUp()
	    {
	        driver.manage().window().maximize();
	        extent.attachReporter(spark);
     		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(160));
	    }

	    @AfterTest
	    public void tearDownClass()
	    {
	    	extent.flush();
	    }

	@AfterSuite
	public void tearDownSuite()
	{
	        driver.close();
	}

	public WebDriver getBrowser()
	{
		if(cr.getBrowser().equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (cr.getBrowser().equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		return driver;
	}


}
