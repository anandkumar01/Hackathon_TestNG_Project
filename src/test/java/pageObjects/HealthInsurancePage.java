package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HealthInsurancePage extends BasePage {

	public HealthInsurancePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Initialising lists to store Health Insurance brand name and plan
	List<String> brandName = new ArrayList<>();
	List<String> insurancePlan = new ArrayList<>();

	// Web elements for different functionality
	@FindBy(xpath = "//img[@data-track-label=\"zw-header-logo\"]")
	WebElement zigwheels;

	@FindBy(xpath = "//div[@id=\"headerNewNavWrap\"]//li[9]/a")
	WebElement moresection;

	@FindBy(xpath = "//span[contains(text(), 'Health Insurance')]")
	WebElement healthinsurance;

	@FindBy(xpath = "//div[starts-with(@class, 'home_formSection')]")
	WebElement scroll;

	@FindBy(xpath = "(//ul[starts-with(@class, 'malefemalewrap')]//i)[1]")
	WebElement checkmale;

	@FindBy(xpath = "(//input[@name='name'])[1]")
	WebElement inputname;

	@FindBy(xpath = "(//input[@name='mobile'])[1]")
	WebElement inputphone;

	@FindBy(xpath = "(//button[@name='submitBtn'])[1]")
	WebElement viewplan;

	@FindBy(xpath = "(//span[@class='memberIcon']/following-sibling::label)[1]")
	WebElement checkyou;

	@FindBy(xpath = "//button[@class='button']")
	WebElement continuebtn;

	@FindBy(xpath = "//input[@id='age_primary']")
	WebElement clickage;

	@FindBy(xpath = "//li[@data-value='22']")
	WebElement selectage;

	@FindBy(xpath = "//input[@id='city']")
	WebElement inputpincode;

	@FindBy(xpath = "//button[@title='Continue']")
	WebElement continueBtn;

	@FindBy(xpath = "//div[@class='diseYesNo']//span")
	WebElement checkbox;

	@FindBy(xpath = "//button[@class='button  ']")
	WebElement continuebtnn;

	// Storing list of web elements for brand name
	@FindBy(xpath = "//div[starts-with(@class, 'quotesListWrapper')]/div/div/div[2]/div/div/h2/../div[1]")
	List<WebElement> brandname;

	// Storing list of web elements for insurance plan
	@FindBy(xpath = "//div[starts-with(@class, 'quotesListWrapper')]/div/div/div[2]/div/div[2]/div[2]/div//button/span")
	List<WebElement> insuranceplan;

	@FindBy(xpath = "//div[@class='viewMorePlan']")
	List<WebElement> allscroll;

	public void hoverMore() {
		zigwheels.click();
		explicitWait(moresection);
		hoverOnElement(moresection);
	}

	public void clickHealthInsurance() {
		explicitWait(healthinsurance);
		healthinsurance.click();
	}

	public void fillBasicDetails() throws IOException, InterruptedException {
		explicitWait(scroll);
		scrollToElement(scroll);
		checkmale.click();
		inputname.sendKeys("Anand");
		inputphone.sendKeys("9876543210");

		Thread.sleep(2000);
		viewplan.click();

		explicitWait(checkyou);
		checkyou.click();
		continuebtn.click();

		clickage.click();
		selectage.click();
		inputpincode.sendKeys("603103");
		explicitWait(continueBtn);
		continueBtn.click();

		explicitWait(checkbox);
		if (checkbox.isEnabled()) {
			continuebtnn.click();
		} else {
			checkbox.click();
		}
	}

	public List<String> getHealthInsuranceBrandName() throws InterruptedException {
		brandName.clear();
		Thread.sleep(25000);
		for (WebElement ele : brandname) {
			String brand = ele.getText();
			brandName.add(brand);
		}
		return brandName;
	}

	public void printHealthInsuranceBrandName() throws InterruptedException {
		List<String> brandName = getHealthInsuranceBrandName();
		System.out.println("\nAll Health Insurance plan are displayed below :");
		for (int i = 0; i < brandName.size(); i++) {
			System.out.println((i + 1) + ". " + brandName.get(i));
		}
	}

	public List<String> getInsurancePlan() {
		insurancePlan.clear();
		for (WebElement ele : insuranceplan) {
			String plan = ele.getText();
			insurancePlan.add(plan);
		}
		return insurancePlan;
	}

	public void printInsurancePlan() {
		List<String> insurancePlan = getInsurancePlan();
		System.out.println("\nAll Health Insurance brand name are displayed below :");
		for (int i = 0; i < insurancePlan.size(); i++) {
			System.out.println((i + 1) + ". " + insurancePlan.get(i));
		}
	}

//	Functionality for Smoke Testing

	public void checkHealthInsurance() {
		explicitWait(healthinsurance);
		boolean health = healthinsurance.isDisplayed();
		if (health) {
			System.out.println("Health Insurance is displayed in the list successfully..");
		} else {
			System.out.println("Health Insurance is not visible..");
		}
		zigwheels.click();

	}

}
