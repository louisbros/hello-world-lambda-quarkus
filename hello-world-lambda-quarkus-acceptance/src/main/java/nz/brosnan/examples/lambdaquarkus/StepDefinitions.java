package nz.brosnan.examples.lambdaquarkus;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Test;

public class StepDefinitions {

    @Given("I have a function")
    public void i_have_a_function() {
        throw new io.cucumber.java.PendingException();
    }

    @When("I call the function")
    public void i_call_the_function() {
        throw new io.cucumber.java.PendingException();
    }

    @Then("I should receive an output")
    public void i_should_receive_an_output() {
        throw new io.cucumber.java.PendingException();
    }
}
