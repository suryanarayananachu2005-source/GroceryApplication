package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class categoryPage {
	public WebDriver driver;
	public categoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']") WebElement categorymoreinfo;
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newbutton;
@FindBy(xpath="//input[@id='category']")WebElement categoryname;
@FindBy(xpath="//li[@id='2-selectable']")WebElement draggroup2;
@FindBy(xpath="//input[@id='main_img']")WebElement selectfile;
@FindBy(xpath="//button[text()='Save']")WebElement savebutton;
/*public void categorymoreinfoclick() {
	categorymoreinfo.click();
}*/

public void clicknewbutton() {
	newbutton.click();
}
public categoryPage entercategoryname(String categoryvalue) {
	categoryname.sendKeys(categoryvalue);
	return this;
}
public categoryPage clickcategory() {
	draggroup2.click();
	return this;
}
public categoryPage fileupload() {
	selectfile.sendKeys("C:\\Users\\surya\\Downloads\\Hamburger_(12164386105).jpg");
	return this;
}
public categoryPage clicksavebutton() {
	savebutton.click();
	return this;
}
}


