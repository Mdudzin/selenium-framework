package pl.com.madu.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject {

  protected WebDriver driver;

  public PageObject(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public abstract PageObject goToPage(String page);
}
