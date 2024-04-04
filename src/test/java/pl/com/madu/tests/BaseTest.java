package pl.com.madu.tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pl.com.madu.exceptions.NoSuchBrowserException;
import pl.com.madu.exceptions.WrongConfigurationPathException;
import pl.com.madu.utils.ConfigReader;
import pl.com.madu.utils.DriverFactory;

public abstract class BaseTest {

  protected WebDriver driver;
  private ConfigReader configReader;
  private static final Duration WAIT_TIME = Duration.ofSeconds(10);
  private static final String CONFIG_PATH = "src/test/resources/configuration.properties";

  @BeforeClass
  public void loadConfig() throws WrongConfigurationPathException {
    configReader = new ConfigReader(CONFIG_PATH);
  }

  @BeforeMethod
  public void startDriver() {
    createAndSetDriver();
    maximizeWindow();
    setGlobalWaitTime(WAIT_TIME);
  }

  @AfterMethod
  public void quitDriver() {
    if (driver != null) {
      driver.quit();
    }
  }

  private void createAndSetDriver() {
    DriverFactory driverFactory = new DriverFactory();
    try {
      driver = driverFactory.createDriver(configReader);
    } catch (NoSuchBrowserException e) {
      throw new RuntimeException(e);
    }
  }

  private void setGlobalWaitTime(Duration time) {
    driver.manage().timeouts().implicitlyWait(time);
  }

  private void maximizeWindow() {
    driver.manage().window().maximize();
  }
}
