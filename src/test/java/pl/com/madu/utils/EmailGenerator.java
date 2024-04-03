package pl.com.madu.utils;

import java.util.Random;

public class EmailGenerator {

  public static String generateRandomEmail() {
    Random random = new Random();
    String[] prefixes = {"john", "jane", "doe", "smith", "alex"};
    String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "example.com", "test.com"};
    String prefix = prefixes[random.nextInt(prefixes.length)];
    String domain = domains[random.nextInt(domains.length)];
    int randomNumber = random.nextInt(1000);
    return prefix + randomNumber + "@" + domain;
  }
}
