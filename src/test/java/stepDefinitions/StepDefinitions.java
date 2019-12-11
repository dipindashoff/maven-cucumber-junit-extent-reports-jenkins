package stepDefinitions;

import cucumber.api.java8.En;
import pageActions.CommonSteps;

public class StepDefinitions extends CommonSteps implements En {

	public StepDefinitions() {

		Given("^I launch the browser$", () -> {
			CommonSteps.launchBrowser();
		});

		When("^I navigate to Google Home page$", () -> {

		});

		Then("^I enter search text$", () -> {

		});
	}

//	@Given("^I launch the browser$")
//	public void I_launch() {
//		launchBrowser();
//	}
//
//	@Given("^I navigate to Google Home page$")
//	public void I_navi() {
//
//	}
//
//	@Given("^I enter search text$")
//	public void I_Search() {
//
//	}

}
