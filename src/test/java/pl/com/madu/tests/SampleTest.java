package pl.com.madu.tests;

import org.testng.annotations.Test;
import pl.com.madu.pageobjects.SamplePageObject;

public class SampleTest extends BaseTest {

  @Test
  public void test() {
    //given
    SamplePageObject googlePageObject = new SamplePageObject(driver);
    //when
    googlePageObject.goToPage("https://www.google.com/").typeAndSearch("test");
    //then
  }
}
