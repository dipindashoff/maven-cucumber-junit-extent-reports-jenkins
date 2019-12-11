package reusableMethods;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import pageActions.CommonSteps;

public class CommonMethods {

	protected static ExtentTest test;
	protected static ExtentReports extent;

	public static String getProperty(String key) {

		Properties prop = null;
		try {
			prop = new Properties();
			prop.load(new FileInputStream(
					new File(System.getProperty("user.dir") + "/src/test/resources/Configurations/config.properties")));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return prop.getProperty(key);
	}

	public static void startExtent() {
		try {
			// 1 - Initializing Report
			extent = new ExtentReports(
					System.getProperty("user.dir") + "\\src\\test\\resources\\ExtentReports\\extent.html", false);

			// 2 - Adding System Info
			// By default, the OS, User Name, Java Version and Host Name will be available
			extent.addSystemInfo("Selenium Version", "3.141.59");
			extent.addSystemInfo("Environment", "local");

			// 3 - Configuration
			extent.loadConfig(new File(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Configurations\\config-extent.xml"));

			/* 4 -Starting test */
			// creates a toggle for the given test, adds all log events under it
			test = extent.startTest("Test Name", "Sample description");
			// Note: Declare ExtentTest test inside Act class
			// Act.test = extent.startTest("Give Test case ID here");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String takeScreenshot() {

		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\Screenshots\\screenshot.jpeg";

		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) CommonSteps.driver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File(path));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return path;
	}

	public static void endExtent() {
		try {
			// 6 .1- step log
//			test.log(LogStatus.PASS, "Logout from test", "Logged out successfully");
			// 6.2 - ending test
			extent.endTest(test); // use Act.test here

			// Writing to Report
			extent.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
