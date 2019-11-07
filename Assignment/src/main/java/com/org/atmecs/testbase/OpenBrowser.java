package com.org.atmecs.testbase;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.org.atmecs.constants.ConstantPaths;
import com.org.atmecs.reports.LogReports;
import com.org.atmecs.utils.ReadPropertiesFile;
import com.org.atmecs.utils.ValidateTestResult;

public class OpenBrowser {
	public LogReports log = new LogReports();
	public WebDriver driver;
	Properties config = new Properties();
	protected ReadPropertiesFile read = new ReadPropertiesFile();
	protected String Xpath;

	protected ValidateTestResult validate = new ValidateTestResult();

//To invoke the chrome browser by  URL

	public String property;

	/**
	 * select driver class type
	 * 
	 * @param browserType
	 * @throws IOException
	 */
	
	@Parameters({ "browser" })
	@BeforeTest
	public void openBrowser(String browser) throws IOException {

		switch (browser) {

		case "chrome":

			ChromeOptions optionschrome = new ChromeOptions();
			optionschrome.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", ConstantPaths.CHROME_FILE);
			System.out.println("chrome " + Thread.currentThread().getId());
			driver = new ChromeDriver(optionschrome);
			break;

		case "firefox":

			System.setProperty("webdriver.gecko.driver", ConstantPaths.FIREFOX_FILE);
			driver = new FirefoxDriver();

			break;

		case "ie":

			System.setProperty("webdriver.ie.driver", ConstantPaths.IE_FILE);
			driver = new InternetExplorerDriver();
			System.out.println("IE " + Thread.currentThread().getId());
			break;

		}

		driver.manage().window().maximize();
		property = read.readPropertiesFile("url", ConstantPaths.CONFIG_FILE);
		// String Url = read.readPropertiesFile("url");
		driver.get(property);
	}
}
