package com.org.atmecs.grid;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class SeleniumGrid {

public WebDriver driver;
String baseURL, nodeURL;

@Test
public void setUp() throws MalformedURLException {
baseURL = "https://www.atmecs.com";
nodeURL = "http://40.40.40.148:2000/wd/hub";
DesiredCapabilities capability = DesiredCapabilities.chrome();
capability.setBrowserName("chrome");
capability.setPlatform(Platform.WINDOWS);
driver = new RemoteWebDriver(new URL(nodeURL), capability);
driver.get(baseURL);
}
}