package testCases;

import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.InvalidGoogleLoginPage;

public class TC001_InvalidGoogleLogin extends BaseClass {
	InvalidGoogleLoginPage login;

	@Test
	public void testInvalidGoogleLogin() {
		login = new InvalidGoogleLoginPage(driver);
		login.clickLoginButton();
		login.clickGoogleAccount();
		login.enterRandomEmail();
		login.printErrorMessage();
	}

}
