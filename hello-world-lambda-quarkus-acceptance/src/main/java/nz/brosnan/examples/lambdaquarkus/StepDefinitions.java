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
    private ResultMap<String, String> resultMap;
    @Inject
    private LambdaService lambdaService;

    @Given("I have a function")
    public void i_have_a_function() {
        assertNotNull(this.lambdaService);
    }

    @When("I call the function")
    public void i_call_the_function() {
        this.resultMap.put("result", this.lambdaService.invoke("World"));
    }

    @Then("I should receive an output")
    public void i_should_receive_an_output() {
        assertEquals(this.resultMap.get("result").contains("Hello World"), true);
    }
}
