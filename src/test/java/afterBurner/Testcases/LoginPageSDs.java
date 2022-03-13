package afterBurner.Testcases;

import afterBurner.PageObject.LoginPage;
import afterBurner.Utilities.WebInteraction;

public class LoginPageSDs {

	
	static LoginPage loginPage;
	
	public static void startApplication() {
		WebInteraction.launchbrowser();
	}

	public static void verifyPageTitle() {
		String title = WebInteraction.getText(loginPage.pageTitle);
		System.out.println(title);
	}
	
	public static void verifyPageHeader() {
		String title = WebInteraction.getText(loginPage.pageTitle);
		System.out.println(title);
	}
	public static void main(String[] args) {
		startApplication();
		loginPage = new LoginPage();
		verifyPageTitle();
	}


	public void display() {
		System.out.println("new Method");
	}
	
}
