package testCases;

import org.testng.annotations.Test;

import factory.BaseClass;
import pageObjects.UsedCarPage;

public class TC004_UsedCarDetails extends BaseClass {
	UsedCarPage usedcar;

	@Test
	public void testUsedCars() throws InterruptedException {
		usedcar = new UsedCarPage(driver);
		usedcar.hoverUsedCars();
		usedcar.clickChennai();
		usedcar.scrollToPopularModel();
		usedcar.printPopularCarModels();
		usedcar.printAllPopularCarModelDetails();

	}
}
