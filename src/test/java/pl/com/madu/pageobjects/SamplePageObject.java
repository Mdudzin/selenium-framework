package pl.com.madu.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SamplePageObject extends PageObject {

  @FindBy(css = "textarea[id='APjFqb']")
  public WebElement searchInput;

  @FindBy(css = "input[name='btnK']")
  public WebElement googleSearchButton;

  @FindBy(css = "div[class='QS5gu sy4vM']")
  public WebElement acceptButton;

  public SamplePageObject(WebDriver driver) {
    super(driver);
  }

  @Override
  public SamplePageObject goToPage(String page) {
    driver.get(page);
    return this;
  }

  public SamplePageObject typeAndSearch(String text) {
    acceptButton.click();
    searchInput.sendKeys(text);
    googleSearchButton.click();
    return this;
  }
}
