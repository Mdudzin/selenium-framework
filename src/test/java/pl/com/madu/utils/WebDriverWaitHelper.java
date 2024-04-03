package pl.com.madu.utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitHelper {

  private static final Duration WAIT_TIME = Duration.ofSeconds(10);

  private static WebDriverWait createWebDriverWait(WebDriver driver) {
    return new WebDriverWait(driver, WAIT_TIME);
  }

  public static void waitForElementToExist(WebDriver driver, By locator) {
    WebDriverWait wait = createWebDriverWait(driver);
    wait.until(ExpectedConditions.presenceOfElementLocated(locator));
  }

  public static void waitForElementToBeVisible(WebDriver driver, WebElement webElement) {
    WebDriverWait wait = createWebDriverWait(driver);
    wait.until(ExpectedConditions.visibilityOf(webElement));
  }

  public static void waitForElementToBeClickable(WebDriver driver, WebElement webElement) {
    WebDriverWait wait = createWebDriverWait(driver);
    wait.until(ExpectedConditions.elementToBeClickable(webElement));
  }
}
