package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.adminuserPage;
import pages.homePage;
import pages.loginPage;
import utilities.excelUtility;
import utilities.randomDataUtility;

public class adminuserTest extends base{
	adminuserPage ap;
	homePage hp;
	@Test(description="user is trying to add new admin user")
	public void verifywhetheruserisabletoaddnewadmiinuser() throws IOException {
		String usernamevalue=excelUtility.readStringData(0, 0,"testdata");
		String passwordvalue=excelUtility.readStringData(0, 1,"testdata");
		loginPage lp=new loginPage(driver);
		lp.enter_username(usernamevalue).enter_password(passwordvalue);
		hp=lp.login();
		ap=hp.moreinfoclick();
		ap.newclick();
		randomDataUtility rdu=new randomDataUtility();
		String adminuservalue=rdu.generateRandomUserName();
		String adminpassvalue=rdu.generateRandomPassword();
		ap.enteradminusername(adminuservalue).enteradminpassword(adminpassvalue).enteradmintype().saveadminuser();
		/*String Actual=ap.verifyadduseralertisdisplayed();
		String Expected=" x\r\nUser Successfully";
		Assert.assertEquals(Actual,Expected, "new user could not be created");*/
		
		
	}
	@Test(description="user is trying to search newly added admin user")
	public void verifywhetheruserisabletosearchnewlyaddedadminuser() throws IOException {
		String usernamevalue=excelUtility.readStringData(0, 0,"testdata");
		String passwordvalue=excelUtility.readStringData(0, 1,"testdata");
		loginPage lp=new loginPage(driver);
		lp.enter_username(usernamevalue);
		lp.enter_password(passwordvalue);
		lp.login();
		adminuserPage ap=new adminuserPage(driver);
		ap=hp.moreinfoclick();
		ap.clickbluesearch();
		String adminuservalue=excelUtility.readStringData(0, 0, "admindata");
		ap.enteradminusernamesearch(adminuservalue).enteradminsearchtype().clickredsearch();
		
	}

}
