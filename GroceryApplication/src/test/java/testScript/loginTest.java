package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import pages.homePage;
import pages.loginPage;
import utilities.excelUtility;


public class loginTest extends base{
	homePage home;
	@Test(priority=1,description="user is trying to login with valid crendentials",groups= {"smoke"})
	public void validcredentials() throws IOException {
		String usernamevalue=excelUtility.readStringData(0, 0,"testdata");
		String passwordvalue=excelUtility.readStringData(0, 1,"testdata");
		loginPage lp=new loginPage(driver);
		lp.enter_username(usernamevalue).enter_password(passwordvalue); //chaining
		home=lp.login();
		boolean dashboardvalue=lp.verifyWhetherDashboardisdisplayed();
		//assertion
		Assert.assertTrue(dashboardvalue,Constant.VALIDCREDENTIALERROR);
	}
	@Test(priority=2,description="user is trying to login with invalid credentials",retryAnalyzer=retry.Retry.class)
	public void invalidcredentials() throws IOException
	{
		String usernamevalue=excelUtility.readStringData(10, 0,"testdata");
		String passwordvalue=excelUtility.readStringData(1, 1,"testdata");
		loginPage lp=new loginPage(driver);
		lp.enter_username(usernamevalue).enter_password(passwordvalue).login();
		String actual=lp.verifywhetherLoginTextisDisplayed();
		//assertion
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected, "user is able to login with invalid credentials");
	}
	@Test(priority=3,description="user is trying to login with invalid username and valid pass")
	public void invalidUsername_validpassword() throws IOException {
		String usernamevalue=excelUtility.readStringData(2, 0,"testdata");
		String passwordvalue=excelUtility.readStringData(2, 1,"testdata");
		loginPage lp=new loginPage(driver);
		lp.enter_username(usernamevalue).enter_password(passwordvalue).login();
		String actual=lp.verifywhetherLoginTextisDisplayed();
		//assertion
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected, "user is able to login with invalid username and valid password");
	}
	@Test(priority=4,description="user is trying to login with valid username and invalid pass",groups= {"smoke"},dataProvider="logindata")
	public void validUsername_invalidpassword(String usernamevalue,String passwordvalue) throws IOException {
		//String usernamevalue=excelUtility.readStringData(3, 0,"testdata");
		//String passwordvalue=excelUtility.readStringData(3, 1,"testdata");
		loginPage lp=new loginPage(driver);
		lp.enter_username(usernamevalue).enter_password(passwordvalue).login();
		String actual=lp.verifywhetherLoginTextisDisplayed();
		//assertion
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected, "user is able to login with valid username and invalid password");
	}
	@DataProvider(name="logindata")
	public Object[][] getDatafromDataProvider(){
		return new Object[][] {
			new Object[] {"admin","admin123"},new Object[] {"user","user123"},
			};
		}
	}

