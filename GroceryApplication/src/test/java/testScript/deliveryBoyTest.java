package testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.deilveryBoyPage;
import pages.homePage;
import pages.loginPage;
import utilities.excelUtility;
import utilities.randomDataUtility;

public class deliveryBoyTest extends base{
	homePage hp;
	deilveryBoyPage dp;
	@Test(description="user is trying to add new deliveryboy")
	public void verifywhetherUserisabletoaddnewDeliveryboy() throws IOException {
		String usernamevalue=excelUtility.readStringData(0, 0,"testdata");
		String passwordvalue=excelUtility.readStringData(0, 1,"testdata");
		loginPage lp=new loginPage(driver);
		lp.enter_username(usernamevalue).enter_password(passwordvalue);
		hp=lp.login();
		dp=hp.deliveryboymoreinfoclick();
		dp.clicknew();
		randomDataUtility rdu=new randomDataUtility();
		String usernameValue=rdu.generateRandomFullName();
		String emailValue=rdu.generateRandomEmailid();
		String phoneValue=rdu.generateRandomPhoneNumber();
		String addressValue=rdu.generateRandomAddress();
		String namevalue=rdu.generateRandomFullName();
		String passvalue=rdu.generateRandomPassword();
		dp.enterUsername(usernameValue).enteremail(emailValue).enterphone(phoneValue).enteraddress(addressValue).entername(namevalue).enterpass(passvalue).clicksavebutton();
		
		
		
	}

}
