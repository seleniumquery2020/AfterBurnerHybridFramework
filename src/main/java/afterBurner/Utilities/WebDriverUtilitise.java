package afterBurner.Utilities;

import org.openqa.selenium.WebDriver;

public class WebDriverUtilitise {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		WebDriverUtilitise.driver = driver;
		
	}
}
