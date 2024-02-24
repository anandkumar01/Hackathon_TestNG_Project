package testCases;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.CarDetailsPage;
import utilities.WriteExcelData;

public class TC003_CarDetails extends BaseClass {
	CarDetailsPage car;
	String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.xlsx";

	@Test(priority = 0)
	public void testCarDetails() throws IOException {
		car = new CarDetailsPage(driver);
		car.hoverNewCars();
		car.clickUpcomingCars();
		car.selectManufacturer();
		car.clickToViewMore();
		car.printUpcomingCarDetails();
	}

	@Test(priority = 1)
	public void testWriteCarDetails() {
		LinkedHashMap<String, List<String>> bikeDetailsMap = car.getUpcomingCarDetails();
		WriteExcelData.writeCarDetails(bikeDetailsMap, filepath);
	}

}
