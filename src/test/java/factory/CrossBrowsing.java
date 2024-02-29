package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowsing {
	protected WebDriver driver;
	protected Properties property;
	protected Logger logger;

	@BeforeClass(groups = { "sanity" })
	@Parameters({ "browser" })
	public WebDriver initializeBrowser(@Optional("Edge") String browser) throws IOException {
		logger = LogManager.getLogger(this.getClass());
		logger.info("Setting the driver");

		try {
			if (getProperties().getProperty("execution_env").equalsIgnoreCase("remote")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();

				// setting up operating system for remote
				if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
					capabilities.setPlatform(Platform.WIN11);
				} else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
					capabilities.setPlatform(Platform.MAC);
				} else {
					System.out.println("No matching OS..");
				}
				// setting up the browser for remote
				switch (getProperties().getProperty("browser").toLowerCase()) {
				case "chrome":
					capabilities.setBrowserName("chrome");
					break;
				case "edge":
					capabilities.setBrowserName("MicrosoftEdge");
					break;
				default:
					System.out.println("No matching browser");
				}

				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

				// setting up the environment as local machine
			} else if (getProperties().getProperty("execution_env").equalsIgnoreCase("local")) {

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

	@AfterClass(groups = { "sanity" })
	public void closeBrowser() {
		if (driver != null) {
			System.out.println("\nClosing the browser session..");
			driver.quit();
		}
	}

	// creating a method to fetch th data from properties file
	public Properties getProperties() throws IOException {
		String propertyFile = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
		try (FileReader file = new FileReader(propertyFile)) {
			property = new Properties();
			property.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return property;
	}
}
