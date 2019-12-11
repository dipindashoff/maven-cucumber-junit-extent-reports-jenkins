package pageActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import reusableMethods.CommonMethods;

public class CommonSteps extends CommonMethods {
	public static WebDriver driver;

	public static void launchBrowser() {
		System.out.println("Launch Browser");

		System.setProperty("webdriver", "chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get(getProperty("url"));

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		// Take screenshot
		// Extent report log
		test.log(LogStatus.PASS, "Google Home page" + test.addScreenCapture(takeScreenshot()));

	}

}
