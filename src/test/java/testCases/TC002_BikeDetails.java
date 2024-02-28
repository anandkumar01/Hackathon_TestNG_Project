package testCases;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.annotations.Test;

import factory.CrossBrowsing;
import pageObjects.BikeDetailsPage;
import utilities.WriteExcelData;

public class TC002_BikeDetails extends CrossBrowsing {
	BikeDetailsPage bike;
	String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.xlsx";

	@Test(priority = 0, groups = { "sanity" })
	public void testBikeDetails() throws IOException {
		// Pass the WebDriver instance to the BikeDetailsPage constructor
		bike = new BikeDetailsPage(driver);

		logger.info("Hover on New Bikes");
		bike.hoverNewBikes();

		logger.info("Clicked upcomming bikes");
		bike.clickUpcomingBikes();

		logger.info("Selected manufacturer name");
		bike.selectManufacturer();

		logger.info("Clicked view more option");
		bike.clickToViewMore();

		logger.info("Printed upcomming bike details");
		bike.printUpcomingBikeDetails();
	}

	@Test(priority = 1, groups = { "sanity" })
	public void testWriteBikeDetails() {
		LinkedHashMap<String, List<String>> bikeDetailsMap = bike.getUpcomingBikeDetails();
		WriteExcelData.writeBikeDetails(bikeDetailsMap, filepath);
	}

	@Test(groups = { "smoke" })
	public void smokeBikeDetails() {
		bike = new BikeDetailsPage(driver);
		bike.zigwheelspage();
		bike.hoverNewBikes();
		bike.checkUpcomingBikes();
		bike.clickUpcomingBikes();
		bike.validateHondaBikes();

	}
}
