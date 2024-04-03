package pl.com.madu.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import pl.com.madu.exceptions.WrongConfigurationPathException;

public class ConfigReader {
  private final Properties properties;

  public ConfigReader(String configPath) throws WrongConfigurationPathException {
    this.properties = new Properties();
    readConfigurationFromFile(configPath);
  }

  private void readConfigurationFromFile(String configPath) throws WrongConfigurationPathException {
    try (BufferedReader reader = new BufferedReader(new FileReader(configPath))) {
      properties.load(reader);
    } catch (IOException e) {
      throw new WrongConfigurationPathException();
    }
  }

  public String getBrowser() {
    return properties.getProperty("browser");
  }

  public String getHeadless() {
    return properties.getProperty("headless");
  }
}
