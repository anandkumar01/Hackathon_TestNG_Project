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

public class TC01_IdentifyNewBikes extends CrossBrowsing {

	InvalidGoogleLoginPage login;
	BikeDetailsPage bike;
	CarDetailsPage car;
	HealthInsurancePage health;
	UsedCarPage usedcar;
	List<String> carModels;
	String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.xlsx";

	@Test(priority = 0)
	public void testInvalidGoogleLogin() {
		login = new InvalidGoogleLoginPage(driver);
		login.clickLoginButton();
		login.clickGoogleAccount();
		login.enterRandomEmail();
		login.printErrorMessage();
	}

	@Test(priority = 1)
	public void testBikeDetails() throws IOException {
		// Pass the WebDriver instance to the BikeDetailsPage constructor
		bike = new BikeDetailsPage(driver);
		bike.hoverNewBikes();
		bike.clickUpcomingBikes();
		bike.selectManufacturer();
		bike.clickToViewMore();
		bike.printUpcomingBikeDetails();
	}

	@Test(priority = 2)
	public void testWriteBikeDetails() {
		LinkedHashMap<String, List<String>> bikeDetailsMap = bike.getUpcomingBikeDetails();
		WriteExcelData.writeBikeDetails(bikeDetailsMap, filepath);
	}

	@Test(priority = 3)
	public void testCarDetails() throws IOException {
		car = new CarDetailsPage(driver);
		car.hoverNewCars();
		car.clickUpcomingCars();
		car.selectManufacturer();
		car.clickToViewMore();
		car.printUpcomingCarDetails();
	}

	@Test(priority = 4)
	public void testWriteCarDetails() {
		LinkedHashMap<String, List<String>> carDetailsMap = car.getUpcomingCarDetails();
		WriteExcelData.writeCarDetails(carDetailsMap, filepath);
	}

	@Test(priority = 5)
	public void testUsedCars() throws InterruptedException {
		usedcar = new UsedCarPage(driver);
		usedcar.hoverUsedCars();
		usedcar.clickChennai();
		usedcar.scrollToPopularModel();
		usedcar.printPopularCarModels();
		usedcar.printAllPopularCarModelDetails();
	}

	@Test(priority = 6)
	public void testWritePopularCarModel() {
		carModels = usedcar.getPopularCarModels();
		WriteExcelData.writePopularCarModel(carModels, filepath);
	}

	@Test(priority = 7)
	public void testWriteAllPopularCarModelDetails() throws InterruptedException {
		List<List<List<String>>> allPopularCarModelDetails = usedcar.getAllPopularCarModelDetails();
		WriteExcelData.writeAllPopularCarModelDetails(allPopularCarModelDetails, carModels, filepath);
	}

	@Test(priority = 8)
	public void testHealthInsurance() throws IOException, InterruptedException {
		health = new HealthInsurancePage(driver);
		health.hoverMore();
		health.clickHealthInsurance();
		health.fillBasicDetails();
		health.printHealthInsuranceBrandName();
		health.printInsurancePlan();
	}

	@Test(priority = 9)
	public void testWriteHealthInsuranceBrandName() throws InterruptedException {
		List<String> insuranceBrandName = health.getHealthInsuranceBrandName();
		WriteExcelData.writeHealthInsuranceBrandName(insuranceBrandName, filepath);
	}

	@Test(priority = 10)
	public void testWriteHealthInsurancePlan() {
		List<String> insurancePlan = health.getInsurancePlan();
		WriteExcelData.writeHealthInsurancePlan(insurancePlan, filepath);
	}
}
