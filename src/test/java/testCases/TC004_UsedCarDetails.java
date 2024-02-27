package testCases;

import java.util.List;

import org.testng.annotations.Test;

import factory.CrossBrowsing;
import pageObjects.UsedCarPage;
import utilities.WriteExcelData;

public class TC004_UsedCarDetails extends CrossBrowsing {
	UsedCarPage usedcar;
	String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.xlsx";
	List<String> carModels;

	@Test(priority = 0)
	public void testUsedCars() throws InterruptedException {
		usedcar = new UsedCarPage(driver);

		logger.info("Hover on Used Cars");
		usedcar.hoverUsedCars();

		logger.info("Clicked Chennai");
		usedcar.clickChennai();

		logger.info("Scrolled to popular model");
		usedcar.scrollToPopularModel();

		logger.info("Printed popular car model names");
		usedcar.printPopularCarModels();

		logger.info("Printed all popular car model details");
		usedcar.printAllPopularCarModelDetails();
	}

	@Test(priority = 1)
	public void testWritePopularCarModel() {
		logger.info("Written popular car model names in excel sheet");
		carModels = usedcar.getPopularCarModels();
		WriteExcelData.writePopularCarModel(carModels, filepath);
	}

	@Test(priority = 2)
	public void testWriteAllPopularCarModelDetails() throws InterruptedException {
		logger.info("Written all popular car model details in excel sheet");
		List<List<List<String>>> allPopularCarModelDetails = usedcar.getAllPopularCarModelDetails();
		WriteExcelData.writeAllPopularCarModelDetails(allPopularCarModelDetails, carModels, filepath);
	}
}
