package afterBurner.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import afterBurner.FileHandling.PropertiesUtility;

public class WebInteraction {

	static Actions actions;
	static Select select;
	static PropertiesUtility propertiesUtility = new PropertiesUtility();	
	static ExtentHtmlReporter extentHtmlReports;
	static ExtentReports extetReports;
	static ExtentTest extentTest;
	
	public static void  createReport() {
		
		extentHtmlReports = new ExtentHtmlReporter("E:\\StarGateTeam\\AfterBurnerHybridFramework\\Reports\\report.html");
	
		extetReports = new ExtentReports();
		extetReports.attachReporter(extentHtmlReports);
			
	}
	
	public static void launchbrowser() {
		 createReport();
		String browserName = propertiesUtility.getProperty("driver");
		extentTest = extetReports.createTest("launch browser");
		switch (browserName.trim().toUpperCase()) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver",
					"E:\\java video\\Testing Data\\WebDrivers\\chromedriver.exe");
			WebDriverUtilitise.setDriver(new ChromeDriver());
			extentTest.pass("ChromeDriver was started successfully.");
			break;
		case "IE":
			System.setProperty("webWebDriverUtilitise.getDriver().ie.WebDriverUtilitise.getDriver()",
					"E:\\java video\\Testing Data\\WebWebDriverUtilitise.getDriver()s\\IEWebDriverUtilitise.getDriver()Server.exe");
			WebDriverUtilitise.setDriver(new InternetExplorerDriver());
			extentTest.pass("InternetExplorerDriver was started successfully.");
			break;
		case "FIREFOX":
			System.setProperty("webWebDriverUtilitise.getDriver().gecko.WebDriverUtilitise.getDriver()",
					"E:\\java video\\Testing Data\\WebWebDriverUtilitise.getDriver()s\\geckoWebDriverUtilitise.getDriver().exe");
			WebDriverUtilitise.setDriver(new FirefoxDriver());
			extentTest.pass("FireFoxDriver was started successfully.");
			break;
		default:
			System.out.println("Invalid Browser Name");
			extentTest.fail("Invalid Browser Name.");			
		}
		
		try {
			WebDriverUtilitise.getDriver().manage().window().maximize();
			WebDriverUtilitise.getDriver().get(propertiesUtility.getProperty("url"));
		}catch(RuntimeException e) {
			
			extentTest.fail(e.getMessage());
			closebrowser();
			
		}
		
	}

	public static void closecurrentwindow() {
		WebDriverUtilitise.getDriver().close();
	}

	public static void closebrowser() {
		try {
	    	WebDriverUtilitise.getDriver().quit();
	    	extentTest.pass("Driver closed Successfully.");
		}catch(RuntimeException e)
		{
			
		}finally {
			extetReports.flush();
		}
		
	}

	public static String getPageTitle() {
		String title = "";
		try {
			title = WebDriverUtilitise.getDriver().getTitle();
			extentTest.pass(title);
		}catch(RuntimeException e) {
			extentTest.fail(e.getMessage());
			closebrowser();
		}
		return title;
	}

	public static String getCurrentUrl() {
		return WebDriverUtilitise.getDriver().getCurrentUrl();
	}

	public static String getPageSource() {
		return WebDriverUtilitise.getDriver().getPageSource();
	}

	public static void clickButton(WebElement ele) {
		ele.click();
	}

	public static void clearButton(WebElement ele) {
		ele.clear();
	}

	public static void sendkeys(WebElement ele, String value) {
		ele.sendKeys(value);
	}

	public static String getText(WebElement ele) {
		String text ="";
	
		try {
		    text = ele.getText();
		    extentTest.pass("Text of WebElement is "+text);
		}catch(RuntimeException e) {
			extentTest.fail(e.getMessage());
			try {
				extentTest.addScreenCaptureFromPath(takeScreenshot());
			} catch (IOException e1) {
			}
			closebrowser();
		}
		return text;
	}

	public static String GetAttribute(WebElement ele, String value) {
		return ele.getAttribute(value);
	}

	public static String getCssvalue(WebElement ele, String value) {
		return ele.getCssValue(value);
	}

	public static String getTagname(WebElement ele, String value) {
		return ele.getTagName();
	}

	public static void clickByAction() {
		actions = new Actions(WebDriverUtilitise.getDriver());
		actions.click().perform();

	}

	public static void clickandhold() {
		actions = new Actions(WebDriverUtilitise.getDriver());
		actions.clickAndHold().perform();
	}

	public static void contextclick() {
		actions = new Actions(WebDriverUtilitise.getDriver());
		actions.contextClick().perform();
	}

	public static void doubleclick() {
		actions = new Actions(WebDriverUtilitise.getDriver());
		actions.doubleClick().perform();
	}

	public static void MoveToElement(WebElement ele, String value) {
		actions = new Actions(WebDriverUtilitise.getDriver());
		actions.moveToElement(ele);
	}

	public static void selectbyindex(WebElement ele, int value) {
		select = new Select(ele);
		select.selectByIndex(value);
	}

	public static void selectbyvalue(WebElement ele, String value) {
		select = new Select(ele);
		select.selectByValue(value);
	}

	public static void selectbyvisisbletext(WebElement ele, String value) {
		select = new Select(ele);
		select.selectByVisibleText(value);
	}

	public static void deselectbyindex(WebElement ele, int value) {
		select = new Select(ele);
		select.deselectByIndex(value);
	}

	public static void deselectbyvalue(WebElement ele, String value) {
		select = new Select(ele);
		select.deselectByValue(value);
	}

	public static void deselectbyvisisbletext(WebElement ele, String value) {
		select = new Select(ele);
		select.deselectByVisibleText(value);
	}

	public static WebElement getFirstSelectedOption(WebElement ele) {
		select = new Select(ele);
		return select.getFirstSelectedOption();
	}

	public static List<WebElement> getoptions(WebElement ele) {
		select = new Select(ele);
		return select.getOptions();
	}

	public static String date() {
		Date date = new Date();
		SimpleDateFormat simpleformat = new SimpleDateFormat("ddMMyyyy_hhmmss");
		String timestamp = simpleformat.format(date);
		return timestamp;
	}
	
	public static String takeScreenshot() {
		
		TakesScreenshot shot = (TakesScreenshot) WebDriverUtilitise.getDriver();
    	File src = shot.getScreenshotAs(OutputType.FILE);
    	String filePath = "E:\\StarGateTeam\\AfterBurnerHybridFramework\\Reports\\Screenshots\\ScreenShot.png";
    	File dest = new File(filePath);
    	try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
			
		}
    	return filePath;
	}

	public static String getwindowhandle() {
		return WebDriverUtilitise.getDriver().getWindowHandle();
	}

}
