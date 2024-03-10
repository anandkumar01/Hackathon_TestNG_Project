package testCases;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.testng.annotations.Test;

import factory.CrossBrowsing;
import pageObjects.BikeDetailsPage;
import pageObjects.CarDetailsPage;
import pageObjects.HealthInsurancePage;
import pageObjects.InvalidGoogleLoginPage;
import pageObjects.UsedCarPage;
import utilities.WriteExcelData;

public class TC_IdentifyNewBikes extends CrossBrowsing {

	InvalidGoogleLoginPage login;
	BikeDetailsPage bike;
	CarDetailsPage car;
	HealthInsurancePage health;
	UsedCarPage usedcar;
	List<String> carModels;
	String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.xlsx";

	@Test(priority = 0, groups = { "sanity" })
	public void testInvalidGoogleLogin() {
		login = new InvalidGoogleLoginPage(driver);

		logger.info("Clicked Login button");
		login.clickLoginButton();

		logger.info("Clicked Google Account");
		login.clickGoogleAccount();

		logger.info("Entered random email");
		login.enterRandomEmail();

		logger.info("Error message printed");
		login.printErrorMessage();
	}

	@Test(priority = 1, groups = { "sanity" })
	public void testBikeDetails() throws IOException {
		// Pass the WebDriver instance to the BikeDetailsPage constructor
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

	@Test(priority = 2, groups = { "sanity" })
	public void testWriteBikeDetails() {
		LinkedHashMap<String, List<String>> bikeDetailsMap = bike.getUpcomingBikeDetails();
		WriteExcelData.writeBikeDetails(bikeDetailsMap, filepath);
	}

	@Test(priority = 3, groups = { "sanity" })
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

	@Test(priority = 4, groups = { "sanity" })
	public void testWriteCarDetails() {
		LinkedHashMap<String, List<String>> carDetailsMap = car.getUpcomingCarDetails();
		WriteExcelData.writeCarDetails(carDetailsMap, filepath);
	}

	@Test(priority = 5, groups = { "sanity" })
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

	@Test(priority = 6, groups = { "sanity" })
	public void testWritePopularCarModel() {
		carModels = usedcar.getPopularCarModels();
		WriteExcelData.writePopularCarModel(carModels, filepath);
	}

	@Test(priority = 7, groups = { "sanity" })
	public void testWriteAllPopularCarModelDetails() throws InterruptedException {
		List<List<List<String>>> allPopularCarModelDetails = usedcar.getAllPopularCarModelDetails();
		WriteExcelData.writeAllPopularCarModelDetails(allPopularCarModelDetails, carModels, filepath);
	}

	@Test(priority = 8, groups = { "sanity" })
	public void testHealthInsurance() throws IOException, InterruptedException {
		health = new HealthInsurancePage(driver);

		logger.info("Hover More");
		health.hoverMore();

		logger.info("Clicked Health Insurance");
		health.clickHealthInsurance();

		logger.info("Filled Health Insurance basic details");
		health.fillBasicDetails();

		logger.info("Printed Health Insurance brand names");
		health.printHealthInsuranceBrandName();

		logger.info("Printed Health Insurance plan");
		health.printInsurancePlan();
	}

	@Test(priority = 9, groups = { "sanity" })
	public void testWriteHealthInsuranceBrandName() throws InterruptedException {
		List<String> insuranceBrandName = health.getHealthInsuranceBrandName();
		WriteExcelData.writeHealthInsuranceBrandName(insuranceBrandName, filepath);
	}

	@Test(priority = 10, groups = { "sanity" })
	public void testWriteHealthInsurancePlan() {
		List<String> insurancePlan = health.getInsurancePlan();
		WriteExcelData.writeHealthInsurancePlan(insurancePlan, filepath);
	}
}
