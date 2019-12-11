package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import pageActions.CommonSteps;
import reusableMethods.CommonMethods;

public class Hooks {
	@Before
	public static void runReport() {
		CommonMethods.startExtent();
	}

	@After
	public static void tearDown() {
		CommonMethods.endExtent();
		CommonSteps.driver.quit();
	}

}
