package pl.com.madu.exceptions;

public class WrongConfigurationPathException extends Exception {

  public WrongConfigurationPathException() {
    super(
        "Error reading configuration file. Check if the path to configuration file (configuration.properties) is correct.");
  }
}
