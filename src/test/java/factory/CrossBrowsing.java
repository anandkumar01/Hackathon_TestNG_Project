package factory;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowsing {
	protected WebDriver driver;
	protected Properties property;
	protected Logger logger;

	@BeforeClass(groups = { "smoke" })
	@Parameters({ "browser" })
	public WebDriver initializeBrowser(@Optional("Edge") String browser) throws IOException {
		logger = LogManager.getLogger(this.getClass());
		logger.info("Setting the driver");

		try {
			if (getProperties().getProperty("execution_env").equalsIgnoreCase("local")) {

				switch (browser.toLowerCase()) {
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				case "edge":
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;
				default:
					System.out.println("No matching browser");
					driver = null;
				}
			}

			if (driver != null) {
				System.out.println("\nStarting the browser session..\n");
				driver.manage().deleteAllCookies();
				driver.get(property.getProperty("baseUrl"));
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			}

		} catch (Exception e) {
			System.err.println("Error during browser initialization: " + e.getMessage());
			e.printStackTrace();
		}
		return driver;
	}

	@AfterClass(groups = { "smoke" })
	public void closeBrowser() {
		if (driver != null) {
			System.out.println("\nClosing the browser session..");
			driver.quit();
		}
	}

	public Properties getProperties() throws IOException {
		String propertyFile = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
		try (FileReader file = new FileReader(propertyFile)) {
			property = new Properties();
			property.load(file);
		}
		return property;
	}
}
