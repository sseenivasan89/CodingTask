package StepDefinitions;

import PageClass.TimeCounterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class TimeCounterSteps extends TimeCounterPage{
	
	@Given("I launch the application")
	public void i_launch_the_application() {
	    launchApplication();
	}

	@Then("I enter the time in {string} seconds")
	public void i_enter_the_time_in_seconds(String string) {
	   enterTime();
	}

	@Then("I validate the time counter")
	public void i_validate_the_time_counter() {
	    validateTimeCounter();
	}

}
