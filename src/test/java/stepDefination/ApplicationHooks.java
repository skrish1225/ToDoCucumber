package stepDefination;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import framework.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	// private ConfigReader configReader;
	Properties prop;

	// To read configuration from properties file {Have not implemented it}
	@Before(order = 0)
	public void getProperty() {
		// configReader = new ConfigReader();
		// prop = configReader.init_prop();
	}

	/**
	 * To launch browser {currently the value is hard coded to chrome}{I have not
	 * implemented properties file}
	 */
	@Before(order = 1)
	public void launchBrowser() {

		// String browserName = prop.getProperty("browser");
		String browserName = "Chrome";
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);

	}

	/**
	 * Closing browser
	 */
	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	/**
	 * Taking screenshot
	 * 
	 * @param scenario
	 */
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}

}
