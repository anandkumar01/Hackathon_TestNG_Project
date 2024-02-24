package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.BikeDetailsPage;

public class TC002_BikeDetails extends BaseClass {
	BikeDetailsPage bike;

	@Test
	public void testBikeDetails() throws IOException {
		// Pass the WebDriver instance to the BikeDetailsPage constructor
		bike = new BikeDetailsPage(driver);
		bike.hoverNewBikes();
		bike.clickUpcomingBikes();
		bike.selectManufacturer();
		bike.clickToViewMore();
		bike.printUpcomingBikeDetails();
	}
}
