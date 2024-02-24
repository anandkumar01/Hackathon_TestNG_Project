package factory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	protected WebDriver driver;
	protected Properties property;

	@BeforeClass
	public WebDriver initializeBrowser() throws IOException {
		if (getProperties().getProperty("execution_env").equalsIgnoreCase("local")) {
			String browser = getProperties().getProperty("browser").toLowerCase();

			switch (browser) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("No matching browser");
				driver = null;
			}
		}

		if (driver != null) {
			driver.manage().deleteAllCookies();
			driver.get(property.getProperty("baseUrl"));
			driver.manage().window().maximize();
		}
		return driver;
	}

	@AfterClass
	public void closeBrowser() {
		if (driver != null) {
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
