package testCases;

import org.testng.annotations.Test;

import factory.CrossBrowsing;
import pageObjects.InvalidGoogleLoginPage;

public class TC001_InvalidGoogleLogin extends CrossBrowsing {
	InvalidGoogleLoginPage login;

	@Test(groups = { "regression", "sanity" })
	public void testInvalidGoogleLogin() {
		login = new InvalidGoogleLoginPage(driver);

		logger.info("Clicked Login button");
		login.clickLoginButton();

		logger.info("Clicked Google Account");
		login.clickGoogleAccount();

		logger.info("Entered random email");
		login.enterRandomEmail();

		logger.info("Error message printed");
		login.printErrorMessage();
	}

	@Test(groups = { "smoke" })
	public void smokeInvalidGoogleLogin() {
		login = new InvalidGoogleLoginPage(driver);
		login.checkLoginButton();
		login.clickLoginButton();
		login.checkGoogleOption();
	}

}
