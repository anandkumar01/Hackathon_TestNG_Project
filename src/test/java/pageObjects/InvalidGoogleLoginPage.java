package pageObjects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InvalidGoogleLoginPage extends BasePage {

	public InvalidGoogleLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String winHandleBefore;

	// Web elements for different functionality
	@FindBy(xpath = "//img[@data-track-label=\"zw-header-logo\"]")
	WebElement zigwheels;

	@FindBy(xpath = "//div[@id='forum_login_title_lg']")
	WebElement loginbutton;

	@FindBy(xpath = "//span[contains(text(), 'Google')]")
	WebElement google;

	@FindBy(xpath = "//input[@type='email']")
	WebElement emailinput;

	@FindBy(xpath = "//span[contains(text(), 'Next')]")
	WebElement nextbutton;

	@FindBy(xpath = "//div[@jsname='B34EJ']/div")
	WebElement errormessage;

	public void clickLoginButton() {
		explicitWait(loginbutton);
		loginbutton.click();
	}

	public void clickGoogleAccount() {
		explicitWait(google);
		try {
			clickToElement(google);
		} catch (Exception e) {
			System.out.println("Google option is not clickable");
		}
	}

	private static String generateRandomString(int length) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random random = new Random();
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(characters.length());
			sb.append(characters.charAt(randomIndex));
		}

		return sb.toString();
	}

	public void enterRandomEmail() {
		Random random = new Random();
		int randomInt = random.nextInt(1000);

		// Store the current window handle
		winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		String prefix = generateRandomString(8);
		emailinput.sendKeys(prefix + randomInt + "@gmail,com");
		clickToElement(nextbutton);
	}

	public void printErrorMessage() {
		explicitWait(errormessage);
		String message = errormessage.getText();
		System.out.println("Error message displayed : " + message);

		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		driver.findElement(By.id("report_submit_close_login")).click();
	}

//	Functionality for Smoke Testing

	public void checkLoginButton() {
//		zigwheels.click();
		boolean login = loginbutton.isDisplayed();
		if (login) {
			System.out.println("Login or Signup Button are displayed succesfully...");
		} else {
			System.out.println("Login or Signup Button not visible..");
		}
	}

	public void checkGoogleOption() {
		explicitWait(google);
		boolean googleoption = google.isDisplayed();
		if (googleoption) {
			System.out.println("Google option is displayed succesfully...");
		} else {
			System.out.println("Google option is not visible..");
		}
		driver.findElement(By.id("report_submit_close_login")).click();
	}

}
