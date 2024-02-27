package testCases;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import factory.CrossBrowsing;
import pageObjects.HealthInsurancePage;
import utilities.WriteExcelData;

public class TC004_HealthInsurance extends CrossBrowsing {
	HealthInsurancePage health;
	String filepath = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata.xlsx";

	@Test(priority = 0)
	public void testHealthInsurance() throws IOException, InterruptedException {
		health = new HealthInsurancePage(driver);
		health.hoverMore();
		health.clickHealthInsurance();
		health.fillBasicDetails();
		health.printHealthInsuranceBrandName();
		health.printInsurancePlan();
	}

	@Test(priority = 1)
	public void testWriteHealthInsuranceBrandName() throws InterruptedException {
		List<String> insuranceBrandName = health.getHealthInsuranceBrandName();
		WriteExcelData.writeHealthInsuranceBrandName(insuranceBrandName, filepath);
	}

	@Test(priority = 2)
	public void testWriteHealthInsurancePlan() {
		List<String> insurancePlan = health.getInsurancePlan();
		WriteExcelData.writeHealthInsurancePlan(insurancePlan, filepath);
	}
}
