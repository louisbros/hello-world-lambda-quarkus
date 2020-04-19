package nz.brosnan.examples.lambdaquarkus.service;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import nz.brosnan.examples.lambdaquarkus.config.Configuration;
import nz.brosnan.examples.lambdaquarkus.factory.LambdaClientFactory;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.lambda.model.InvokeRequest;

@ScenarioScoped
public class LambdaService {

    @Inject
    private Configuration config;

    @Inject
    private LambdaClientFactory lambdaClientFactory;

    public String invoke(String name) {
        SdkBytes payload = SdkBytes.fromUtf8String(String.format("{\n\"name\": \"%s\"\n}", name));

        InvokeRequest request = InvokeRequest
            .builder()
            .functionName(this.config.get("lambda.functionName"))
            .payload(payload).build();

        return this.lambdaClientFactory.create()
            .invoke(request).payload().asUtf8String();
    }
}
