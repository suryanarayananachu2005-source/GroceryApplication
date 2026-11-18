package testScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.screenshotUtility;

public class base {
	public WebDriver driver;
	Properties prop;
	FileInputStream fis;
	@BeforeMethod(alwaysRun=true)
	@Parameters("browsers")
			public void browserinitialization(String browsers) throws IOException {
					prop=new Properties();
					fis=new FileInputStream(Constant.CONFIGFILE);
					prop.load(fis);
				if(browsers.equalsIgnoreCase("chrome")) {
					driver=new ChromeDriver();
				}
				else if(browsers.equalsIgnoreCase("firefox")) {
					driver=new FirefoxDriver();
				}
				else if(browsers.equalsIgnoreCase("edge")) {
					driver=new EdgeDriver();
				}
				
				driver.get(prop.getProperty("url"));
				driver.manage().window().maximize();
				//driver.close()
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));   //implicit wait
			}
	@AfterMethod(alwaysRun=true)
	public void closeBrowser(ITestResult itestresult) throws IOException {
			
		if(itestresult.getStatus()==ITestResult.FAILURE) 
		{
			screenshotUtility screenshotutility=new screenshotUtility();
			screenshotutility.getScreenshot(driver, itestresult.getName());
		}
	}
// driver.close();
//driver.quit();
}