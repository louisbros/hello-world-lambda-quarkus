package nz.brosnan.examples.lambdaquarkus;

import java.util.Map;
import nz.brosnan.examples.lambdaquarkus.config.StackConfig;
import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Duration;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Runtime;
import software.amazon.awscdk.services.lambda.SingletonFunction;
import software.amazon.awscdk.services.s3.Bucket;

public class HelloWorldLambdaQuarkusInfraStack extends Stack {
    private StackConfig config;

    public HelloWorldLambdaQuarkusInfraStack(final Construct scope, final StackConfig config) {
        super(scope, config.getId(), null);
        this.config = config;

        Bucket artifactBucket = this.createArtifactBucket();

        this.createQuarkusFunction(artifactBucket);
        this.createQuarkusJarFunction(artifactBucket);
        this.createSpringBootJarFunction(artifactBucket);
    }

    private Bucket createArtifactBucket() {
        return Bucket.Builder.create(this, "hello-world-lambda-quarkus-artifacts")
            .bucketName("hello-world-lambda-quarkus-artifacts")
            .build();
    }

    private SingletonFunction createQuarkusFunction(Bucket artifactBucket) {
        Map<String, String> environment = Map.of("DISABLE_SIGNAL_HANDLERS", "true");

        return SingletonFunction.Builder.create(this, "hello-world-lambda-quarkus")
            .functionName("HelloWorldQuarkusLambda")
            .description("Hello World Quarkus Lambda")
            .code(Code.fromBucket(artifactBucket, "hello-world-lambda-quarkus-1.0-SNAPSHOT.zip"))
            .handler("not.used")
            .environment(environment)
            .timeout(Duration.seconds(30))
            .runtime(Runtime.PROVIDED)
            .memorySize(128)
            .uuid("hello-world-lambda-quarkus")
            .build();
    }

    private SingletonFunction createQuarkusJarFunction(Bucket artifactBucket) {
        Map<String, String> environment = Map.of("DISABLE_SIGNAL_HANDLERS", "true");

        return SingletonFunction.Builder.create(this, "hello-world-lambda-quarkus-jar")
            .functionName("HelloWorldQuarkusLambdaJar")
            .description("Hello World Quarkus Lambda Jar")
            .code(Code.fromBucket(artifactBucket,
                "hello-world-lambda-quarkus-1.0-SNAPSHOT-runner.jar"))
            .handler("io.quarkus.amazon.lambda.runtime.QuarkusStreamHandler::handleRequest")
            .environment(environment)
            .timeout(Duration.seconds(30))
            .runtime(Runtime.JAVA_11)
            .memorySize(512)
            .uuid("hello-world-lambda-quarkus-jar")
            .build();
    }

    private SingletonFunction createSpringBootJarFunction(Bucket artifactBucket) {
        Map<String, String> environment = Map.of("DISABLE_SIGNAL_HANDLERS", "true");

        return SingletonFunction.Builder.create(this, "hello-world-lambda-sb-jar")
            .functionName("HelloWorldSpringBootLambdaJar")
            .description("Hello World SpringBoot Lambda Jar")
            .code(Code.fromBucket(artifactBucket,
                "hello-world-lambda-sb-1.0-SNAPSHOT-lambda-package.zip"))
            .handler("nz.brosnan.examples.StreamLambdaHandler::handleRequest")
            .environment(environment)
            .timeout(Duration.seconds(30))
            .runtime(Runtime.JAVA_11)
            .memorySize(512)
            .uuid("hello-world-lambda-sb-jar")
            .build();
    }
}
