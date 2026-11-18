package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
public WebDriver driver;
	public homePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	
@FindBy(xpath="//a[@data-toggle='dropdown']") WebElement admin;
@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']") WebElement signout;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement adminmoreinfo;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']") WebElement deliveryboymoreinfo;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']") WebElement categorymoreinfo;

public homePage clickadmin() {
	admin.click();
	return this;
	
}
public loginPage clicksignout() {
	signout.click();
	return new loginPage(driver);
}
public adminuserPage moreinfoclick() {
	adminmoreinfo.click();
	return new adminuserPage(driver);
}
public deilveryBoyPage deliveryboymoreinfoclick() {
	deliveryboymoreinfo.click();
	return new deilveryBoyPage(driver);
}
public categoryPage categorymoreinfoclick() {
	categorymoreinfo.click();
	return new categoryPage(driver);
}
}