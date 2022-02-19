package afterBurner.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import afterBurner.Utilities.WebDriverUtilitise;

public class LoginPage {

	@FindBy(tagName = "h1")
	public WebElement pageTitle;
	
	@FindBy(xpath = "//input")
	public List<WebElement> inputFields;
	
	public LoginPage() {
		
		
		PageFactory.initElements(WebDriverUtilitise.getDriver(),this);
		
	}
	
}
