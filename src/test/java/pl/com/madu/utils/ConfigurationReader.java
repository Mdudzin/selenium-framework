package pl.com.madu.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import pl.com.madu.exceptions.WrongConfigurationPathException;

public class ConfigurationReader {

  private final Properties properties;

  public ConfigurationReader(String configurationPath) throws WrongConfigurationPathException {
    this.properties = new Properties();
    readConfigurationFromFile(configurationPath);
  }

  private void readConfigurationFromFile(String configurationPath) throws WrongConfigurationPathException {
    try (BufferedReader reader = new BufferedReader(new FileReader(configurationPath))) {
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
