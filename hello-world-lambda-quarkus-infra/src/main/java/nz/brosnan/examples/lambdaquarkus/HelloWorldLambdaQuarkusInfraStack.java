package nz.brosnan.examples.lambdaquarkus;

import java.util.HashMap;
import java.util.Map;
import nz.brosnan.examples.lambdaquarkus.config.StackConfig;
import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Duration;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Runtime;
import software.amazon.awscdk.services.lambda.SingletonFunction;

public class HelloWorldLambdaQuarkusInfraStack extends Stack {
    private StackConfig config;

    public HelloWorldLambdaQuarkusInfraStack(final Construct scope, final StackConfig config) {
        super(scope, config.getId(), null);
        this.config = config;
        this.createFunction();
    }

    private void createFunction() {
        Map<String, String> environment = new HashMap<>();
        environment.put("DISABLE_SIGNAL_HANDLERS", "true");

        SingletonFunction.Builder.create(this, "hello-world-lambda-quarkus")
            .functionName("HelloWorldQuarkusLambda")
            .description("Hello World Quarkus Lambda")
            .code(Code.fromAsset(this.config.getLambdaArtifactPath()))
            .handler("not.used").environment(environment)
            .timeout(Duration.seconds(300)).runtime(Runtime.PROVIDED)
            .uuid(this.config.getLambdaId())
            .build();
    }
}
