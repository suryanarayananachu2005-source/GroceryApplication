package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.pageUtility;

public class adminuserPage {
	public WebDriver driver;
	pageUtility pu=new pageUtility();
	public adminuserPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}







@FindBy(xpath="//a[contains(text(),'ew')]")WebElement newbutton;
@FindBy(xpath="//input[@id='username']")WebElement adminname;
@FindBy(xpath="//input[@id='password']")WebElement adminpass;
@FindBy(xpath="//select[@id='user_type']") WebElement admintype;
@FindBy(xpath="//button[@name='Create']") WebElement save;
@FindBy(xpath="//a[contains(text(),'Search')]") WebElement bluesearch;
@FindBy(xpath="//input[@id='un']") WebElement adminnamesearch;
@FindBy(xpath="//select[@id='ut']") WebElement admintypesearch;
@FindBy(xpath="//button[@name='Search']") WebElement redsearch;
//@FindBy(xpath=" //div[@class='alert alert-success alert-dismissible']") WebElement alert;
public adminuserPage newclick() {
	newbutton.click();
	return this;
}
public adminuserPage enteradminusername(String adminuservalue) {
	adminname.sendKeys(adminuservalue);
	return this;
}
public adminuserPage enteradminpassword(String adminpassvalue) {
	adminpass.sendKeys(adminpassvalue);
	return this;
}
public adminuserPage enteradmintype() {
	pu.selectDropdownWithVisibleText(admintype, "Staff");
	return this;
	//Select select=new Select(admintype);
	//select.selectByContainsVisibleText("Staff");
}
public adminuserPage saveadminuser() {
	save.click();
	return this;
}
public adminuserPage  clickbluesearch() {
	bluesearch.click();
	return this;
}
public adminuserPage enteradminusernamesearch(String adminuservalue) {
	adminnamesearch.sendKeys(adminuservalue);
	return this;
}
public adminuserPage enteradminsearchtype() {
	pu.selectDropdownWithVisibleText(admintypesearch, "Staff");
	return this;
	//Select select=new Select(admintypesearch);
	//select.selectByContainsVisibleText("Staff");
}
public adminuserPage clickredsearch() {
	redsearch.click();
	return this;
}
}