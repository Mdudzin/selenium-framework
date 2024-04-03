package pl.com.madu.exceptions;

public class NoSuchBrowserException extends Exception {

  public NoSuchBrowserException(String browser) {
    super(browser + " is not supported or the name of the browser is incorrect.");
  }
}
