package nz.brosnan.examples.lambdaquarkus;

import java.util.UUID;
import nz.brosnan.examples.lambdaquarkus.config.StackConfig;
import software.amazon.awscdk.core.App;

public class HelloWorldLambdaQuarkusInfraApp {
    public static void main(final String[] args) {
        App app = new App();
        StackConfig config = new StackConfig()
            .setId("HelloWorldLambdaQuarkusInfraStack")
            .setLambdaId(UUID.randomUUID().toString())
            .setLambdaArtifactPath("../hello-world-lambda-quarkus/target/function.zip");

        new HelloWorldLambdaQuarkusInfraStack(app, config);

        app.synth();
    }
}
