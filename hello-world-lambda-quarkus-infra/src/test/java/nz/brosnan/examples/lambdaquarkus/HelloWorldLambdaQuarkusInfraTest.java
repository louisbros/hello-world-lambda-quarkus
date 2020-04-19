package nz.brosnan.examples.lambdaquarkus;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import nz.brosnan.examples.lambdaquarkus.config.StackConfig;
import org.junit.Test;
import software.amazon.awscdk.core.App;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class HelloWorldLambdaQuarkusInfraTest {
    private final static ObjectMapper JSON =
        new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true);

    @Test
    public void testStack() throws IOException {
        // Given
        App app = new App();
        StackConfig config = new StackConfig()
            .setId("test")
            .setLambdaId("test")
            .setLambdaArtifactPath("./src/test/resources/function");

        HelloWorldLambdaQuarkusInfraStack stack = new HelloWorldLambdaQuarkusInfraStack(app, config);

        // When
        JsonNode actual = JSON.valueToTree(app.synth().getStackArtifact(stack.getArtifactId()).getTemplate());

        // Then
        JsonNode expected = JSON
            .readTree(this.getClass().getResourceAsStream("/stack.json"));

        assertEquals(expected, actual);
    }
}
