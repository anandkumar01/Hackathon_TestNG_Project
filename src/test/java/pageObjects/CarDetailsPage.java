package pageObjects;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CarDetailsPage extends BasePage {
	Properties property;

	public CarDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Initialising LinkedHashMap to store car details in ordered way
	LinkedHashMap<String, List<String>> carDetailsMap = new LinkedHashMap<>();

	// Web elements for different functionality
	@FindBy(xpath = "//img[@data-track-label=\"zw-header-logo\"]")
	WebElement zigwheels;

	@FindBy(xpath = "//a[contains(text(), \"New Cars\")]")
	WebElement newcars;

	@FindBy(xpath = "//ul[starts-with(@class, 'h-d-nav')]/li/a")
	List<WebElement> navheaderlist;

	@FindBy(xpath = "//span[contains(text(), \"Upcoming Cars\")]")
	WebElement upcomingcar;

	@FindBy(xpath = "//select[@id='makeId']")
	WebElement selectmanufacturer;

	@FindBy(xpath = "//span[@data-track-label='view-more-models-button']")
	WebElement scroll;

	@FindBy(xpath = "//span[@class='zw-cmn-loadMore']")
	WebElement viewmore;

	// Storing list of web elements for car name
	@FindBy(xpath = "//a[@data-track-label='model-name']")
	List<WebElement> carnames;

	// Storing list of web elements for car price
	@FindBy(xpath = "//a[@data-track-label='model-name']/following-sibling::div[1]")
	List<WebElement> carprices;

	// Storing list of web elements for car launch date
	@FindBy(xpath = "//a[@data-track-label='model-name']/following-sibling::div[2]")
	List<WebElement> carlaunchdate;

	public void hoverNewCars() {
		zigwheels.click();
		explicitWait(newcars);
	}

	public void clickUpcomingCars() {
		upcomingcar.click();
	}

	public void selectManufacturer() {
		Select select = new Select(selectmanufacturer);
		select.selectByVisibleText(property.getProperty("carmanufacturer"));
	}

	public void clickToViewMore() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		scrollToElement(scroll);
		explicitWait(viewmore);
		js.executeScript("arguments[0].click();", viewmore);
	}

	public LinkedHashMap<String, List<String>> getUpcomingCarDetails() {
		for (int i = 0; i < carnames.size(); i++) {
			String carname = carnames.get(i).getText();
			String carprice = carprices.get(i).getText();
			String launchdate = carlaunchdate.get(i).getText();

			// Create a list to store details
			List<String> detailsList = new ArrayList<>();
			detailsList.add(carname);
			detailsList.add(carprice);
			detailsList.add(launchdate);

			// Use 'Cardetails' as the key and the list of details as the value
			String carDetailsKey = "CarDetails" + (i + 1);
			carDetailsMap.put(carDetailsKey, detailsList);

		}
		return carDetailsMap;
	}

	public void printUpcomingCarDetails() {
		LinkedHashMap<String, List<String>> carDetails = getUpcomingCarDetails();

		System.out.println("\nAll upcoming car details are displayed below :");
		int i = 1;
		for (String key : carDetails.keySet()) {
			List<String> detailsList = carDetails.get(key);
			System.out.println("\nCar Details" + (i) + ": " + detailsList);
			i++;
		}
	}

//	Functionality for Smoke Testing

	@FindBy(xpath = "//h1[contains(text(),'Upcoming Cars in India')]")
	WebElement carheading;

	public void checkNewCars() {
		boolean newcar = newcars.isDisplayed();
		if (newcar) {
			System.out.println("New Cars is displayed at header successfully..");
		} else {
			System.out.println("New Cars at header is not visible..");
		}
	}

	public void checkUpcomingCars() {
		explicitWait(upcomingcar);
		boolean newcar = upcomingcar.isDisplayed();
		if (newcar) {
			System.out.println("Upcoming Cars is displayed in the list successfully..");
		} else {
			System.out.println("Upcoming Cars is not visible..");
		}
	}

	public void validateAllCars() {
		explicitWait(carheading);
		boolean heading = carheading.isDisplayed();
		if (heading) {
			System.out.println("All upcoming cars are displayed successfully..");
		} else {
			System.out.println("All upcoming cars are not visible..");
		}
	}

}
