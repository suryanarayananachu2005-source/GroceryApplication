package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.categoryPage;
import pages.homePage;
import pages.loginPage;
import utilities.excelUtility;

public class categoryTest extends base {
	homePage hp;
	categoryPage cp;
@Test
	public void verifywhetheruserisabletoaddnewcategory() throws IOException {
		String usernamevalue=excelUtility.readStringData(0, 0,"testdata");
		String passwordvalue=excelUtility.readStringData(0, 1,"testdata");
		loginPage lp=new loginPage(driver);
		lp.enter_username(usernamevalue).enter_password(passwordvalue);
		hp=lp.login();
		cp=hp.categorymoreinfoclick();
		cp.clicknewbutton();
		String categoryvalue=excelUtility.readStringData(0, 0, "categorydata");
		cp.entercategoryname(categoryvalue).clickcategory().fileupload().clicksavebutton();
		
	}
}
