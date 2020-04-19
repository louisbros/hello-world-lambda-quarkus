package nz.brosnan.examples.lambdaquarkus.factory;

import io.cucumber.guice.ScenarioScoped;
import software.amazon.awssdk.services.lambda.LambdaClient;

@ScenarioScoped
public class LambdaClientFactory {
    public LambdaClient create() {
        return LambdaClient.builder().build();
    }
}
