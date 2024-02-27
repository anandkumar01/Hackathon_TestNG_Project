package testCases;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import factory.CrossBrowsing;
import pageObjects.HealthInsurancePage;
import utilities.WriteExcelData;

public class TC005_HealthInsurance extends CrossBrowsing {
	HealthInsurancePage health;
	String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.xlsx";

	@Test(priority = 0)
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

	@Test(priority = 1)
	public void testWriteHealthInsuranceBrandName() throws InterruptedException {
		logger.info("Written Health Insurance brand name in excel sheet");
		List<String> insuranceBrandName = health.getHealthInsuranceBrandName();
		WriteExcelData.writeHealthInsuranceBrandName(insuranceBrandName, filepath);
	}

	@Test(priority = 2)
	public void testWriteHealthInsurancePlan() {
		logger.info("Written Health Insurance plan in excel sheet");
		List<String> insurancePlan = health.getInsurancePlan();
		WriteExcelData.writeHealthInsurancePlan(insurancePlan, filepath);
	}
}
