package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class screenshotUtility {
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException 
	{
	TakesScreenshot scrShot = (TakesScreenshot) driver;   //creating reference vrble fot interface This lines capture scrnshot
	File screenShot = scrShot.getScreenshotAs(OutputType.FILE);   //the captured scrnshot stored in scrshot get by using get method and converted to file and stored in screenshot varble
	String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());   //used to note the time during the scrnshot was captured
	File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");// create file in directory by taking the local path of our project
	if (!f1.exists()) 
	{
	f1.mkdirs();
	}
	String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp+ ".png";
	File finalDestination = new File(destination);
	FileHandler.copy(screenShot, finalDestination);
	}

}
