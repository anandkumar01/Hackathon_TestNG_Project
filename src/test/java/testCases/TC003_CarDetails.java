package testCases;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.annotations.Test;

import factory.CrossBrowsing;
import pageObjects.CarDetailsPage;
import utilities.WriteExcelData;

public class TC003_CarDetails extends CrossBrowsing {
	CarDetailsPage car;
	String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.xlsx";

	@Test(priority = 0)
	public void testCarDetails() throws IOException {
		car = new CarDetailsPage(driver);

		logger.info("Hover on New Cars");
		car.hoverNewCars();

		logger.info("Clicked upcomming cars");
		car.clickUpcomingCars();

		logger.info("Selected manufacturer name");
		car.selectManufacturer();

		logger.info("Clicked view more option");
		car.clickToViewMore();

		logger.info("Printed upcomming car details");
		car.printUpcomingCarDetails();
	}

	@Test(priority = 1)
	public void testWriteCarDetails() {
		LinkedHashMap<String, List<String>> carDetailsMap = car.getUpcomingCarDetails();
		WriteExcelData.writeCarDetails(carDetailsMap, filepath);
	}

}
