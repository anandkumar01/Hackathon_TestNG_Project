package testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.BikeDetailsPage;

public class TC001_BikeDetails extends BaseClass {
	BikeDetailsPage bike;

	@BeforeMethod
	public void initialize() throws IOException {
		System.out.println("Starting the browser session..");
		bike = new BikeDetailsPage(driver);
	}

	@Test
	public void testBikeDetails() throws IOException {
		bike.hoverNewBikes();
		bike.clickUpcomingBikes();
		bike.selectManufacturer();
		bike.clickToViewMore();
		bike.printUpcomingBikeDetails();
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("Closing the browser session..");
		closeBrowser();
	}
}
