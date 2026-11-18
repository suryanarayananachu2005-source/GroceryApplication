package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.homePage;
import pages.loginPage;
import utilities.excelUtility;

public class homeTest extends base {
	homePage hp;
	@Test(description="user is trying to logout successfully")
	public void verifyWhetherUserisabletoSuccessfullyLogout() throws IOException {
		String usernamevalue=excelUtility.readStringData(0, 0,"testdata");
		String passwordvalue=excelUtility.readStringData(0, 1,"testdata");
		loginPage lp=new loginPage(driver);
		lp.enter_username(usernamevalue).enter_password(passwordvalue);
		hp=lp.login();
		hp.clickadmin();
		lp=hp.clicksignout();
		String actual=lp.verifywhetherLoginTextisDisplayed();
		//assertion
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected, "user is unable to logout");
	}

}
