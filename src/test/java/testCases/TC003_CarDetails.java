package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.CarDetailsPage;

public class TC003_CarDetails extends BaseClass {
	CarDetailsPage car;

	@Test
	public void testCarDetails() throws IOException {
		car = new CarDetailsPage(driver);
		car.hoverNewCars();
		car.clickUpcomingCars();
		car.selectManufacturer();
		car.clickToViewMore();
		car.printUpcomingCarDetails();
	}

}
