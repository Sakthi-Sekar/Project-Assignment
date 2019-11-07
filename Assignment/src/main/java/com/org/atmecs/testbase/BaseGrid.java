package com.org.atmecs.testbase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseGrid {

	private static DesiredCapabilities getBrowserCapabilities(String browserType) {
		switch (browserType) {

		case "firefox":
			DesiredCapabilities descapability = new DesiredCapabilities();
			descapability.setCapability(CapabilityType.BROWSER_NAME, "firefox");
			return descapability;

		case "chrome":
			descapability = new DesiredCapabilities();
			descapability.setCapability(CapabilityType.BROWSER_NAME, "chrome");
			return descapability;

		default:
			descapability = new DesiredCapabilities();
			descapability.setCapability(CapabilityType.BROWSER_NAME, "internet explorer");
			return descapability;

		}
	}

	public static RemoteWebDriver getGrid(String browser) throws MalformedURLException {
		System.out.println("Grid is running");
		return new RemoteWebDriver(new URL(" http://40.40.40.148:2000/wd/hub"), getBrowserCapabilities(browser));
	}
}
