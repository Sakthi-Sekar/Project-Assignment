package com.org.atmecs.testbase;

import java.io.IOException;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import com.org.atmecs.constants.ConstantPaths;

import com.org.atmecs.reports.LogReports;
import com.org.atmecs.utils.ReadPropertiesFile;
import com.org.atmecs.utils.ValidateTestResult;

public class TestBase {

	public WebDriver driver;
	public LogReports log = new LogReports();
	public ReadPropertiesFile read = new ReadPropertiesFile();
	public ValidateTestResult validate =new ValidateTestResult();
	String Url;
	public String Xpath;

	@SuppressWarnings("deprecation")
	@Parameters("browsername")
	@BeforeTest
	public void invokeBrowser(String base) throws IOException {
		String modeofrunning = "grid";
		Url = read.readPropertiesFile("url", ConstantPaths.CONFIG_FILE);
		if (modeofrunning.equalsIgnoreCase("grid")) {
			driver =BaseGrid.getGrid(base);
			System.out.println(driver);
		} 
		else {

// String base = Readproperties.readPropertiesFile("Browser", ConstantPaths.CONFIG_FILE);

			if (base.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", ConstantPaths.CHROME_FILE);
				driver = new ChromeDriver();
				log.info("Chrome browser launched...");

			} else if (base.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", ConstantPaths.FIREFOX_FILE);
				driver = new FirefoxDriver();
				log.info("Firefox browser launched...");

			} else if (base.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", ConstantPaths.IE_FILE);
				DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
				ieCaps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
				driver = new InternetExplorerDriver(ieCaps);
				log.info("IE browser started...");
			}
		}
			driver.get(Url);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.MINUTES);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			log.info("Application is open...");
	
	}

	@AfterTest
	public void closeBrowser() {
		// driver.quit();
	}

}
