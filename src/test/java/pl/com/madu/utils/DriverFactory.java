package pl.com.madu.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import pl.com.madu.exceptions.NoSuchBrowserException;

public class DriverFactory {

  public WebDriver createDriver(ConfigurationReader configReader) throws NoSuchBrowserException {
    String browser = configReader.getBrowser();

    switch (browser) {
      case "chrome" -> {
        return createChromeDriver(configReader);
      }
      case "edge" -> {
        return createEdgeDriver(configReader);
      }
      default -> throw new NoSuchBrowserException(browser);
    }
  }

  private WebDriver createChromeDriver(ConfigurationReader configReader) {
    boolean isHeadless = Boolean.parseBoolean(configReader.getHeadless());

    if (isHeadless) {
      return new ChromeDriver(new ChromeOptions().addArguments("--headless=new"));
    } else {
      return new ChromeDriver();
    }
  }

  private WebDriver createEdgeDriver(ConfigurationReader configReader) {
    boolean isHeadless = Boolean.parseBoolean(configReader.getHeadless());

    if (isHeadless) {
      return new EdgeDriver(new EdgeOptions().addArguments("--headless=new"));
    } else {
      return new EdgeDriver();
    }
  }
}
