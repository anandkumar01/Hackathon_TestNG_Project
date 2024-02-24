package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.HealthInsurancePage;

public class TC004_HealthInsurance extends BaseClass {
	HealthInsurancePage health;

	@Test
	public void testHealthInsurance() throws IOException, InterruptedException {
		health = new HealthInsurancePage(driver);
		health.hoverMore();
		health.clickHealthInsurance();
		health.fillBasicDetails();
		health.printHealthInsuranceBrandName();
		health.printInsurancePlan();
	}
}
