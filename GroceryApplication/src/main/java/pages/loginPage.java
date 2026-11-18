package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.waitUtility;

public class loginPage {
	public WebDriver driver;
	waitUtility wu=new waitUtility();
	public loginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	@FindBy(xpath="//input[@placeholder='Username']") WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement passwrd;
	@FindBy(xpath="//button[text()='Sign In']") WebElement login;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard;
	@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement loginpagetext;
	
	
	public loginPage enter_username(String usernamevalue) {
		username.sendKeys(usernamevalue);
		return this;
		
	}
	public loginPage enter_password(String passwordvalue) {
		passwrd.sendKeys(passwordvalue);
		return this;
	}
	public homePage login() {
		wu.waitUntilElementToBeClickable(driver, login);
		login.click();
		return new homePage(driver);
	}
	public boolean verifyWhetherDashboardisdisplayed() {
		return dashboard.isDisplayed();
		
	}
	public String verifywhetherLoginTextisDisplayed() {
		return loginpagetext.getText();
	}

}
