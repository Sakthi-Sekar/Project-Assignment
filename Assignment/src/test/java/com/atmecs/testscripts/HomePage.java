package com.atmecs.testscripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.org.atmecs.constants.ConstantPaths;
import com.org.atmecs.helpers.PageActions;
import com.org.atmecs.reports.ExtentReport;
import com.org.atmecs.testbase.BaseClass;
import com.org.atmecs.testbase.InvokeBrowser;
import com.org.atmecs.testbase.OpenBrowser;
import com.org.atmecs.testbase.TestBase;
import com.org.atmecs.utils.ReadPropertiesFile;
import com.org.atmecs.utils.ValidateTestResult;

@Test(priority = 2)
public class HomePage extends InvokeBrowser {

	ReadPropertiesFile read = new ReadPropertiesFile();
	PageActions page;
	ExtentReport extent = new ExtentReport();
	
	

	public void homePage() {
		PageActions page = new PageActions(driver);
		


		page.click(read.readPropertiesFile("loc.clickdiagnostics.xpath", ConstantPaths.LOCATORS_FILE));
		page.click(read.readPropertiesFile("loc.selectcity.xpath", ConstantPaths.LOCATORS_FILE));

		String actualtext = read.readPropertiesFile("loc.validatetext.actual.xpath", ConstantPaths.LOCATORS_FILE);
		String expectedtext = read.readPropertiesFile("expectedtext", ConstantPaths.LOCATORS_FILE);
		ValidateTestResult.validateData(actualtext, expectedtext, "Match failed");
		System.out.println("Match found");

		JavascriptExecutor execute = (JavascriptExecutor) driver;
		Object texts = execute.executeScript("return document.querySelector(\"input[value='Bangalore']\").value;").toString();
		System.out.println(texts);
		Assert.assertEquals(texts, "Bangalore");
		System.out.println("Assertion");
		
		page.click(read.readPropertiesFile("loc.selectfield.css", ConstantPaths.LOCATORS_FILE));
		System.out.println("clicked");
		extent.reportLog("Testing homepage", "Failed");

	}
}
