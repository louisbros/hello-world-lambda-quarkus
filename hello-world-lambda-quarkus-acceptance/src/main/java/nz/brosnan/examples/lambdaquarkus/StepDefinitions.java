package nz.brosnan.examples.lambdaquarkus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.inject.Inject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nz.brosnan.examples.lambdaquarkus.service.LambdaService;

public class StepDefinitions {
    @Inject
    private ResultHolder<String, String> results;
    @Inject
    private LambdaService lambdaService;

    @Given("I have a function")
    public void i_have_a_function() {
        assertNotNull(this.lambdaService);
    }

    @When("I call the function")
    public void i_call_the_function() {
        this.results.put("result", this.lambdaService.invoke("World"));
    }

    @Then("I should receive an output")
    public void i_should_receive_an_output() {
        assertEquals(this.results.get("result").contains("Hello World"), true);
    }
}
