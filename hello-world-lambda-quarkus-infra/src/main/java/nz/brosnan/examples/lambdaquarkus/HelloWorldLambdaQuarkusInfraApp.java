package nz.brosnan.examples.lambdaquarkus;

import nz.brosnan.examples.lambdaquarkus.config.StackConfig;
import software.amazon.awscdk.core.App;

public class HelloWorldLambdaQuarkusInfraApp {
    public static void main(final String[] args) {
        App app = new App();
        StackConfig config = StackConfig.builder()
            .id("HelloWorldLambdaQuarkusInfraStack")
            .build();

        new HelloWorldLambdaQuarkusInfraStack(app, config);

        app.synth();
    }
}
