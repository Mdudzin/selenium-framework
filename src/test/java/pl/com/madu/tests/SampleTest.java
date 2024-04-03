package pl.com.madu.tests;

import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

  @Test
  public void test() {
    driver.get("https://www.google.com/");
  }
}
