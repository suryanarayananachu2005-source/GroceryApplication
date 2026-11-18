package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class deilveryBoyPage {
	public WebDriver driver;
	public deilveryBoyPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
}


@FindBy(xpath="//a[text()=' New']") WebElement newbutton;
@FindBy(xpath="//input[@id='name']")WebElement name;
@FindBy(xpath="//input[@id='email']")WebElement email;
@FindBy(xpath="//input[@id='phone']")WebElement phone;
@FindBy(xpath="//textarea[@id='address']")WebElement address;

@FindBy(xpath="//input[@id='username']")WebElement username;
@FindBy(xpath="//input[@id='password']")WebElement pass;
@FindBy(xpath="//button[@name='create']")WebElement savebutton;




public void clicknew() {
	newbutton.click();
}
public deilveryBoyPage enterUsername(String usernameValue) {
	name.sendKeys(usernameValue);
	return this;
}
public deilveryBoyPage enteremail(String emailValue) {
	email.sendKeys(emailValue);
	return this;
}
public deilveryBoyPage enterphone(String phoneValue) {
	phone.sendKeys(phoneValue);
	return this;
}
public deilveryBoyPage enteraddress(String addressValue) {
	address.sendKeys(addressValue);
	return this;
}
public deilveryBoyPage entername(String namevalue) {
	username.sendKeys(namevalue);
	return this;
}
public deilveryBoyPage enterpass(String passvalue) {
	pass.sendKeys(passvalue);
	return this;
}
public deilveryBoyPage clicksavebutton() {
	savebutton.click();
	return this;
}




}
